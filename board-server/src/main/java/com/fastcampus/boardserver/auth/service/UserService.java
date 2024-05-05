package com.fastcampus.boardserver.auth.service;

import com.fastcampus.boardserver.auth.model.dto.UserRegisterDTO;
import com.fastcampus.boardserver.auth.model.vo.UserVO;

public interface UserService {


    void register(UserRegisterDTO dto);

    UserVO login(String id, String password);

    boolean isDuplicatedId(String userId);

    UserVO getUserInfo(String userId);

    void updatePassword(String id, String beforePassword, String afterPassword);

    void dropId(String userId);

    void deleteId(String userId);

}
