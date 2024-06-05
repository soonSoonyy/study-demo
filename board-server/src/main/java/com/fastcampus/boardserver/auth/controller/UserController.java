package com.fastcampus.boardserver.auth.controller;

import com.fastcampus.boardserver.auth.aop.LoginCheck;
import com.fastcampus.boardserver.global.exception.CustomException;
import com.fastcampus.boardserver.global.exception.NotExistUserException;
import com.fastcampus.boardserver.global.exception.ForbiddenException;
import com.fastcampus.boardserver.auth.model.LoginResponse;
import com.fastcampus.boardserver.auth.model.dto.UserChangePasswordDTO;
import com.fastcampus.boardserver.auth.model.dto.UserDeleteDTO;
import com.fastcampus.boardserver.auth.model.dto.UserLoginDTO;
import com.fastcampus.boardserver.auth.model.dto.UserRegisterDTO;
import com.fastcampus.boardserver.auth.model.enums.UserStatus;
import com.fastcampus.boardserver.auth.model.vo.UserVO;
import com.fastcampus.boardserver.auth.service.SessionService;
import com.fastcampus.boardserver.auth.service.UserService;
import com.fastcampus.boardserver.global.response.CommonResponse;
import com.fastcampus.boardserver.global.response.ResultCode;
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
    public CommonResponse<UserVO> signup(
            @RequestBody UserRegisterDTO dto) {
        try {

            if (UserRegisterDTO.hasNullDataBeforeSignup(dto)) {
                throw new IllegalArgumentException("데이터가 올바르지 않습니다.");
            }

            userService.register(dto);
            UserVO vo = userService.getUserInfo(dto.getUserId());

            if(vo == null) {
                throw new NotExistUserException();
            }

            return CommonResponse
                    .<UserVO>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .body(vo)
                    .build();
        } catch (CustomException e) {
            return CommonResponse
                    .<UserVO>builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .<UserVO>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }

    }

    @PostMapping("/sign-in")
    public CommonResponse<LoginResponse> login(HttpSession session, @RequestBody UserLoginDTO dto) {

        try {
            UserVO vo = userService.login(dto.getUserId(), dto.getPassword());
            sessionService.handleLoginSuccess(session, vo);
            return CommonResponse
                    .<LoginResponse>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .build();
        } catch (CustomException e) {
            return CommonResponse
                    .<LoginResponse>builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();

        } catch (Exception e) {
            return CommonResponse
                    .<LoginResponse>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }


    @GetMapping("/my-info")
    @LoginCheck(userType = LoginCheck.UserType.ALL)
    public CommonResponse<UserVO> getMyInfo(String accountId) {
        try {
            if (accountId != null) {
                UserVO vo = userService.getUserInfo(accountId);
                return CommonResponse
                        .<UserVO>builder()
                        .code(ResultCode.SUCCESS.getCode())
                        .status(ResultCode.SUCCESS.getHttpStatus())
                        .body(vo)
                        .build();
            } else {
                throw new NotExistUserException();
            }
        } catch (CustomException e) {
            log.error("사용자 정보를 찾을 수 없습니다.", e);
            return CommonResponse
                    .<UserVO>builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .<UserVO>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }

    @PutMapping("logout")
    public CommonResponse<Void> logout(HttpSession session) {

        try {
            SessionUtil.sessionClear(session);
            return CommonResponse
                    .<Void>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .<Void>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();

        }
    }


    @PatchMapping("password")
    @LoginCheck(userType = LoginCheck.UserType.ALL)
    public CommonResponse<Void> changePassword(String accountId, @RequestBody UserChangePasswordDTO dto) {
        try {
            String id = accountId;
            String beforePassword = dto.getCurrentPassword();
            String afterPassword = dto.getNewPassword();

            userService.updatePassword(id, beforePassword, afterPassword);
            return CommonResponse
                    .<Void>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .build();
        } catch (CustomException e) {
            return CommonResponse
                    .<Void>builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .<Void>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }

    @PostMapping("/delete")
    @LoginCheck(userType = LoginCheck.UserType.ADMIN)
    public CommonResponse<Void> dropUser(String accountId, @RequestBody UserDeleteDTO dto) {
        try {

            UserVO user = userService.getUserInfo(accountId);

            if (user.getUserStatus() != UserStatus.ADMIN) {
                throw new ForbiddenException();
            }

            userService.dropId(dto.getUserId());
            return CommonResponse
                    .<Void>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .build();

        }catch (CustomException e){
            return CommonResponse
                    .<Void>builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        }catch (Exception e) {
            return CommonResponse
                    .<Void>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }

    @PostMapping("withdrawal")
    @LoginCheck(userType = LoginCheck.UserType.USER)
    public CommonResponse<Void> deleteUser(String accountId) {
        try {

            userService.deleteId(accountId);
            return CommonResponse
                    .<Void>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .build();

        } catch (CustomException e){
            return CommonResponse
                    .<Void>builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        }catch (Exception e) {
            return CommonResponse
                    .<Void>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }
}
