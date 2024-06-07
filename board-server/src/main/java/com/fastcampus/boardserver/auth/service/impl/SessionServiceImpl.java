package com.fastcampus.boardserver.auth.service.impl;


import com.fastcampus.boardserver.auth.model.dto.UserDTO;
import com.fastcampus.boardserver.auth.model.user.UserStatus;
import com.fastcampus.boardserver.auth.service.SessionService;
import com.fastcampus.boardserver.global.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Override
    public void handleLoginSuccess(UserDTO user, HttpSession session) {
        if (user.getStatus() == UserStatus.ADMIN) {
            SessionUtil.setLoginAdminId(session, user.getUserId());
        } else {
            SessionUtil.setLoginMemberId(session, user.getUserId());
        }
    }
}
