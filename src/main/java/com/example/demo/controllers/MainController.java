package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }
    @GetMapping("/signin")
    public String getSignin(){
        return "signin";
    }
    @GetMapping("/signup")
    public String getSignup(){
        return "signup";
    }
    @GetMapping("/user")
    public String getUser(){
        return "user";
    }
}
