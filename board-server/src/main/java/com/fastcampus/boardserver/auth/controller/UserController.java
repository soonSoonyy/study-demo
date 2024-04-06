package com.fastcampus.boardserver.auth.controller;

import com.fastcampus.boardserver.auth.exception.NotExistUserException;
import com.fastcampus.boardserver.auth.model.dto.LoginResponse;
import com.fastcampus.boardserver.auth.model.dto.UserDTO;
import com.fastcampus.boardserver.auth.model.dto.UserLoginDTO;
import com.fastcampus.boardserver.auth.service.SessionService;
import com.fastcampus.boardserver.auth.service.UserService;
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
            @RequestBody UserDTO dto) {

        if(UserDTO.hasNullDataBeforeSignup(dto)) {
            throw new IllegalArgumentException("데이터가 올바르지 않습니다.");
        }

        userService.register(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<LoginResponse> login(@RequestBody UserLoginDTO dto, HttpSession session) {

        try {
            UserDTO user = userService.login(dto.getUserId(), dto.getPassword());

            sessionService.handleLoginSuccess(user, session);
            return ResponseEntity.ok(LoginResponse.success(user));
        } catch (NotExistUserException e){
            log.error("사용자 인증에 실패 하였습니다.", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        } catch (Exception e) {
            log.error("로그인 중 에러가 발생하였습니다.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
