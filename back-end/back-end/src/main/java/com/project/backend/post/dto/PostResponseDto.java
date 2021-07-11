package com.project.backend.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private long id;
    private String title;
    private String writer;
    private String content;
    private String tag;
    private LocalDateTime date;

    @Builder
    public PostResponseDto(Long id, String title, String writer, String content, String tag, LocalDateTime date){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.tag = tag;
        this.date = date;
    }
}
