package com.project.backend.post.domain;

import com.project.backend.common.BaseTimeEntity;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column
    private String content;
    @Column
    private String tag;

    @Builder
    public Post(String title, String content, String tag, User user){
        this.title = title;
        this.user=user;
        this.content= content;
        this.tag=tag;
    }

    public void update(PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.tag = postRequestDto.getTag();
    }






}
