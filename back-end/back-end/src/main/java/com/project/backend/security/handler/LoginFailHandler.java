package com.project.backend.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.security.data.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if(exception instanceof AuthenticationServiceException) {
            new ObjectMapper().writeValue(response.getWriter(), "시스템에 오류가 발생했습니다.");
        }
        else if(exception instanceof BadCredentialsException) {
            new ObjectMapper().writeValue(response.getWriter(), "아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        else {
            new ObjectMapper().writeValue(response.getWriter(), "계정에 문제가 발생했습니다.");
        }
    }
}
