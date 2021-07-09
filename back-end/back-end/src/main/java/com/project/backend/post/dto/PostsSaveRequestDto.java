package com.project.backend.post.dto;

import com.project.backend.post.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String  body;
    private String tag;

    @Builder
    public PostsSaveRequestDto(String title,String body, String tag){
        this.title=title;
        this.body=body;
        this.tag=tag;
    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .body(body)
                .tag(tag)
                .build();
    }
}
