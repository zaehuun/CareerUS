package com.project.backend.post;


import com.project.backend.common.ImageUtil;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.post.dto.PostResponseDto;
import com.project.backend.post.service.PostService;
import com.project.backend.security.annotation.CurrentUser;
import com.project.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/post/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable("id") Long id){
        return new ResponseEntity<>(postService.getPost(id),HttpStatus.OK);
    }

    @PostMapping("/api/post")
    public ResponseEntity<Long> savePost(@CurrentUser User user, @RequestBody PostRequestDto requestDto){
        return new ResponseEntity<>(postService.savePost(user, requestDto), HttpStatus.OK);
    }

    @PutMapping("/api/post/{id}")
    public ResponseEntity<Long> updatePost(@PathVariable("id") Long id, @RequestBody PostRequestDto requestDto){
        return new ResponseEntity<>(postService.updatePost(id,requestDto), HttpStatus.OK);
    }

    @DeleteMapping("/api/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }

    @PostMapping("/api/upload")
    public ResponseEntity<String> upload(@RequestParam("image") MultipartFile img) throws IOException {
            return new ResponseEntity<>(ImageUtil.postImgSave(img), HttpStatus.OK);
    }


}
