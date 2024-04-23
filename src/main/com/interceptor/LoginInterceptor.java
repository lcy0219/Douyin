package com.interceptor;

import com.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long id = null;
        if(request.getParameter("user_id") != null) id = Long.valueOf(request.getParameter("user_id"));
        String token = request.getParameter("token");
        Long decodedId = JwtUtils.verify(token);
        if(decodedId != null){
            return true;
        }else{
            logger.error("无效token: " + request.getRequestURI());
            return false;
        }
    }


}
