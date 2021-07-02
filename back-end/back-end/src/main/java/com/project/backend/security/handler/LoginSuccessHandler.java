package com.project.backend.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.security.data.AuthResponse;
import com.project.backend.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String token = jwtTokenProvider.createToken(authentication);
        String username = jwtTokenProvider.getUserNameFromToken(token);
        new ObjectMapper().writeValue(response.getWriter(), new AuthResponse(token));
    }
}
