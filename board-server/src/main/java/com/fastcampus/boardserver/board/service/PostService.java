package com.fastcampus.boardserver.board.service;

import com.fastcampus.boardserver.board.model.dto.PostUpdateDTO;
import com.fastcampus.boardserver.board.model.dto.PostRegisterDTO;
import com.fastcampus.boardserver.board.model.vo.PostVO;

import java.util.List;

public interface PostService {
    void registerPost(String accountId, PostRegisterDTO dto);

    List<PostVO> getPostList(Integer categoryId);

    List<PostVO> getPostListByUserId(String accountId, Integer categoryId);

    PostVO getPostDetail(Integer seq);

    void updatePost(String accountId, Integer seq, PostUpdateDTO dto);

    void deletePost(String accountId, Integer seq);
}
