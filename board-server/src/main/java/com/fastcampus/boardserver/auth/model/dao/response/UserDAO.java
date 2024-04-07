package com.fastcampus.boardserver.auth.model.dao.response;

import com.fastcampus.boardserver.auth.model.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDAO {
        private String userId;
        private String password;
        private String nickname;
        private UserStatus userStatus;
        private boolean isAdmin;
        private boolean isWithDraw;
        private Date createTime;
        private Date updateTime;

}
