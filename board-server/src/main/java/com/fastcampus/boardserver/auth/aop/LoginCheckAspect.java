package com.fastcampus.boardserver.auth.aop;

import com.fastcampus.boardserver.global.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Log4j2
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
@Component
public class LoginCheckAspect {
    @Around("@annotation(com.fastcampus.boardserver.auth.aop.LoginCheck) && @annotation(loginCheck)")
    public Object adminLoginCheck(ProceedingJoinPoint joinPoint, LoginCheck loginCheck) throws Throwable {
        HttpSession session = (HttpSession)((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();

        String id = null;

        int idIndex = 0;

        String userType = loginCheck.userType().toString();

        switch (userType) {
            case "ADMIN":
                id = SessionUtil.getLoginAdminId(session);
                break;
            case "USER":
                id = SessionUtil.getLoginMemberId(session);
                break;
            case "ALL":
                id = SessionUtil.getLoginAdminId(session);
                if(id == null) {
                    id = SessionUtil.getLoginMemberId(session);
                }
                break;
        }
        if(id == null) {
            log.error(joinPoint.toString() + "account is not found");
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "account is not found"){};
        }

        Object[] modifiedArgs = joinPoint.getArgs();
        if(joinPoint != null){
            modifiedArgs[idIndex] = id;
        }

        return joinPoint.proceed(modifiedArgs);
    }

}
