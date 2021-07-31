package com.project.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
public class BackEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}
}
