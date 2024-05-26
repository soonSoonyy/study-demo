package com.fastcampus.boardserver.board.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostRegisterDTO {
    private String name;
    private String content;
    private Integer categoryId;
    private Integer userId;
    private Integer fileId;
    private Date createdAt;

}
