package com.project.backend.user.domain;

import com.project.backend.common.BaseTimeEntity;
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
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String  name;

    private String password;

    private String imageUrl;

    //@Column(length = 50)
    private String comment;

    private String gitHub;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String username, String name, String password, String comment, Role role){
        this.username = username;
        this.name= name;
        this.password = password;
        this.comment = comment;
        this.role = role;
    }


}
