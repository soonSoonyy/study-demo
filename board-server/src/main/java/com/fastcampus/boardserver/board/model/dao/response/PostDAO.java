package com.fastcampus.boardserver.board.model.dao.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PostDAO {
    private Integer seq;
    private String name;
    private String content;
    private Integer views;
    private Integer CategoryId;
    private Integer userId;
    private Integer fileId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
