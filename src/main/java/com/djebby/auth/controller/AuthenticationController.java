package com.djebby.auth.controller;

import com.djebby.auth.model.AuthenticationRequest;
import com.djebby.auth.model.RegisterRequest;
import com.djebby.auth.model.User;
import com.djebby.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(this.userService.register(request));
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthenticationRequest request) {
        return this.userService.verify(request);
    }



}




































