package com.project.backend.post;


import com.project.backend.common.ImageUtil;
import com.project.backend.post.domain.Post;
import com.project.backend.common.paging.PageResultDto;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.post.dto.PostResponseDto;
import com.project.backend.post.dto.PostsResponseDto;
import com.project.backend.post.service.PostService;
import com.project.backend.security.annotation.CurrentUser;
import com.project.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/post/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable("id") Long id){
        PostResponseDto a = postService.getPost(id);
        System.out.println(a.getTag());
        return new ResponseEntity<>(postService.getPost(id),HttpStatus.OK);
    }

    @PostMapping("/api/post")
    public ResponseEntity<Long> savePost(@CurrentUser User user, @RequestBody PostRequestDto requestDto){
        return new ResponseEntity<>(postService.savePost(user, requestDto), HttpStatus.OK);
    }

//    @PutMapping("/api/post/{id}")
//    public ResponseEntity<Long> updatePost(@PathVariable("id") Long id, @RequestBody PostRequestDto requestDto){
//        return new ResponseEntity<>(postService.updatePost(id,requestDto), HttpStatus.OK);
//    }
//
    @DeleteMapping("/api/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }



    @GetMapping("/api/posts")
    public ResponseEntity<PageResultDto<PostsResponseDto, Post>> getPostList(@RequestParam(value = "page", required = false, defaultValue = "0") int pageNum){
        System.out.println("pageNum = " + pageNum);
        return new ResponseEntity<>(postService.getList(pageNum),HttpStatus.OK);
    }

    @GetMapping("/api/post/test")
    public ResponseEntity<Long> inputUser(@CurrentUser User user){
        System.out.println(123);
        postService.inputTestPost(user);
        return new ResponseEntity<>(1L,HttpStatus.OK);
    }

    @PostMapping("/api/upload")
    public ResponseEntity<String> upload(@RequestParam("image") MultipartFile img) throws IOException {
        return new ResponseEntity<>(ImageUtil.postImgSave(img), HttpStatus.OK);
    }

}
