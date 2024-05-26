package com.fastcampus.boardserver.board.model.dao.request;

import com.fastcampus.boardserver.board.model.dto.PostRegisterDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostRegisterDAO {
    private String name;
    private String content;
    private Integer categoryId;
    private Integer userId;
    private Integer fileId;
    private Date createdAt;

    public PostRegisterDAO(PostRegisterDTO dto) {
        this.name = dto.getName();
        this.content = dto.getContent();
        this.categoryId = dto.getCategoryId();
        this.userId = dto.getUserId();
        this.fileId = dto.getFileId();
        this.createdAt = dto.getCreatedAt();
    }
}
