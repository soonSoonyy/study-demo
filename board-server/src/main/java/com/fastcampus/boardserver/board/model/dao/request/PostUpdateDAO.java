package com.fastcampus.boardserver.board.model.dao.request;

import com.fastcampus.boardserver.board.model.dto.PostUpdateDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostUpdateDAO {
    private String name;
    private String content;
    private Integer categoryId;
    private Integer fileId;
    private Date updatedAt;

    public PostUpdateDAO(PostUpdateDTO dto) {
        name = dto.getName();
        content = dto.getContent();
        categoryId = dto.getCategoryId();
        fileId = dto.getFileId();
        updatedAt = dto.getUpdatedAt();
    }
}
