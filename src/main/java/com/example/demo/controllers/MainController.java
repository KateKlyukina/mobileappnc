package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

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
    public String getUser() {
        return "user";
    }
    @GetMapping(value = {"/", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("dateTime", new Date());
        return "index";
    }
}
