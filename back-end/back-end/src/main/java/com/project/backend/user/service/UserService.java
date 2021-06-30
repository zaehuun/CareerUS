package com.project.backend.user.service;

import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.user.domain.Role;
import com.project.backend.user.domain.User;
import com.project.backend.user.domain.UserRepository;
import com.project.backend.user.dto.JoinRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Long joinUser (JoinRequestDto joinRequestDto){
        if (!joinRequestDto.getRegisterCode().equals("careerus")){
            throw new CustomException(ErrorCode.INVALID_CODE);
        }
        if (!joinRequestDto.getPassword().equals(joinRequestDto.getPasswordConfirm())){
            throw new CustomException(ErrorCode.NOT_SAME_PW);
        }
        if(userRepository.existsByUsername(joinRequestDto.getUsername())){
            throw new CustomException(ErrorCode.DUPLICATED_ID);
        }

        User user = User.builder()
                .username(joinRequestDto.getUsername())
                .name(joinRequestDto.getName())
                .role(Role.ROLE_USER)
                .password(passwordEncoder.encode(joinRequestDto.getPassword()))
                .comment(joinRequestDto.getComment())
                .build();
        userRepository.save(user);
        return user.getPk();
    }

    public void inputTestUser(){
        for(int i = 0; i <10; i ++){
            User user = User.builder()
                    .username("aa" + Integer.toString(i))
                    .name("aa" + Integer.toString(i))
                    .role(Role.ROLE_USER)
                    .password(passwordEncoder.encode("1234"))
                    .comment("하이")
                    .build();
            userRepository.save(user);
        }
    }




}
