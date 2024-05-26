package com.fastcampus.boardserver.board.model.dao.request;


import com.fastcampus.boardserver.board.model.dto.CategoryRegisterDTO;
import com.fastcampus.boardserver.board.model.enums.SortStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryRegisterDAO {

    private String name;
    SortStatus sortStatus;
    private Integer searchCount;
    private Integer pagingStartOffset;

    public CategoryRegisterDAO(CategoryRegisterDTO dto){
        name = dto.getName();
        sortStatus = dto.getSortStatus();
        searchCount = dto.getSearchCount();
        pagingStartOffset = dto.getPagingStartOffset();
    }
}
