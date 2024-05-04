package com.fastcampus.boardserver.auth.model.dao.reqeust;

import com.fastcampus.boardserver.auth.model.dto.UserUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserUpdateDAO {
    private String userId;
    private String password;
    private String nickname;
    private boolean isAdmin;
    private boolean isWithDraw;
    private Date updatedAt;

    public UserUpdateDAO(UserUpdateDTO dto){
        this.userId = dto.getUserId();
        this.nickname = dto.getNickname();
        this.isAdmin = dto.isAdmin();
        this.isWithDraw = dto.isWithDraw();
        this.updatedAt = dto.getUpdatedAt();
    }
}
