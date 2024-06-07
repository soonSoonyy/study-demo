package com.fastcampus.boardserver.auth.model.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDAO {
        private String userId;
        private String password;
        private String nickname;
        private boolean isAdmin;
        private boolean isWithDraw;
        private Date createTime;
        private Date updateTime;


}
