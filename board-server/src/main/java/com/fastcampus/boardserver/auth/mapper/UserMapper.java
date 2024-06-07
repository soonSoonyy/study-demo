package com.fastcampus.boardserver.auth.mapper;

import com.fastcampus.boardserver.auth.model.dao.UserDAO;
import com.fastcampus.boardserver.auth.model.dao.UserRegisterDAO;
import com.fastcampus.boardserver.auth.model.dao.UserUpdateDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public UserDAO selectUserById(@Param("userId") String userId);

    public UserDAO selectUserByIdAndPassword(@Param("userId") String userId, @Param("password") String password);

    public void insertUser(UserRegisterDAO dao);

    public void deleteUserById(@Param("userId") String userId);

    public boolean isDuplicatedId(@Param("userId") String userId);

    public void updatePassword(UserUpdateDAO dao);



}
