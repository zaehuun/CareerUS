package com.project.backend.market.domain;

import com.project.backend.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yaml.snakeyaml.error.Mark;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MarketTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "MARKET_ID")
    private Market market;

    @Builder
    public MarketTag(String name, Market market){
        this.name = name;
        this.market = market;
    }

}
