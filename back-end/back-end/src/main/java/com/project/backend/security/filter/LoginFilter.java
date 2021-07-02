package com.project.backend.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.user.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//로그인 요청 -> doFilter -> Usernamepassword~filter까지 옴
//->attemptAuthentication 메소드 호출해서 요청 처리 (실패하면 AuthenticationFailureHandler호출)
//->성공하면 로그인 정보를 통해 인증되지 않은 authenticationtoken생성 -> 토큰을 ProviderManage(AuthenticationManager의 구현체)에게 넘겨 책임을 위임
//providerManager는 자신이 가진 Provider 중 parameter로 들어옴 Authentication을 인증할수있는 provider 찾은 후 인증 책임 위임
//DaoAuthenticationProvider가 이 유형의 Authentication처리 가능, 이 provider는 Bean으로 등록된 UserDetailsService로부터 해당 username가진 user 가져옴
//비밀번호도 검증
//검증이성공적이면 인증된 Authentication 객체(UsernamePasswordAUthenticationToken)를 새로 생성하여 반환
//https://tech.junhabaek.net/spring-security-usernamepasswordauthenticationfilter%EC%9D%98-%EB%8D%94-%EA%B9%8A%EC%9D%80-%EC%9D%B4%ED%95%B4-8b5927dbc037
//https://bcp0109.tistory.com/301
//https://kimchanjung.github.io/programming/2020/07/01/spring-security-01/
//이 필터가 동작하면 이후 다른 필터는 동작하지 않고 바로 리턴함
@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
        if (!request.getMethod().equals("POST")){
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        LoginRequestDto loginRequestDto = null;
        try{
            loginRequestDto = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDto.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        String username = loginRequestDto.getUsername();
        username = (username != null) ? username : "";
        String password = loginRequestDto.getPassword();
        password = (password != null) ? password : "";

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        return authenticationManager.authenticate(authenticationToken);
    }

}
