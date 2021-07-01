package com.project.backend.user;

import com.project.backend.security.data.UserPrincipal;
import com.project.backend.user.dto.JoinRequestDto;
import com.project.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody JoinRequestDto joinRequestDto) {
        System.out.println("joinRequest = " + joinRequestDto);
        return new ResponseEntity<>(userService.joinUser(joinRequestDto), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
        return new ResponseEntity<>(user.getUsername(),HttpStatus.OK);
    }


}
