package com.project.backend.post.service;

import com.project.backend.post.domain.Posts;
import com.project.backend.post.domain.PostsRepository;
import com.project.backend.post.dto.PostsSaveRequestDto;
import com.project.backend.post.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts=postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalAccessError("해당 게시글이 없습니다.id="+id));
        posts.update(requestDto.getTitle(),requestDto.getBody());

        return id;
    }

    public void delete(Long id){
        Posts posts=postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다.id="+id));
        postsRepository.delete(posts);
    }
}
