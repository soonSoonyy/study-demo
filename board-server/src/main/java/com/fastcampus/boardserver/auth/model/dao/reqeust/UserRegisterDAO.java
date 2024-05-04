package com.fastcampus.boardserver.auth.model.dao.reqeust;

import com.fastcampus.boardserver.auth.model.dto.UserRegisterDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserRegisterDAO {
    private String userId;
    private String password;
    private String nickname;
    private boolean isAdmin;
    private boolean isWithDraw;
    private Date createdAt;

    public UserRegisterDAO(UserRegisterDTO dto){
        this.userId = dto.getUserId();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.isAdmin = dto.isAdmin();
        this.isWithDraw = dto.isWithDraw();
        this.createdAt = dto.getCreatedAt();
    }
}
