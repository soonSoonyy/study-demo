package com.fastcampus.boardserver.board.controller;

import com.fastcampus.boardserver.auth.aop.LoginCheck;
import com.fastcampus.boardserver.board.model.dto.PostRegisterDTO;
import com.fastcampus.boardserver.board.model.dto.PostUpdateDTO;
import com.fastcampus.boardserver.board.model.vo.PostVO;
import com.fastcampus.boardserver.board.service.PostService;
import com.fastcampus.boardserver.global.exception.CustomException;
import com.fastcampus.boardserver.global.response.CommonResponse;
import com.fastcampus.boardserver.global.response.ResultCode;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @LoginCheck(userType = LoginCheck.UserType.ALL)
    @PostMapping("/register")
    public CommonResponse registerPost(
            String accountId, @RequestBody PostRegisterDTO dto
    ) {
        try {
            postService.registerPost(accountId, dto);
            return CommonResponse
                    .builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .build();
        } catch (CustomException e) {
            return CommonResponse
                    .builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }

    @LoginCheck(userType = LoginCheck.UserType.ALL)
    @GetMapping("/my-list")
    public CommonResponse<List<PostVO>> getPostListByAccountId(
            String accountId,
            @RequestParam(value = "categoryId", required = false) Integer categoryId
    ) {
        try {
            return CommonResponse
                    .<List<PostVO>>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .body(postService.getPostListByUserId(accountId, categoryId))
                    .build();
        } catch (CustomException e) {
            return CommonResponse
                    .<List<PostVO>>builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .<List<PostVO>>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }


    @GetMapping("/list")
    public CommonResponse<List<PostVO>> getPostList(
            @RequestParam(value = "categoryId", required = false) Integer categoryId
    ) {
        try {
            return CommonResponse
                    .<List<PostVO>>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .body(postService.getPostList(categoryId))
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .<List<PostVO>>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }

    @GetMapping("/detail/{seq}")
    public CommonResponse<PostVO> getPostDetail(
            @PathVariable("seq") Integer seq
    ) {
        try {
            return CommonResponse
                    .<PostVO>builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .body(postService.getPostDetail(seq))
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .<PostVO>builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }

    @LoginCheck(userType = LoginCheck.UserType.ALL)
    @PatchMapping("/update/{seq}")
    public CommonResponse updatePost(
            String accountId,
            @PathVariable("seq") Integer seq,
            @RequestBody PostUpdateDTO dto
    ) {
        try {
            postService.updatePost(accountId, seq, dto);
            return CommonResponse
                    .builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .build();
        } catch (CustomException e) {
            return CommonResponse
                    .builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }

    @LoginCheck(userType = LoginCheck.UserType.ALL)
    @DeleteMapping("/delete/{seq}")
    public CommonResponse deletePost(
            String accountId,
            @PathVariable("seq") Integer seq
    ) {
        try {
            postService.deletePost(accountId, seq);
            return CommonResponse
                    .builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .status(ResultCode.SUCCESS.getHttpStatus())
                    .build();
        } catch (CustomException e) {
            return CommonResponse
                    .builder()
                    .code(e.getCode())
                    .status(e.getHttpStatus())
                    .message(e.getMessage())
                    .build();
        } catch (Exception e) {
            return CommonResponse
                    .builder()
                    .code(ResultCode.FAIL.getCode())
                    .status(ResultCode.FAIL.getHttpStatus())
                    .message(ResultCode.FAIL.getMessage())
                    .build();
        }
    }

}
