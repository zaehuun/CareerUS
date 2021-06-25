package com.project.backend.user.domain;

import com.project.backend.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Builder
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String  name;

    private String password;

    private String imageUrl;

    @Column(length = 50)
    private String Comment;

    private String gitHub;

    @Enumerated(EnumType.STRING)
    private Role role;

}
