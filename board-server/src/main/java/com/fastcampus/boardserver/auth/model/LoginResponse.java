package com.fastcampus.boardserver.auth.model;

import com.fastcampus.boardserver.auth.model.enums.LoginStatus;
import com.fastcampus.boardserver.auth.model.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class LoginResponse {

    @NonNull
    private LoginStatus result;
    private UserVO vo;


    public static final LoginResponse FAIL = new LoginResponse(LoginStatus.FAIL);

    public static LoginResponse success(UserVO vo) {
        return new LoginResponse(LoginStatus.SUCCESS, vo);
    }
}
