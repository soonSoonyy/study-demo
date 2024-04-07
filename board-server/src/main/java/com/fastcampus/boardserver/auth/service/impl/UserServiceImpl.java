package com.fastcampus.boardserver.auth.service.impl;

import com.fastcampus.boardserver.auth.exception.DuplicatedIDException;
import com.fastcampus.boardserver.auth.exception.NotExistUserException;
import com.fastcampus.boardserver.auth.mapper.UserMapper;
import com.fastcampus.boardserver.auth.model.dao.reqeust.UserRegisterDAO;
import com.fastcampus.boardserver.auth.model.dao.reqeust.UserUpdateDAO;
import com.fastcampus.boardserver.auth.model.dao.response.UserDAO;
import com.fastcampus.boardserver.auth.model.dto.UserRegisterDTO;
import com.fastcampus.boardserver.auth.model.vo.UserVO;
import com.fastcampus.boardserver.auth.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.fastcampus.boardserver.global.util.SHA256Util.encryptSHA256;

@Service
@AllArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public void register(UserRegisterDTO dto) {
        boolean isDuplicated = isDuplicatedId(dto.getUserId());

        if(isDuplicated) {
            throw new DuplicatedIDException("중복된 아이디 입니다.");
        }

        dto.setPassword(encryptSHA256(dto.getPassword()));

        try{
            userMapper.insertUser(new UserRegisterDAO(dto));
        }catch (Exception e){
            throw new RuntimeException("가입 중 에러가 발생 하였습니다.");
        }
    }

    @Override
    public UserVO login(String userId, String password) {
        String cryptPassword = encryptSHA256(password);
        UserDAO dao = userMapper.selectUserByIdAndPassword(userId, cryptPassword);

        if(dao != null){
            return new UserVO(dao);
        }else{
            throw new NotExistUserException("해당 유저는 없는 유저 입니다.");
        }
    }

    @Override
    public boolean isDuplicatedId(String userId) {
        return userMapper.isDuplicatedId(userId);
    }

    @Override
    public UserVO getUserInfo(String userId) {
        UserDAO dao = userMapper.selectUserById(userId);

        if(dao != null){
            return new UserVO(dao);
        }else {
            throw new NotExistUserException("해당 유저는 없는 유저 입니다.");
        }
    }

    @Override
    public void updatePassword(String userId, String beforePassword, String afterPassword) {

        UserDAO user = userMapper.selectUserByIdAndPassword(userId, beforePassword);

        if(user != null){
            String newEncryptPassword = encryptSHA256(afterPassword);

            userMapper.updatePassword(
                    UserUpdateDAO.builder()
                            .userId(userId)
                            .password(newEncryptPassword)
                            .build());
        }else{
            throw new NotExistUserException("해당 유저는 없는 유저 입니다.");
        }

    }

    @Override
    public void deleteId(String userId) {
        UserDAO user = userMapper.selectUserById(userId);

        if(user != null){
            userMapper.deleteUserById(userId);
        }else{
            throw new NotExistUserException("해당 유저는 없는 유저 입니다.");
        }
    }
}
