package com.project.backend.config;

import com.project.backend.security.*;
import com.project.backend.security.filter.JwtAuthenticationFilter;
import com.project.backend.security.filter.LoginFilter;
import com.project.backend.security.handler.JwtAuthenticationEntryPoint;
import com.project.backend.security.handler.LoginFailHandler;
import com.project.backend.security.handler.LoginSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailService customUserDetailService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());
    }
<<<<<<< HEAD
=======

>>>>>>> 04ce2a8bf5e2cb6808dab65817516015b0397124
    @Override
    public void configure(WebSecurity web){
        web.ignoring()
                .antMatchers("/h2-console/**");
    }
<<<<<<< HEAD
=======

>>>>>>> 04ce2a8bf5e2cb6808dab65817516015b0397124
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable().and()
                .csrf().disable() //REST APU 사용하기 때문에 csrf 사용 안 함
                .formLogin().disable()
                .httpBasic().disable()

                .addFilter(loginFilter())
                .addFilter(new JwtAuthenticationFilter(authenticationManager(),jwtTokenProvider,customUserDetailService))

                .exceptionHandling()
                    .authenticationEntryPoint(new JwtAuthenticationEntryPoint())
//                    .accessDeniedHandler(jwtAccessDeniedHandler)
                    .and()
<<<<<<< HEAD



=======
>>>>>>> 04ce2a8bf5e2cb6808dab65817516015b0397124
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //JWT 사용으로 세션 생성 x
                    .and()

                .authorizeRequests()
<<<<<<< HEAD
                    .antMatchers( "/register","/login").permitAll()
=======
                    .antMatchers("/api/auth/register","/api/auth/login").permitAll()
>>>>>>> 04ce2a8bf5e2cb6808dab65817516015b0397124
                    .anyRequest().hasRole("USER");
    }

    private LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter(authenticationManager());
<<<<<<< HEAD
        loginFilter.setFilterProcessesUrl("/login");
=======
        loginFilter.setFilterProcessesUrl("/api/auth/login");
>>>>>>> 04ce2a8bf5e2cb6808dab65817516015b0397124
        loginFilter.setAuthenticationSuccessHandler(new LoginSuccessHandler(jwtTokenProvider));
        loginFilter.setAuthenticationFailureHandler(new LoginFailHandler());
        return loginFilter;
    }
}
