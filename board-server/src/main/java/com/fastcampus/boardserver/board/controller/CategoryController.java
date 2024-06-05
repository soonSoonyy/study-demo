package com.fastcampus.boardserver.board.controller;

import com.fastcampus.boardserver.auth.aop.LoginCheck;
import com.fastcampus.boardserver.board.model.dto.CategoryRegisterDTO;
import com.fastcampus.boardserver.board.model.dto.CategoryUpdateDTO;
import com.fastcampus.boardserver.board.service.CategoryService;
import com.fastcampus.boardserver.global.response.CommonResponse;
import com.fastcampus.boardserver.global.response.ResultCode;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @LoginCheck(userType = LoginCheck.UserType.ADMIN)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public CommonResponse<Void> registerCategory(String accountId, @RequestBody CategoryRegisterDTO dto) {
        categoryService.registerCategory(accountId, dto);
        return CommonResponse
                .<Void>builder()
                .code(ResultCode.SUCCESS.getCode())
                .status(ResultCode.SUCCESS.getHttpStatus())
                .build();
    }

    @LoginCheck(userType = LoginCheck.UserType.ADMIN)
    @PatchMapping("/update/{seq}")
    public CommonResponse<Void> updateCategory(String accountId, @PathVariable("seq") Integer seq, @RequestBody CategoryUpdateDTO dto) {
        categoryService.updateCategory(accountId, seq, dto);
        return CommonResponse
                .<Void>builder()
                .code(ResultCode.SUCCESS.getCode())
                .status(ResultCode.SUCCESS.getHttpStatus())
                .build();
    }

    @LoginCheck(userType = LoginCheck.UserType.ADMIN)
    @DeleteMapping("/delete/{seq}")
    public CommonResponse<Void> deleteCategory(String accountId, @PathVariable("seq") Integer seq) {
        categoryService.deleteCategory(accountId, seq);
        return CommonResponse
                .<Void>builder()
                .code(ResultCode.SUCCESS.getCode())
                .status(ResultCode.SUCCESS.getHttpStatus())
                .build();
    }
}

