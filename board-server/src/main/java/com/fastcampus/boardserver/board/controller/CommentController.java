package com.fastcampus.boardserver.board.controller;

import com.fastcampus.boardserver.auth.aop.LoginCheck;
import com.fastcampus.boardserver.board.model.dao.request.CommentRegisterDAO;
import com.fastcampus.boardserver.board.model.dao.response.CommentDAO;
import com.fastcampus.boardserver.board.model.dto.CommentRegisterDTO;
import com.fastcampus.boardserver.board.service.CommentService;
import com.fastcampus.boardserver.global.response.CommonResponse;
import com.fastcampus.boardserver.global.response.ResultCode;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @LoginCheck(userType = LoginCheck.UserType.ALL)
    @PostMapping("/register")
    public CommonResponse<Void> registerComment(
            String accountId,
            @RequestBody CommentRegisterDTO dto
    ) {

        commentService.registerComment(accountId, dto);
        return CommonResponse
                .<Void>builder()
                .code(ResultCode.SUCCESS.getCode())
                .status(ResultCode.SUCCESS.getHttpStatus())
                .build();
    }

    @LoginCheck(userType = LoginCheck.UserType.ALL)
    @GetMapping("/list/{postId}")
    public CommonResponse<List<CommentDAO>> getCommentListByPostId(
            String accountId,
            Integer postId
    ) {
        return CommonResponse
                .<List<CommentDAO>>builder()
                .code(ResultCode.SUCCESS.getCode())
                .status(ResultCode.SUCCESS.getHttpStatus())
                .requestBody(commentService.getCommentListByPostId(postId))
                .build();
    }

    @LoginCheck(userType = LoginCheck.UserType.ALL)
    @PatchMapping("/update/{seq}")
    public CommonResponse<Void> updateComment(
            String accountId,
            @PathVariable Integer seq,
            @RequestBody CommentRegisterDTO dto
    ) {
        return CommonResponse
                .<Void>builder()
                .code(ResultCode.SUCCESS.getCode())
                .status(ResultCode.SUCCESS.getHttpStatus())
                .build();
    }

    @LoginCheck(userType = LoginCheck.UserType.ALL)
    @DeleteMapping("/delete/{seq}")
    public CommonResponse<Void> deleteComment(
            String accountId,
            @PathVariable Integer seq
    ) {
        return CommonResponse
                .<Void>builder()
                .code(ResultCode.SUCCESS.getCode())
                .status(ResultCode.SUCCESS.getHttpStatus())
                .build();
    }
}
