package com.project.backend.user;

import com.project.backend.user.dto.JoinRequest;
import com.project.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody JoinRequest joinRequest) {
        System.out.println("joinRequest = " + joinRequest);
        return new ResponseEntity<>(userService.joinUser(joinRequest), HttpStatus.OK);
    }
}
