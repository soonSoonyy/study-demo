package com.fastcampus.boardserver.auth.model.vo;

import com.fastcampus.boardserver.auth.model.user.UserStatus;
import lombok.Getter;

import java.util.Date;

@Getter
public class UserVO {

    private String userId;
    private String nickname;
    private boolean isAdmin;
    private boolean isWithDraw;
    private UserStatus status;
    private Date createTime;
    private Date updateTime;
}
