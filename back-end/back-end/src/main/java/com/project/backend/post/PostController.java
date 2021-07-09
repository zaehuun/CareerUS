package com.project.backend.post;


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
    public ResponseEntity<Long> upload(@RequestParam("image") MultipartFile img) throws IOException {
        System.out.println(img.getBytes());
        System.out.println(img.getContentType());
        System.out.println(img.getOriginalFilename());
        System.out.println(img.getName());
        Date date = new Date();
        StringBuilder sb = new StringBuilder(); // file image 가 없을 경우
        if (img.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(date.getTime());
            sb.append(img.getOriginalFilename());
        }
        if (!img.isEmpty()) {
            File dest = new File("C://images/feed/" + sb.toString());
            try {
                img.transferTo(dest);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } // db에 파일 위치랑 번호 등록
            //
        }

            return new ResponseEntity<>(1L, HttpStatus.OK);
        }

}
