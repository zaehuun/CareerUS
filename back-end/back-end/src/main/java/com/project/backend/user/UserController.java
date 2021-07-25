package com.project.backend.user;

import com.project.backend.security.annotation.CurrentUser;
import com.project.backend.user.domain.User;
import com.project.backend.user.dto.CheckResponseDto;
import com.project.backend.user.dto.JoinRequestDto;
import com.project.backend.user.dto.UsersResponseDto;
import com.project.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/auth/register")
    public ResponseEntity<String> register(@RequestBody JoinRequestDto joinRequestDto) {
        System.out.println("joinRequest = " + joinRequestDto);
        return new ResponseEntity<>(userService.joinUser(joinRequestDto), HttpStatus.OK);
    }

    @GetMapping("/api/auth/check")
    public ResponseEntity<CheckResponseDto> test(@CurrentUser User user){
        System.out.println("user = " + user);
        CheckResponseDto dto = CheckResponseDto.builder()
                .id(user.getUsername())
                .name(user.getName())
                .build();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PostMapping("/api/auth/logout")
    public ResponseEntity<String> logout(){
        return new ResponseEntity<>("로그아웃", HttpStatus.OK);
    }

    @GetMapping("/api/test")
    public ResponseEntity<Long> inputUser(){
        userService.inputTestUser();
        return new ResponseEntity<>(1L,HttpStatus.OK);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UsersResponseDto>> users(){
        return new ResponseEntity<>(userService.getCurrentUsers(), HttpStatus.OK);
    }
}
