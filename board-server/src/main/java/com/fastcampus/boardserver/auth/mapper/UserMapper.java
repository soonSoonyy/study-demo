package com.fastcampus.boardserver.auth.mapper;

import com.fastcampus.boardserver.auth.model.dao.reqeust.UserRegisterDAO;
import com.fastcampus.boardserver.auth.model.dao.reqeust.UserUpdateDAO;
import com.fastcampus.boardserver.auth.model.dao.response.UserDAO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    UserDAO selectUserById(String userId);

    UserDAO selectUserByIdAndPassword(String userId, String password);

    void insertUser(UserRegisterDAO dao);

    void withDrawUserById(UserUpdateDAO dao);

    void deleteUserById(String userId);

    Integer isDuplicatedId(String userId);

    void updatePassword(UserUpdateDAO dao);



}
