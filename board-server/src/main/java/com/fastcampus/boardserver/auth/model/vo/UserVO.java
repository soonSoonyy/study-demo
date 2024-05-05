package com.fastcampus.boardserver.auth.model.vo;

import com.fastcampus.boardserver.auth.model.dao.response.UserDAO;
import com.fastcampus.boardserver.auth.model.enums.UserStatus;
import lombok.Getter;

import java.util.Date;

@Getter
public class UserVO {

    private final String userId;
    private final String nickname;
    private final boolean isAdmin;
    private final boolean isWithDraw;
    private final UserStatus userStatus;
    private final Date createdAt;
    private final Date updatedAt;

    public UserVO(UserDAO dao) {
        this.userId = dao.getUserId();
        this.nickname = dao.getNickname();
        this.isAdmin = dao.isAdmin();
        this.isWithDraw = dao.isWithDraw();
        this.userStatus = dao.isAdmin() ? UserStatus.ADMIN : dao.isWithDraw() ? UserStatus.DELETE : UserStatus.DEFAULT;
        this.createdAt = dao.getCreatedAt();
        this.updatedAt = dao.getUpdatedAt();
    }

}
