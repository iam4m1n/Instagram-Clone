package com.Am1n.Instagram_Clone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    //    POST /auth/register — Register a new user
    //    todo : @RequestBody RegisterDTO dto
    @PostMapping("/register")
    public ResponseEntity<?> register(){
        return ResponseEntity.ok("");
    }

    //    POST /auth/login — Log in and receive JWT token/session
    //    todo: @RequestBody LoginDTO dto
    @PostMapping("/login")
    public ResponseEntity<?> login(){
        return ResponseEntity.ok("");
    }

    //    POST /auth/logout — Log out the user
    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok("");
    }

    //    POST /auth/refresh — Refresh JWT token (if used)
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(){
        return ResponseEntity.ok("");
    }

    //    GET /auth/me — Get current logged-in user info
    // todo: add User dto
    @GetMapping("/me")
    public ResponseEntity<?> currentUser(){
        return ResponseEntity.ok("");
    }

}
