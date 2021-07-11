package com.project.backend.post.dto;

import com.project.backend.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
    private String tag;


    @Builder
    public PostRequestDto(String title, String content, String tag){
        this.title=title;
        this.content= content;
        this.tag=tag;
    }

}
