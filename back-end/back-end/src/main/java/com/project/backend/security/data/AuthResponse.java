package com.project.backend.security.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthResponse {
    private String accessToken;
    public AuthResponse(String accessToken){ this.accessToken = accessToken;}
}
