package com.project.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoinRequestDto {
    private String username;
    private String password;
    private String passwordConfirm;
    private String registerCode;
    private String name;
    private String comment;
}
