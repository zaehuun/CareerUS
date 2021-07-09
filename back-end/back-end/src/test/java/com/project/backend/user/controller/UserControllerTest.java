package com.project.backend.user.controller;

import com.project.backend.user.UserController;
import com.project.backend.user.domain.UserRepository;
import com.project.backend.user.dto.JoinRequestDto;
import com.project.backend.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@DisplayName("유저 단위 테스트(Controller)")
//@WebMvcTest(controllers = UserController.class)
//@ComponentScan(basePackages = {"com.project.backend.config","com.project.backend.security"})
//Controller, @ControllerAdvice, @JsonComponent, Converter, GenericConverter, Filter, HandlerInterceptor 어노테이셔만 스캔
@SpringBootTest
public class UserControllerTest {

    @MockBean
    protected UserRepository userRepository;
    @MockBean
    protected UserService userService;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilters(new CharacterEncodingFilter("UTF-8",true))
                .build();
    }

    @DisplayName("유저가 회원가입을 한다.")
    @Test
    void register() throws Exception{
        JoinRequestDto joinRequestDto = new JoinRequestDto("zaehuun", "1234", "1234", "careerus", "김재훈", "테스트할게요");


    }
}
