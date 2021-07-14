package com.project.backend.user.dto;

import com.project.backend.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class UsersResponseDto {
        private String img;
        private String Comment;

        public static UsersResponseDto of(User user) {
                return new UsersResponseDto(
                        user.getImageUrl(),
                        user.getComment()
                );
        }

}
