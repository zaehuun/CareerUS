package com.project.backend.post.service;

import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.post.domain.Post;
import com.project.backend.post.domain.PostRepository;
import com.project.backend.common.paging.PageResultDto;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.post.dto.PostResponseDto;
import com.project.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Function;

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

    public PageResultDto<PostResponseDto,Post> getList(int num){
        int pageNum = num == 0 ? 0 : num-1;
        Page<Post> posts = postRepository.findAll(PageRequest.of(pageNum,10, Sort.by("id")));
        Function<Post,PostResponseDto> fn = (entity -> entityToDto(entity));
        return new PageResultDto<>(posts,fn);
    }

    public void inputTestPost(User user){
        for(int i = 0; i < 40; i++){
            Post p = Post.builder()
                    .title("제목입니다"+Integer.toString(i))
                    .content("내용입니다" +Integer.toString(i))
                    .user(user)
                    .tag("태그입니다"+Integer.toString(i))
                    .build();
            postRepository.save(p);
        }
    }

    private PostResponseDto entityToDto(Post entity){
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .writer(entity.getUser().getName())
                .content(entity.getContent())
                .tag(entity.getTag())
                .date(entity.getUpdatedDate())
                .build();
    }
}
