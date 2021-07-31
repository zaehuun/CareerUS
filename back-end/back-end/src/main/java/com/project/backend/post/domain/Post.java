package com.project.backend.post.domain;

import com.project.backend.common.BaseTimeEntity;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @Lob
    private String body;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tags;

    @Column
    private Long view;

    @Builder
    public Post(String title, User user, String body, ArrayList<Tag> tags, Long view ){
        this.title = title;
        this.user=user;
        this.body = body;
        this.tags= tags;
        this.view = view;
    }

    public void update(PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.body = postRequestDto.getBody();
        this.tags.clear();
        this.tags.addAll(postRequestDto.getTags().stream().map(name->new Tag(name,this)).collect(Collectors.toList()));
    }






}
