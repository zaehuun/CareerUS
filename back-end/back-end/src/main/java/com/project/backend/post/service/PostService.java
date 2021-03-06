package com.project.backend.post.service;

import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.post.domain.Post;
import com.project.backend.post.domain.PostRepository;
import com.project.backend.common.paging.PageResultDto;
import com.project.backend.post.domain.Tag;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.post.dto.PostResponseDto;
import com.project.backend.post.dto.PostsResponseDto;
import com.project.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        post.setView(post.getView() + 1);
        return PostResponseDto.builder()
                .id(post.getId())
                .uid(post.getUser().getUsername())
                .title(post.getTitle())
                .writer(post.getUser().getName())
                .body(post.getBody())
                .tags(post.getTags().stream().map(Tag::getName).collect(Collectors.toList()))
                .date(post.getCreateDate())
                .view(post.getView())
                .build();
    }
    public PostResponseDto savePost(User user, PostRequestDto requestDto){
        Post post = Post.builder()
                .title(requestDto.getTitle())
                .user(user)
                .body(requestDto.getBody())
                .view(0L)
                .build();
        List<Tag> tags = requestDto.getTags().stream().map(name->new Tag(name,post)).collect(Collectors.toList());
        post.setTags(tags);
        postRepository.save(post);
        return PostResponseDto.builder()
                .id(post.getId())
                .uid(post.getUser().getUsername())
                .writer(post.getUser().getName())
                .title(post.getTitle())
                .body(post.getBody())
                .date(post.getCreateDate())
                .tags(post.getTags().stream().map(Tag::getName).collect(Collectors.toList()))
                .view(post.getView())
                .build();
    }

    public PostResponseDto updatePost(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id)
                .orElseThrow(()->new
                        CustomException(ErrorCode.INVALID_POST));
        post.update(requestDto);
        return PostResponseDto.builder()
                .id(post.getId())
                .uid(post.getUser().getUsername())
                .title(post.getTitle())
                .writer(post.getUser().getName())
                .body(post.getBody())
                .tags(post.getTags().stream().map(Tag::getName).collect(Collectors.toList()))
                .date(post.getCreateDate())
                .view(post.getView())
                .build();
    }

    public void deletePost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(()->new
                        CustomException(ErrorCode.INVALID_POST));
        postRepository.delete(post);
    }

    public PageResultDto<PostsResponseDto,Post> getList(int num, int limit){
        int pageNum = num == 0 ? 0 : num-1;
        Page<Post> posts = postRepository.findAll(PageRequest.of(pageNum,limit, Sort.by("id").descending()));
        Function<Post, PostsResponseDto> fn = (entity -> entityToDto(entity));
        return new PageResultDto<>(posts,fn);
    }

    public void inputTestPost(User user){
        for(int i = 0; i < 40; i++){
            Post p = Post.builder()
                    .title("???????????????"+Integer.toString(i))
                    .body("???????????????" +Integer.toString(i))
                    .user(user)
                    .view(0L)
                    .build();
            List<Tag> tags = new ArrayList<Tag>();
            for(int j = 0; j < 3; j++){
                Tag tag = Tag.builder()
                        .name("hi"+Integer.toString(i) + Integer.toString(j))
                        .post(p)
                        .build();
                tags.add(tag);
            }
            p.setTags(tags);
            postRepository.save(p);
        }
    }

    private PostsResponseDto entityToDto(Post entity){
        return PostsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .writer(entity.getUser().getName())
                .tag(entity.getTags().stream().map(Tag::getName).collect(Collectors.toList()))
                .date(entity.getCreateDate())
                .view(entity.getView())
                .build();
    }

}
