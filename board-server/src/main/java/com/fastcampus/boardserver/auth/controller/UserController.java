package com.fastcampus.boardserver.auth.controller;

import com.fastcampus.boardserver.auth.exception.NotExistUserException;
import com.fastcampus.boardserver.auth.exception.UnSupportedException;
import com.fastcampus.boardserver.auth.model.LoginResponse;
import com.fastcampus.boardserver.auth.model.dto.UserChangePasswordDTO;
import com.fastcampus.boardserver.auth.model.dto.UserDeleteDTO;
import com.fastcampus.boardserver.auth.model.dto.UserLoginDTO;
import com.fastcampus.boardserver.auth.model.dto.UserRegisterDTO;
import com.fastcampus.boardserver.auth.model.enums.UserStatus;
import com.fastcampus.boardserver.auth.model.vo.UserVO;
import com.fastcampus.boardserver.auth.service.SessionService;
import com.fastcampus.boardserver.auth.service.UserService;
import com.fastcampus.boardserver.global.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Log4j2
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final SessionService sessionService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> signup(
            @RequestBody UserRegisterDTO dto) {

        if(UserRegisterDTO.hasNullDataBeforeSignup(dto)) {
            throw new IllegalArgumentException("데이터가 올바르지 않습니다.");
        }

        userService.register(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<LoginResponse> login(@RequestBody UserLoginDTO dto, HttpSession session) {

        try {
            UserVO vo = userService.login(dto.getUserId(), dto.getPassword());

            sessionService.handleLoginSuccess(session, vo);
            return ResponseEntity.ok(LoginResponse.success(vo));
        } catch (NotExistUserException e){
            log.error("사용자 인증에 실패 하였습니다.", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        } catch (Exception e) {
            log.error("로그인 중 에러가 발생하였습니다.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/my-info")
    public ResponseEntity<UserVO> getMyInfo(HttpSession session) {
        try {
            if(session.getId() != null){
                UserVO vo = userService.getUserInfo(session.getId());
                return ResponseEntity.ok(vo);
            } else {
               throw new NotExistUserException("해당 유저는 없는 유저 입니다.");
            }
        }catch (NotExistUserException e){
            log.error("사용자 정보를 찾을 수 없습니다.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            log.error("사용자 정보를 찾는 중 에러가 발생하였습니다.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("logout")
    public void logout(HttpSession session) {
        SessionUtil.sessionClear(session);
    }


    @PatchMapping("password")
    public ResponseEntity<?> changePassword(@RequestBody UserChangePasswordDTO dto, HttpSession session){
        try{
            String id = session.getId();
            String beforePassword = dto.getCurrentPassword();
            String afterPassword = dto.getNewPassword();

            userService.updatePassword(id, beforePassword, afterPassword);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            log.error("비밀번호 변경 중 에러가 발생하였습니다.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody UserDeleteDTO dto, HttpSession session){
        try{

            UserVO user = userService.getUserInfo(session.getId());

            if(user.getUserStatus() != UserStatus.ADMIN){
                throw new UnSupportedException("해당 유저는 권한이 없습니다.");
            }

            userService.deleteId(dto.getUserId());
            return ResponseEntity.status(HttpStatus.OK).build();

        }catch (Exception e){
            log.error("계정 삭제 중 에러가 발생하였습니다.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
