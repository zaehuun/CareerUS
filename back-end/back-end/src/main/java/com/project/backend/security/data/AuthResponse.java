package com.project.backend.security.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
<<<<<<< HEAD

    public AuthResponse(String accessToken){
        this.accessToken = accessToken;
    }
=======
    public AuthResponse(String accessToken){ this.accessToken = accessToken;}
>>>>>>> 04ce2a8bf5e2cb6808dab65817516015b0397124
}
