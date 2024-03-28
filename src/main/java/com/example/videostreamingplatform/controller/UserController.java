package com.example.videostreamingplatform.controller;


import com.example.videostreamingplatform.repository.MonitoringRepository;
import com.example.videostreamingplatform.service.MonitoringService;
import com.example.videostreamingplatform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MonitoringService monitoringService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            userService.registerUser(username, password);
        } catch (Throwable e) {
            model.addAttribute("error", "Пользователь с таким именем уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model, HttpServletResponse httpServletResponse) {

        if (userService.loginUser(username, password)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(24 * 60 * 60);
            httpServletResponse.addCookie(cookie);
            monitoringService.create(username,"Пользователь вошел в систему");
            return "redirect:/video-page";
        }
        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse){
        return "redirect:/http://127.0.0.1:8080/";
    }
}

