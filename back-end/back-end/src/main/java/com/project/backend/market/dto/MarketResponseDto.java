package com.project.backend.market.dto;

import com.project.backend.market.domain.Status;
import com.project.backend.post.domain.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MarketResponseDto {
    private Long id;
    private String title;
    private String writer;
    private Long price;
    private String content;
    private Status status;
    private LocalDateTime date;
    private List<String> marketTags;
    private Long view;


    @Builder
    public MarketResponseDto(Long id,String title,String writer,Long price,String content,Status status,LocalDateTime date,List<String>marketTags,Long view){
        this.id=id;
        this.title=title;
        this.writer=writer;
        this.price=price;
        this.content=content;
        this.status=status;
        this.date=date;
        this.marketTags=marketTags;
        this.view=view;
    }
}
