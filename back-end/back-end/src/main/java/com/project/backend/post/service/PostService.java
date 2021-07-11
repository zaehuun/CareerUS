package com.project.backend.post.service;

import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.post.domain.Post;
import com.project.backend.post.domain.PostRepository;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.post.dto.PostResponseDto;
import com.project.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto getPost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(()->new
                        CustomException(ErrorCode.INVALID_POST));
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .writer(post.getUser().getName())
                .content(post.getContent())
                .tag(post.getTag())
                .date(post.getUpdatedDate())
                .build();
    }
    public Long savePost(User user, PostRequestDto requestDto){
        Post post = Post.builder()
                .title(requestDto.getTitle())
                .user(user)
                .content(requestDto.getContent())
                .tag(requestDto.getTag())
                .build();
        postRepository.save(post);
        return post.getId();
    }

    public Long updatePost(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id)
                .orElseThrow(()->new
                        CustomException(ErrorCode.INVALID_POST));
        post.update(requestDto);
        return post.getId();
    }

    public void deletePost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(()->new
                        CustomException(ErrorCode.INVALID_POST));
        postRepository.delete(post);
    }
}
