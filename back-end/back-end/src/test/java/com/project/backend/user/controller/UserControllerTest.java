package com.project.backend.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.backend.user.UserController;
import com.project.backend.user.domain.Role;
import com.project.backend.user.domain.User;
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
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("유저 단위 테스트(Controller)")
@WebMvcTest(controllers = UserController.class)
@ComponentScan(basePackages = {"com.project.backend.config","com.project.backend.security"})
@MockBean(JpaMetamodelMappingContext.class)
public class UserControllerTest {

    @MockBean
    protected UserRepository userRepository;
    @MockBean
    protected UserService userService;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected ObjectMapper objectMapper;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilters(new CharacterEncodingFilter("UTF-8",true))
                .apply(springSecurity())
                .build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @DisplayName("유저가 회원가입을 한다.")
    @Test
    void register() throws Exception{
        JoinRequestDto joinRequestDto = new JoinRequestDto("zaehuun", "1234", "1234", "careerus", "김재훈", "테스트할게요");
        when(userService.joinUser(joinRequestDto)).thenReturn("hoon");

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(joinRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }


//    @DisplayName("로그인 된 유저 정보를 조회한다.")
//    @Test
//    @WithMockUser(roles = "ROLE_USER")
//    void currentUser() throws Exception{
//        User user = User.builder()
//                .username("zaehuun")
//                .name("김재훈")
//                .password("비밀번호")
//                .comment("테스트한다.")
//                .view(0L)
//                .role(Role.ROLE_USER)
//                .build();
//
////        when(userRepository.findByUsername(any())).thenReturn(Optional.ofNullable(user));
//
//        mockMvc.perform(get("/api/auth/check")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
}
