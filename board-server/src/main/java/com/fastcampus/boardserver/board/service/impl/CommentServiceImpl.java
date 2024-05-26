package com.fastcampus.boardserver.board.service.impl;

import com.fastcampus.boardserver.board.mapper.CommentMapper;
import com.fastcampus.boardserver.board.model.dao.response.CommentDAO;
import com.fastcampus.boardserver.board.model.dto.CommentRegisterDTO;
import com.fastcampus.boardserver.board.model.dto.CommentUpdateDTO;
import com.fastcampus.boardserver.board.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public void registerComment(String accountId, CommentRegisterDTO dto) {

    }

    @Override
    public void updateComment(String accountId, CommentUpdateDTO dto) {

    }

    @Override
    public void deleteComment(String accountId, Integer seq) {

    }

    @Override
    public List<CommentDAO> getCommentListByPostId(Integer postId) {
        return List.of();
    }
}
