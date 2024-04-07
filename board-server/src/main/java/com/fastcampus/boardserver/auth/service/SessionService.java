package com.fastcampus.boardserver.auth.service;

import com.fastcampus.boardserver.auth.model.vo.UserVO;
import jakarta.servlet.http.HttpSession;

public interface SessionService {

    void handleLoginSuccess(HttpSession session, UserVO vo);
}
