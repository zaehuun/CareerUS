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
    private String content;
    private List<String> tag;


    @Builder
    public PostRequestDto(String title, String content, List<String> tag){
        this.title=title;
        this.content= content;
        this.tag=tag;
    }

}
