package com.project.backend.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostResponseDto {
    private long id;
    private String title;
    private String writer;
    private String content;
    private List<String> tag;
    private LocalDateTime date;

    @Builder
    public PostResponseDto(Long id, String title, String writer, String content, List<String> tag, LocalDateTime date){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.tag = tag;
        this.date = date;
    }
}
