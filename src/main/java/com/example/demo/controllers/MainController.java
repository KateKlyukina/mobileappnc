package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/signin")
    public String getSignin() {
        return "signin";
    }

    @GetMapping("/signup")
    public String getSignup() {
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

    @GetMapping(value = "/create/{username}/{age}/{email}")
    @ResponseBody
    public String createUser(@PathVariable("username") String username,
                             @PathVariable("age") Integer age, @PathVariable("email") String email) {
        User user = new User();
        user.setAge(age);
        user.setEmail(email);
        user.setUsername(username);
        userService.save(user);
        return "Success creating new user";
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return "Remove is successful";
    }

    @GetMapping(value = "/show")
    @ResponseBody
    public List<String> showAllUsers() {
        return userService.allUsers().stream()
                .map(User::toString)
                .collect(Collectors.toList());
    }
}
