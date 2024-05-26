package com.fastcampus.boardserver.board.model.dao.request;

import com.fastcampus.boardserver.board.model.dto.CommentRegisterDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentRegisterDAO {
    private Integer postId;
    private String content;
    private Integer subCommentId;
    private Integer createId;
    private LocalDateTime createdAt;

    public CommentRegisterDAO(CommentRegisterDTO dto) {
        postId = dto.getPostId();
        content = dto.getContent();
        subCommentId = dto.getSubCommentId();
        createId = dto.getCreateId();
        createdAt = dto.getCreatedAt();
    }
}
