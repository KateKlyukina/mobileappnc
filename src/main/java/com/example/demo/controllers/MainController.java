package com.example.demo.controllers;

import com.example.demo.models.Bill;
import com.example.demo.models.User;
import com.example.demo.service.BillService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

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

    @GetMapping("/home")
    public String getHome() {
        return "home";
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

    @GetMapping(value = "bill/create/{username}/{currency}/{amount}")
    @ResponseBody
    public String createBill(@PathVariable("username") String username,
                             @PathVariable("currency") String currency, @PathVariable("amount") Integer amount) {
        Bill bill = new Bill();
        bill.setCurrency(currency);
        bill.setUser(userService.findUserByUsername(username));
        bill.setAmount(amount);
        billService.save(bill);
        return "Success creating new bill";
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return "Remove is successful";
    }

    @GetMapping(value = "bill/delete/{id}")
    @ResponseBody
    public String deleteBill(@PathVariable("id") Integer id) {
        billService.deleteBillById(id);
        return "Remove is successful";
    }

    @GetMapping(value = "/show")
    @ResponseBody
    public List<String> showAllUsers() {
        return userService.allUsers().stream()
                .map(User::toString)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "bill/show")
    @ResponseBody
    public List<String> showAllBills() {
        return billService.allBills().stream()
                .map(Bill::toString)
                .collect(Collectors.toList());
    }
}
