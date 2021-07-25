package com.project.backend.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsResponseDto {
    private long id;
    private String title;
    private String writer;
    private List<String> tag;
    private LocalDateTime date;
    private Long view;


    @Builder
    public PostsResponseDto(Long id, String title, String writer, List<String> tag, LocalDateTime date, Long view){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.tag = tag;
        this.date = date;
        this.view = view;
    }
}
