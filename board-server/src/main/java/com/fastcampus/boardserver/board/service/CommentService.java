package com.fastcampus.boardserver.board.service;

import com.fastcampus.boardserver.board.model.dao.response.CommentDAO;
import com.fastcampus.boardserver.board.model.dto.CommentRegisterDTO;
import com.fastcampus.boardserver.board.model.dto.CommentUpdateDTO;

import java.util.List;

public interface CommentService {
    void registerComment(String accountId, CommentRegisterDTO dto);

    void updateComment(String accountId, CommentUpdateDTO dto);

    void deleteComment(String accountId, Integer seq);

    List<CommentDAO> getCommentListByPostId(Integer postId);
}
