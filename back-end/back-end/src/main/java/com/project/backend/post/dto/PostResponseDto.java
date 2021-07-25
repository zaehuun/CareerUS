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
    private String body;
    private List<String> tag;
    private LocalDateTime date;
    private Long view;

    @Builder
    public PostResponseDto(Long id, String title, String writer, String body, List<String> tag, LocalDateTime date, Long view){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.body = body;
        this.tag = tag;
        this.date = date;
        this.view = view;
    }
}
