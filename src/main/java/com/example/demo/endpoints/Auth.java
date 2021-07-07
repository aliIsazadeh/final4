package com.example.demo.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class Auth {


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody String code, @RequestBody String password) {
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody String token) {
        return null;
    }
}
