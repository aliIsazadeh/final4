package com.example.demo.JWT;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserNameAndPasswordAuthenticationRequest {
    private String username;
    private String password;
}
