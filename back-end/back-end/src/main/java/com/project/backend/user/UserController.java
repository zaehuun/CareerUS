package com.project.backend.user;

import com.project.backend.security.annotation.CurrentUser;
import com.project.backend.security.data.UserPrincipal;
import com.project.backend.user.domain.User;
import com.project.backend.user.dto.CheckResponseDto;
import com.project.backend.user.dto.JoinRequestDto;
import com.project.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/auth/register")
    public ResponseEntity<Long> register(@RequestBody JoinRequestDto joinRequestDto) {
        System.out.println("joinRequest = " + joinRequestDto);
        return new ResponseEntity<>(userService.joinUser(joinRequestDto), HttpStatus.OK);
    }

    @GetMapping("/api/auth/check")
    public ResponseEntity<CheckResponseDto> test(@CurrentUser User user){
        System.out.println("user = " + user);
        CheckResponseDto dto = CheckResponseDto.builder()
                .pk(user.getPk())
                .id(user.getUsername())
                .name(user.getName())
                .build();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/api/test")
    public ResponseEntity<Long> inputUser(){
        userService.inputTestUser();
        return new ResponseEntity<>(1L,HttpStatus.OK);
    }
}
