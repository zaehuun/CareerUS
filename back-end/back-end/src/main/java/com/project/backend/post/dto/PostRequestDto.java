package com.project.backend.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private String body;
    private List<String> tags;


    @Builder
    public PostRequestDto(String title, String body, List<String> tags){
        this.title=title;
        this.body= body;
        this.tags=tags;
    }

}
