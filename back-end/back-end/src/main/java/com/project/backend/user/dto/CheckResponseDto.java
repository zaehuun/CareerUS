package com.project.backend.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CheckResponseDto {
    private String id;
    private String name;

    @Builder
    public CheckResponseDto(String id, String name){
        this.id = id;
        this.name = name;
    }
}
