package com.project.backend.post.domain;

import com.project.backend.common.BaseTimeEntity;
import com.project.backend.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Posts extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String  body;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @Column(nullable = false)
    private String tag;

    @Builder
    public Posts(String title, String body, String tag,User user){
        this.title = title;
        this.body= body;
        this.tag=tag;
        this.user=user;
    }

    public void update(String title,String body){
        this.title=title;
        this.body=body;
    }





}
