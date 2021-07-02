package com.project.backend.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class CheckResponseDto {
    private Long pk;
    private String id;
    private String name;

    @Builder
    public CheckResponseDto(Long pk, String id, String name){
        this.pk = pk;
        this.id = id;
        this.name = name;
    }
}
