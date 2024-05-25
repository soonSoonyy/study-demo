package com.fastcampus.boardserver.category.service.impl;

import com.fastcampus.boardserver.global.exception.UnAuthorizedUserException;
import com.fastcampus.boardserver.global.exception.ParameterTypeException;
import com.fastcampus.boardserver.category.mapper.CategoryMapper;
import com.fastcampus.boardserver.category.model.dao.request.CategoryRegisterDAO;
import com.fastcampus.boardserver.category.model.dao.request.CategoryUpdateDAO;
import com.fastcampus.boardserver.category.model.dto.CategoryRegisterDTO;
import com.fastcampus.boardserver.category.model.dto.CategoryUpdateDTO;
import com.fastcampus.boardserver.category.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public void registerCategory(String accountId, CategoryRegisterDTO dto) {
        if (accountId != null) {
            categoryMapper.registerCategory(new CategoryRegisterDAO(dto));
        } else {
            throw new UnAuthorizedUserException("인증된 사용자가 아닙니다.");
        }
    }

    @Override
    public void updateCategory(String accountId, Integer seq, CategoryUpdateDTO dto) {
        if (accountId != null ) {
            if (seq instanceof Integer == false) {
                throw new ParameterTypeException("카테고리 구분 값은 Integer 타입이어야 합니다.");
            }

            CategoryUpdateDAO dao = new CategoryUpdateDAO(dto);
            dao.setSeq(seq);
            categoryMapper.updateCategory(dao);
        } else {
            throw new UnAuthorizedUserException("인증된 사용자가 아닙니다.");
        }
    }

    @Override
    public void deleteCategory(String accountId, Integer seq) {
        if (accountId != null) {
            if (seq instanceof Integer == false) {
                throw new ParameterTypeException("카테고리 구분 값은 Integer 타입이어야 합니다.");
            }
            categoryMapper.deleteCategory(seq);
        } else {
            throw new UnAuthorizedUserException("인증된 사용자가 아닙니다.");
        }
    }

}
