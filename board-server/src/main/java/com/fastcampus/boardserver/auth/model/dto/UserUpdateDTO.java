package com.fastcampus.boardserver.auth.model.dto;

import com.fastcampus.boardserver.auth.model.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserUpdateDTO {

    public static boolean hasNullDataBeforeSignup(UserRegisterDTO dto) {
        return dto.getUserId() == null || dto.getPassword() == null || dto.getNickname() == null;
    }

    private String userId;
    private String nickname;
    private boolean isAdmin;
    private boolean isWithDraw;
    private UserStatus userStatus;
    private Date updateTime;


}
