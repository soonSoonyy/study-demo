package com.fastcampus.boardserver.auth.service;

import com.fastcampus.boardserver.auth.model.dto.UserDTO;
import jakarta.servlet.http.HttpSession;

public interface SessionService {

    void handleLoginSuccess(UserDTO user, HttpSession session);
}
