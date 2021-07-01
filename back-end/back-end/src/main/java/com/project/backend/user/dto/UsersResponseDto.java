package com.project.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class UsersResponseDto {
        @JsonProperty
        private String Comment;
        @JsonProperty
        private String img;
        @JsonProperty
        private LocalDateTime date;

}
