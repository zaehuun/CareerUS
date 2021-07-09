package com.project.backend.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String body;
    private String tag;

    @Builder
    public PostsUpdateRequestDto(String title, String body, String tag){
        this.title=title;
        this.body=body;
        this.tag=tag;
    }
}
