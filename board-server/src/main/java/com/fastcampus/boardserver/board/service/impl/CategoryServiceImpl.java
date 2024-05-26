package com.fastcampus.boardserver.board.service.impl;

import com.fastcampus.boardserver.global.exception.UnAuthorizedUserException;
import com.fastcampus.boardserver.global.exception.ParameterErrorException;
import com.fastcampus.boardserver.board.mapper.CategoryMapper;
import com.fastcampus.boardserver.board.model.dao.request.CategoryRegisterDAO;
import com.fastcampus.boardserver.board.model.dao.request.CategoryUpdateDAO;
import com.fastcampus.boardserver.board.model.dto.CategoryRegisterDTO;
import com.fastcampus.boardserver.board.model.dto.CategoryUpdateDTO;
import com.fastcampus.boardserver.board.service.CategoryService;
import com.fastcampus.boardserver.global.response.ResultCode;
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
            throw new UnAuthorizedUserException();
        }
    }

    @Override
    public void updateCategory(String accountId, Integer seq, CategoryUpdateDTO dto) {
        if (accountId != null ) {
            if (seq == null) {
                throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
            } else if (!(seq instanceof Integer)) {
                throw new ParameterErrorException(ResultCode.PARAMETER_TYPE_MISMATCH);
            }

            CategoryUpdateDAO dao = new CategoryUpdateDAO(dto);
            dao.setSeq(seq);
            categoryMapper.updateCategory(dao);
        } else {
            throw new UnAuthorizedUserException();
        }
    }

    @Override
    public void deleteCategory(String accountId, Integer seq) {
        if (accountId != null) {
            if (seq == null) {
                throw new ParameterErrorException(ResultCode.PARAMETER_NULL_ERROR);
            } else if (!(seq instanceof Integer)) {
                throw new ParameterErrorException(ResultCode.PARAMETER_TYPE_MISMATCH);
            }
            categoryMapper.deleteCategory(seq);
        } else {
            throw new UnAuthorizedUserException();
        }
    }

}
