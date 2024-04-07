package com.fastcampus.boardserver.auth.service.impl;


import com.fastcampus.boardserver.auth.model.enums.UserStatus;
import com.fastcampus.boardserver.auth.model.vo.UserVO;
import com.fastcampus.boardserver.auth.service.SessionService;
import com.fastcampus.boardserver.global.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Override
    public void handleLoginSuccess(HttpSession session, UserVO user) {
        if (user.getUserStatus() == UserStatus.ADMIN) {
            SessionUtil.setLoginAdminId(session, user.getUserId());
        } else {
            SessionUtil.setLoginMemberId(session, user.getUserId());
        }
    }
}
