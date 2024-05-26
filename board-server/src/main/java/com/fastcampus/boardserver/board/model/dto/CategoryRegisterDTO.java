package com.fastcampus.boardserver.board.model.dto;


import com.fastcampus.boardserver.board.model.enums.SortStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryRegisterDTO {

    private String name;
    SortStatus sortStatus;
    private Integer searchCount;
    private Integer pagingStartOffset;
}
