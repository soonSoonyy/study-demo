package com.fastcampus.boardserver.board.service.impl;

import com.fastcampus.boardserver.auth.mapper.UserMapper;
import com.fastcampus.boardserver.auth.model.dao.response.UserDAO;
import com.fastcampus.boardserver.board.mapper.PostMapper;
import com.fastcampus.boardserver.board.model.dao.request.PostFilterDAO;
import com.fastcampus.boardserver.board.model.dao.request.PostRegisterDAO;
import com.fastcampus.boardserver.board.model.dao.request.PostUpdateDAO;
import com.fastcampus.boardserver.board.model.dao.response.PostDAO;
import com.fastcampus.boardserver.board.model.dto.PostRegisterDTO;
import com.fastcampus.boardserver.board.model.dto.PostUpdateDTO;
import com.fastcampus.boardserver.board.model.vo.PostVO;
import com.fastcampus.boardserver.board.service.PostService;
import com.fastcampus.boardserver.global.exception.*;
import com.fastcampus.boardserver.global.response.ResultCode;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Log4j2
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final UserMapper userMapper;

    @Override
    public void registerPost(String accountId, PostRegisterDTO dto) {

        if (accountId == null || accountId.isEmpty()) {
            throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
        }
        if (dto == null) {
            throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
        }

        UserDAO user = userMapper.selectUserById(accountId);

        if (user == null) {
            throw new NotExistUserException();
        } else if (user.isWithDraw()) {
            throw new WithdrawnUserAccessException();
        }

        try {
            PostRegisterDAO dao = new PostRegisterDAO(dto);
            dao.setUserId(dao.getUserId());

            postMapper.registerPost(dao);
        } catch (Exception e) {
            throw new PostException(ResultCode.POST_REGISTRATION_FAILED);
        }

    }

    @Override
    public List<PostVO> getPostList(Integer categoryId) {
        return postMapper.selectPostList(PostFilterDAO.builder()
                        .categoryId(categoryId)
                        .build())
                .stream().map(PostVO::new)
                .toList();
    }

    @Override
    public List<PostVO> getPostListByUserId(String accountId, Integer categoryId) {

        if (accountId == null || accountId.isEmpty()) {
            throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
        }

        UserDAO user = userMapper.selectUserById(accountId);

        if (user == null) {
            throw new NotExistUserException();
        } else if (user.isWithDraw()) {
            throw new WithdrawnUserAccessException();
        }

        return postMapper.selectPostList(PostFilterDAO.builder()
                        .userId(user.getSeq())
                        .categoryId(categoryId)
                        .build())
                .stream().map(PostVO::new)
                .toList();
    }

    @Override
    public PostVO getPostDetail(Integer seq) {
        return new PostVO(postMapper.selectOnePost(seq));
    }

    @Override
    public void updatePost(String accountId, Integer seq, PostUpdateDTO dto) {

        if (accountId == null || accountId.isEmpty()) {
            throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
        }
        if (dto == null) {
            throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
        }

        UserDAO user = userMapper.selectUserById(accountId);
        PostDAO post = postMapper.selectOnePost(seq);

        if (user == null) {
            throw new NotExistUserException();
        } else if (user.isWithDraw()) {
            throw new WithdrawnUserAccessException();
        }

        if (seq == null) {
            throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
        } else if (!(seq instanceof Integer)) {
            throw new ParameterErrorException(ResultCode.PARAMETER_TYPE_MISMATCH);
        } else if ((!user.isAdmin()) && (!Objects.equals(post.getUserId(), user.getSeq()))){
            throw new ForbiddenException();
        }

        try {
            PostUpdateDAO dao = new PostUpdateDAO(dto);

            postMapper.updatePost(dao);
        } catch (Exception e) {
            throw new PostException(ResultCode.POST_UPDATE_ERROR);
        }
    }

    @Override
    public void deletePost(String accountId, Integer seq) {
        if (accountId == null || accountId.isEmpty()) {
            throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
        }

        UserDAO user = userMapper.selectUserById(accountId);
        PostDAO post = postMapper.selectOnePost(seq);

        if (user == null) {
            throw new NotExistUserException();
        } else if (user.isWithDraw()) {
            throw new WithdrawnUserAccessException();
        } else if ((!user.isAdmin()) && (!Objects.equals(post.getUserId(), user.getSeq()))){
            throw new ForbiddenException();
        }

        try{
            postMapper.deletePost(seq);
        }catch (Exception e){
            throw new PostException(ResultCode.POST_DELETE_ERROR);
        }


    }
}
