package com.fastcampus.boardserver.auth.mapper;

import com.fastcampus.boardserver.auth.model.dao.response.UserDAO;
import com.fastcampus.boardserver.auth.model.dao.reqeust.UserRegisterDAO;
import com.fastcampus.boardserver.auth.model.dao.reqeust.UserUpdateDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserDAO selectUserById(@Param("userId") String userId);

    UserDAO selectUserByIdAndPassword(@Param("userId") String userId, @Param("password") String password);

    void insertUser(UserRegisterDAO dao);

    void deleteUserById(@Param("userId") String userId);

    boolean isDuplicatedId(@Param("userId") String userId);

    void updatePassword(UserUpdateDAO dao);



}
