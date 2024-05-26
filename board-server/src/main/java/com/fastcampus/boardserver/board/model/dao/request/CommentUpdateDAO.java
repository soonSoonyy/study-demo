package com.fastcampus.boardserver.board.model.dao.request;

import com.fastcampus.boardserver.board.model.dto.CommentRegisterDTO;
import com.fastcampus.boardserver.board.model.dto.CommentUpdateDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentUpdateDAO {
    private Integer postId;
    private String content;
    private Integer subCommentId;
    private Integer createId;
    private LocalDateTime updatedAt;

    public CommentUpdateDAO(CommentUpdateDTO dto) {
        postId = dto.getPostId();
        content = dto.getContent();
        subCommentId = dto.getSubCommentId();
        createId = dto.getCreateId();
        updatedAt = dto.getUpdatedAt();
    }
}
