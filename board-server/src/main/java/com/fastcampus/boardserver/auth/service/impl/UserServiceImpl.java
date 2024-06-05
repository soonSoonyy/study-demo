package com.fastcampus.boardserver.auth.service.impl;

import com.fastcampus.boardserver.global.exception.DuplicatedIDException;
import com.fastcampus.boardserver.global.exception.NotExistUserException;
import com.fastcampus.boardserver.auth.mapper.UserMapper;
import com.fastcampus.boardserver.auth.model.dao.reqeust.UserRegisterDAO;
import com.fastcampus.boardserver.auth.model.dao.reqeust.UserUpdateDAO;
import com.fastcampus.boardserver.auth.model.dao.response.UserDAO;
import com.fastcampus.boardserver.auth.model.dto.UserRegisterDTO;
import com.fastcampus.boardserver.auth.model.vo.UserVO;
import com.fastcampus.boardserver.auth.service.UserService;
import com.fastcampus.boardserver.global.util.SHA256Util;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;

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
            throw new DuplicatedIDException();
        }

        dto.setPassword(encryptSHA256(dto.getPassword()));
        dto.setCreatedAt(new Date());

        try{
            UserRegisterDAO dao = new UserRegisterDAO(dto);
            userMapper.insertUser(dao);
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
            throw new NotExistUserException();
        }
    }

    @Override
    public boolean isDuplicatedId(String userId) {
        if(userId == null || userId.isEmpty()){
            throw new IllegalArgumentException("아이디를 입력해 주세요.");
        }
        return userMapper.isDuplicatedId(userId) > 0 ;
    }

    @Override
    public UserVO getUserInfo(String userId) {
        UserDAO dao = userMapper.selectUserById(userId);

        if(dao != null){
            return new UserVO(dao);
        }else {
            throw new NotExistUserException();
        }
    }

    @Override
    public void updatePassword(String userId, String beforePassword, String afterPassword) {

        UserDAO user = userMapper.selectUserByIdAndPassword(userId, SHA256Util.encryptSHA256(beforePassword));

        if(user != null){
            String newEncryptPassword = encryptSHA256(afterPassword);

            userMapper.updatePassword(
                    UserUpdateDAO.builder()
                            .userId(userId)
                            .password(newEncryptPassword)
                            .updatedAt(new Date())
                            .build());
        }else{
            throw new NotExistUserException();
        }

    }


    @Override
    public void dropId(String userId) {
        UserDAO user = userMapper.selectUserById(userId);

        if(user != null){
            if(user.isWithDraw()){
                userMapper.deleteUserById(userId);
            }else{
                throw new IllegalStateException("탈퇴를 신청한 유저가 아닙니다.");
            }

        }else{
            throw new NotExistUserException();
        }
    }

    @Override
    public void deleteId(String userId) {
        UserDAO user = userMapper.selectUserById(userId);

        if(user != null){
            userMapper.withDrawUserById(UserUpdateDAO.builder()
                    .userId(userId)
                    .isWithDraw(true)
                    .updatedAt(new Date())
                    .build());
        }else{
            throw new NotExistUserException();
        }
    }
}
