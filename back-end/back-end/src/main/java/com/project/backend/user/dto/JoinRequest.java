package com.project.backend.user.dto;

import lombok.Getter;

@Getter
public class JoinRequest {
    private String id;
    private String password;
    private String name;
    private String comment;
}
