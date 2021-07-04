package com.project.backend.user.service;

import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.user.domain.Role;
import com.project.backend.user.domain.User;
import com.project.backend.user.domain.UserRepository;
import com.project.backend.user.dto.JoinRequestDto;

import com.project.backend.user.dto.Top3ResponseDto;
import com.project.backend.user.dto.UsersResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service //서비스면 서비스라고
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


    public List<UsersResponseDto> getCurrentUsers(){
        List<UsersResponseDto> dto = new ArrayList<>();
        List<User> users=userRepository.findTop9ByOrderByPk();
        for(User u : users){
            UsersResponseDto usersResponseDto=new UsersResponseDto();
            usersResponseDto.setComment(u.getComment());
            usersResponseDto.setDate(u.getCreateDate());
            usersResponseDto.setImg(u.getImageUrl());
            dto.add(usersResponseDto);
        }
        return dto;
    }

    public List<Top3ResponseDto> mainCurrentUser(){
        List<Top3ResponseDto> dto = new ArrayList<>();
        List<User> users=userRepository.findTop3ByOrderByView();
        for (User u: users){
            Top3ResponseDto top3ResponseDto=new Top3ResponseDto();
            top3ResponseDto.setImg(u.getImageUrl());
            top3ResponseDto.setName(u.getName());
            dto.add(top3ResponseDto);
        }
        return dto;
    }

}
