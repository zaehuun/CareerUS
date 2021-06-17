package com.project.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //어노테이션으로 설정 파일임을 알려줌
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") //자원 공유 허락할 origin 지정
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET","POST");
    }
}
