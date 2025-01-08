package com.djebby.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RequiredAuthController {
    @GetMapping("/secrets")
    public String secrets() {
        return "secrets... you have successfully authenticated";
    }
}
