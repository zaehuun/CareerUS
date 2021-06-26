package com.project.backend.user.service;

import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.user.domain.Role;
import com.project.backend.user.domain.User;
import com.project.backend.user.domain.UserRepository;
import com.project.backend.user.dto.JoinRequest;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Long joinUser (JoinRequest joinRequest){
        if(userRepository.existsById(joinRequest.getId())){
            throw new CustomException(ErrorCode.DUPLICATED_ID);
        }

        User user = User.builder()
                .id(joinRequest.getId())
                .name(joinRequest.getName())
                .role(Role.ROLE_USER)
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .comment(joinRequest.getComment())
                .build();
        userRepository.save(user);
        return user.getPk();
    }


}
