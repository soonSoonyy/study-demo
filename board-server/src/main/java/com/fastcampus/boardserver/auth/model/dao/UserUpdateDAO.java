package com.fastcampus.boardserver.auth.model.dao;

import com.fastcampus.boardserver.auth.model.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class UserUpdateDAO {
    private String userId;
    private String password;
    private String nickname;
    private boolean isAdmin;
    private boolean isWithDraw;
    private Date updateTime;

    public UserUpdateDAO(UserDTO dto){
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.isAdmin = dto.isAdmin();
        this.isWithDraw = dto.isWithDraw();
        this.updateTime = dto.getUpdateTime();
    }
}
