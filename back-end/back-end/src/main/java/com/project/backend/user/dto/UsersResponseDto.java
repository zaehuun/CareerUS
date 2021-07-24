package com.project.backend.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsersResponseDto {
        private String Comment;
        private String img;
        private LocalDateTime date;

}
