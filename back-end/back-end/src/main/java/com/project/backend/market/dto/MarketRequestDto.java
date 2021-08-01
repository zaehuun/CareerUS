package com.project.backend.market.dto;

import com.project.backend.market.domain.MarketTag;
import com.project.backend.market.domain.Status;
import com.project.backend.post.domain.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MarketRequestDto {
    private String title;
    private Long price;
    private String content;
    private Status status;
    private List<String> marketTags;

    @Builder
    public MarketRequestDto(String title,Long price,String content,Status status,List<String> marketTags){
        this.title=title;
        this.price=price;
        this.content=content;
        this.status=status;
        this.marketTags=marketTags;
    }
}
