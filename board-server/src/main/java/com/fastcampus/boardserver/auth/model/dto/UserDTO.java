package com.fastcampus.boardserver.auth.model.dto;

import com.fastcampus.boardserver.auth.model.dao.UserDAO;
import com.fastcampus.boardserver.auth.model.user.UserStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserDTO {

    public static boolean hasNullDataBeforeSignup(UserDTO dto) {
        return dto.getUserId() == null || dto.getPassword() == null || dto.getNickname() == null;
    }

    private int seq;
    private String userId;
    private String password;
    private String nickname;
    private boolean isAdmin;
    private boolean isWithDraw;
    private UserStatus status;
    private Date createTime;
    private Date updateTime;

    public UserDTO(UserDAO dao) {
        this.userId = dao.getUserId();
        this.password = dao.getPassword();
        this.nickname = dao.getNickname();
        this.isAdmin = dao.isAdmin();
        this.isWithDraw = dao.isWithDraw();
        this.createTime = dao.getCreateTime();
        this.updateTime = dao.getUpdateTime();
    }
}
