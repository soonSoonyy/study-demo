package com.fastcampus.boardserver.board.model.vo;

import com.fastcampus.boardserver.board.model.dao.response.PostDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostVO {
    private final Integer seq;
    private final String name;
    private final String content;
    private final Integer views;
    private Integer categoryId;
    private Integer userId;
    private Integer fileId;
    private final LocalDateTime createdAt;

    public PostVO (PostDAO dao) {
        this.seq = dao.getSeq();
        this.name = dao.getName();
        this.content = dao.getContent();
        this.views = dao.getViews();
        this.categoryId = dao.getCategoryId();
        this.userId = dao.getUserId();
        this.fileId = dao.getFileId();
        this.createdAt = dao.getCreatedAt();
    }

}
