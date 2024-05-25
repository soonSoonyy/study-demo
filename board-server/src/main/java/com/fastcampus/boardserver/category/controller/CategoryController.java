package com.fastcampus.boardserver.category.controller;

import com.fastcampus.boardserver.auth.aop.LoginCheck;
import com.fastcampus.boardserver.category.model.dto.CategoryRegisterDTO;
import com.fastcampus.boardserver.category.model.dto.CategoryUpdateDTO;
import com.fastcampus.boardserver.category.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> registerCategory(String accountId, @RequestBody CategoryRegisterDTO dto) {
        categoryService.registerCategory(accountId, dto);
        return ResponseEntity.ok().build();
    }

    @LoginCheck(userType = LoginCheck.UserType.ADMIN)
    @PatchMapping("/update/{seq}")
    public ResponseEntity<?> updateCategory(String accountId, @PathVariable("seq") Integer seq, @RequestBody CategoryUpdateDTO dto) {
        categoryService.updateCategory(accountId, seq, dto);
        return ResponseEntity.ok().build();
    }

    @LoginCheck(userType = LoginCheck.UserType.ADMIN)
    @DeleteMapping("/delete/{seq}")
    public ResponseEntity<?> deleteCategory(String accountId, @PathVariable("seq") Integer seq) {
        categoryService.deleteCategory(accountId, seq);
        return ResponseEntity.ok().build();
    }
}

