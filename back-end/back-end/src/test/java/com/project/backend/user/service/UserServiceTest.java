package com.project.backend.user.service;

import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.user.domain.Role;
import com.project.backend.user.domain.User;
import com.project.backend.user.domain.UserRepository;
import com.project.backend.user.dto.JoinRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@DisplayName("유저 단위 테스트(Service)")
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserService userService;

    private User user;

    @BeforeEach
    void setUp(){
        userService = new UserService(userRepository,passwordEncoder);
        user = User.builder()
                .name("김재훈")
                .username("zaehuun")
                .password("1234")
                .comment("테스트 한다.")
                .role(Role.ROLE_USER)
                .view(0L)
                .build();
    }

    @DisplayName("회원가입 테스트")
    @Test
    void joinUser(){
        JoinRequestDto joinRequestDto =
                new JoinRequestDto("zaehuun","1234","1234","careerus","김재훈","테스트 한다.");
        when(userRepository.existsByUsername(any())).thenReturn(false);
        when(passwordEncoder.encode(any())).thenReturn("비밀번호");

        userService.joinUser(joinRequestDto);

        verify(userRepository).existsByUsername(any());
        verify(passwordEncoder).encode(any());
        verify(userRepository).save(any());
    }

    @DisplayName("회원가입 할 때 가입 코드가 다르면 예외 처리")
    @Test
    void createUserWithExceptionDiffCode(){
        JoinRequestDto joinRequestDto =
                new JoinRequestDto("zaehuun","1234","1234","cccccc","김재훈","테스트 한다.");

        assertThatThrownBy(() -> userService.joinUser(joinRequestDto))
                .isInstanceOf(CustomException.class)
                .hasMessage(ErrorCode.INVALID_CODE.getMessage());
    }

    @DisplayName("회원가입 할 때 비밀번호와 비밀번호 확인이 다르면 예외 처리")
    @Test
    void createUserWithExceptionDiffPw(){
        JoinRequestDto joinRequestDto =
                new JoinRequestDto("zaehuun","1234","12345","careerus","김재훈","테스트 한다.");

        assertThatThrownBy(() -> userService.joinUser(joinRequestDto))
                .isInstanceOf(CustomException.class)
                .hasMessage(ErrorCode.NOT_SAME_PW.getMessage());
    }

    @DisplayName("회원가입 할 때 동일한 아이디가 존재하면 예외 처리")
    @Test
    void createUserWithExceptionSameId(){
        JoinRequestDto joinRequestDto =
                new JoinRequestDto("zaehuun","1234","1234","careerus","김재훈","테스트 한다.");
        when(userRepository.existsByUsername(any())).thenReturn(true);
        assertThatThrownBy(() -> userService.joinUser(joinRequestDto))
                .isInstanceOf(CustomException.class)
                .hasMessage(ErrorCode.DUPLICATED_ID.getMessage());
    }

    @DisplayName("최근 가입한 회원을 조회한다. 기본은 9명 조회지만 회원이 1명이면 1명만 조회한다.")
    @Test
    void currentJoinUserOrderByTime(){
        when(userRepository.findTop9ByOrderByCreateDateDesc()).thenReturn(Collections.singletonList(user));
        assertThat(userService.getCurrentUsers()).hasSize(1);
    }


}