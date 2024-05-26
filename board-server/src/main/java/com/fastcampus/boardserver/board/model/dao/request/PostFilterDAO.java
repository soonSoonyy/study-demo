package com.fastcampus.boardserver.board.model.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostFilterDAO {
    private Integer userId;
    private Integer categoryId;

}
