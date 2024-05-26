package com.fastcampus.boardserver.board.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentUpdateDTO {
    private Integer postId;
    private String content;
    private Integer subCommentId;
    private Integer createId;
    private LocalDateTime updatedAt;
}
