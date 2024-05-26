package com.fastcampus.boardserver.board.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentRegisterDTO {
    private Integer postId;
    private String content;
    private Integer subCommentId;
    private Integer createId;
    private LocalDateTime createdAt;
}
