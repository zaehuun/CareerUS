package com.project.backend.market.domain;

import com.project.backend.common.BaseTimeEntity;
import com.project.backend.market.dto.MarketRequestDto;
import com.project.backend.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Market extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "market", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarketTag> tags;

    @Column
    private Long view;

    @Builder
    public Market(String title, User user,Long price, String content, Status status, List<MarketTag> tags, Long view){
        this.title=title;
        this.user=user;
        this.price=price;
        this.content=content;
        this.status=status;
        this.tags = tags;
        this.view=view;

    }
//    업데이트 추가 구현
    public void update(MarketRequestDto marketRequestDto){
        this.title = marketRequestDto.getTitle();
        this.content = marketRequestDto.getContent();
        this.tags.clear();
        this.tags.addAll(marketRequestDto.getMarketTags().stream().map(name->new MarketTag(name,this)).collect(Collectors.toList()));
    }



}
