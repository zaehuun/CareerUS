package com.project.backend.post.domain;

import com.project.backend.common.BaseTimeEntity;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column
    private String content;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tag;

    @Builder
    public Post(String title, User user, String content, ArrayList<Tag> tag ){
        this.title = title;
        this.user=user;
        this.content= content;
        this.tag=tag;
    }

//    public void update(PostRequestDto postRequestDto){
//        this.title = postRequestDto.getTitle();
//        this.content = postRequestDto.getContent();
//        this.tag = postRequestDto.getTag();
//    }






}
