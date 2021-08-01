package com.project.backend.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class ImageUtil {
    private static final String path = "C://images/post/";
    private static final String path_m="C://images/market/";

    public static String postImgSave(MultipartFile img) throws IOException{
        System.out.println(img.getBytes());
        System.out.println(img.getContentType());
        System.out.println(img.getOriginalFilename());
        System.out.println(img.getName());
        Date date = new Date();
        StringBuilder sb = new StringBuilder();
        if (img.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(date.getTime());
            sb.append(img.getOriginalFilename());
        }
        if (!img.isEmpty()) {
            File dest = new File(path + sb.toString());
            img.transferTo(dest);
        }
        return "/images/"+sb.toString();
    }

////    마켓 파일
    public static String marketImgSave(MultipartFile img) throws IOException{
        System.out.println(img.getBytes());
        System.out.println(img.getContentType());
        System.out.println(img.getOriginalFilename());
        System.out.println(img.getName());
        Date date = new Date();
        StringBuilder sb = new StringBuilder();
        if (img.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(date.getTime());
            sb.append(img.getOriginalFilename());
        }
        if (!img.isEmpty()) {
            File dest = new File(path_m + sb.toString());
            img.transferTo(dest);
        }
        return "/images/"+sb.toString();
    }
}
