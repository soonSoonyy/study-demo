package com.fastcampus.boardserver.auth.service;

import com.fastcampus.boardserver.auth.model.dto.UserDTO;

public interface UserService {


    void register(UserDTO dto);

    UserDTO login(String id, String password);

    boolean isDuplicatedId(String id);

    UserDTO getUserInfo(String userId);

    void updatePassword(String id, String beforePassword, String afterPassword);

    void deleteId(String id);
}
