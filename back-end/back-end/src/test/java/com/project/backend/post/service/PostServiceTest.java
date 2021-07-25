package com.project.backend.post.service;

import com.project.backend.post.domain.Post;
import com.project.backend.post.domain.PostRepository;
import com.project.backend.post.domain.Tag;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.user.domain.Role;
import com.project.backend.user.domain.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@ExtendWith(MockitoExtension.class)
@DisplayName("게시판 단위 테스트(Service)")
class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    private PostService postService;

    private Post post;
    private User user;

    private PostRequestDto postRequestDto;

    private List<String> tags;
    @BeforeEach
    void setUp(){
        postService = new PostService(postRepository);
        tags = new ArrayList<>();
        tags.add("태그1");
        tags.add("태그2");
        tags.add("태그3");

        postRequestDto = PostRequestDto.builder()
                .title("테스트 글입니다")
                .body("테스트 글의 본문입니다")
                .tags(tags)
                .build();

        user = User.builder()
                .name("zaehuun")
                .password("1234")
                .username("zaehuun")
                .role(Role.ROLE_USER)
                .view(0L)
                .comment("테스트")
                .build();

        post = Post.builder()
                .title(postRequestDto.getTitle())
                .user(user)
                .body(postRequestDto.getBody())
                .view(0L)
                .build();
        List<Tag> tags = postRequestDto.getTags().stream().map(name->new Tag(name,post)).collect(Collectors.toList());
        post.setTags(tags);
    }

    @DisplayName("게시판 글 작성 테스트")
    @Test
    void savePost(){
    }

}