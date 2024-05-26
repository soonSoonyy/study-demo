package com.fastcampus.boardserver.board.mapper;

import com.fastcampus.boardserver.board.model.dao.response.CommentDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void insertComment(String accountId, Integer postSeq, String content);

    void updateComment(String accountId, Integer seq, String content);

    void deleteComment(String accountId, Integer seq);

    List<CommentDAO> getCommentListByPostId(Integer postId);


}
