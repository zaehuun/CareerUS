package com.project.backend.market.dto;

import com.project.backend.market.domain.Status;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class MarketsResponseDto {
    private long id;
    private String title;
    private String writer;
    private List<String> tag;
    private LocalDateTime date;
    private Status status;
    private Long view;

    @Builder
    public MarketsResponseDto(Long id, String title, String writer, List<String> tag, LocalDateTime date,Status status, Long view){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.tag = tag;
        this.date = date;
        this.status=status;
        this.view = view;
    }
}
