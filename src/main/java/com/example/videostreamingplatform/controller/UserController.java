package com.example.videostreamingplatform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {



    private Map<String, String> users = new HashMap<>();

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (users.containsKey(username)) {
            model.addAttribute("error", "Пользователь с таким именем уже существует");
            return "registration";
        }

        users.put(username, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
            String userValue = users.get(username);
            if(userValue!=null && userValue.equals(password)){
                return "redirect:/video-page";
            }
        return "redirect:/login";

    }

}

