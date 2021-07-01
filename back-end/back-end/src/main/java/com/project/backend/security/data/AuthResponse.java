package com.project.backend.security.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    public AuthResponse(String accessToken, String username){
        this.accessToken = accessToken;
        this.username = username;
    }
}
