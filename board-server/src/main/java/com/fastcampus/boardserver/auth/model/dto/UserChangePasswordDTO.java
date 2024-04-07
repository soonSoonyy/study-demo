package com.fastcampus.boardserver.auth.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserChangePasswordDTO {
    private String currentPassword;
    private String newPassword;
}
