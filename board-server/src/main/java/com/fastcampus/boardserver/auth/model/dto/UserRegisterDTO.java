package com.fastcampus.boardserver.auth.model.dto;

import com.fastcampus.boardserver.auth.model.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserRegisterDTO {

    public static boolean hasNullDataBeforeSignup(UserRegisterDTO dto) {
        return dto.getUserId() == null || dto.getPassword() == null || dto.getNickname() == null;
    }

    private String userId;
    private String password;
    private String nickname;
    private boolean isAdmin;
    private boolean isWithDraw;
    private Date createdAt;

}
