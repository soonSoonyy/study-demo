package com.fastcampus.boardserver.board.mapper;

import com.fastcampus.boardserver.board.model.dao.request.*;
import com.fastcampus.boardserver.board.model.dao.response.PostDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void registerPost(PostRegisterDAO dao);

    List<PostDAO> selectPostList(PostFilterDAO dao);

    PostDAO selectOnePost(Integer seq);

    void updatePost(PostUpdateDAO dao);

    void deletePost(Integer seq);
}
