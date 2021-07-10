package com.project.backend.post;


import com.project.backend.common.ImageUtil;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.post.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostsService postsService;

    @PostMapping("/api/posts")
    public ResponseEntity<Long> save(@RequestBody PostRequestDto requestDto){
        return new ResponseEntity<>(postsService.save(requestDto), HttpStatus.OK);
    }

    @PutMapping("api/posts/{id}")
    public ResponseEntity<Long> update(@PathVariable("id") Long id, @RequestBody PostRequestDto requestDto){
        return new ResponseEntity<>(postsService.update(id,requestDto), HttpStatus.OK);
    }

    @DeleteMapping("api/posts/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        postsService.delete(id);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }

    @PostMapping("api/upload")
    public ResponseEntity<String> upload(@RequestParam("image") MultipartFile img) throws IOException {
            return new ResponseEntity<>(ImageUtil.postImgSave(img), HttpStatus.OK);
        }

}
