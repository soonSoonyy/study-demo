package com.fastcampus.boardserver.category.mapper;

import com.fastcampus.boardserver.category.model.dao.request.CategoryRegisterDAO;
import com.fastcampus.boardserver.category.model.dao.request.CategoryUpdateDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    void registerCategory(CategoryRegisterDAO dao);

    void updateCategory(CategoryUpdateDAO dao);

    void deleteCategory(Integer seq);
}
