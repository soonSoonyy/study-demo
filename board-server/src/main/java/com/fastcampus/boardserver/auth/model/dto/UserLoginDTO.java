package com.fastcampus.boardserver.auth.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLoginDTO {
    private String userId;
    private String password;
}
