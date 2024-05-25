package com.fastcampus.boardserver.category.service;


import com.fastcampus.boardserver.category.model.dto.CategoryRegisterDTO;
import com.fastcampus.boardserver.category.model.dto.CategoryUpdateDTO;

public interface CategoryService {
    void registerCategory(String accountId, CategoryRegisterDTO dto);

    void updateCategory(String accountId, Integer seq, CategoryUpdateDTO dto);

    void deleteCategory(String accountId, Integer seq);
}
