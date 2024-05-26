package com.fastcampus.boardserver.board.model.dao.request;


import com.fastcampus.boardserver.board.model.dto.CategoryUpdateDTO;
import com.fastcampus.boardserver.board.model.enums.SortStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryUpdateDAO {

    private Integer seq;
    private String name;
    SortStatus sortStatus;
    private Integer searchCount;
    private Integer pagingStartOffset;

    public CategoryUpdateDAO(CategoryUpdateDTO dto){
        name = dto.getName();
        sortStatus = dto.getSortStatus();
        searchCount = dto.getSearchCount();
        pagingStartOffset = dto.getPagingStartOffset();
    }
}
