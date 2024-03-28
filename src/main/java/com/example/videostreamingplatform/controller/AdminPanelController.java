package com.example.videostreamingplatform.controller;

import com.example.videostreamingplatform.entity.Monitoring;
import com.example.videostreamingplatform.service.MonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminPanelController {
    private final MonitoringService monitoringService;

    @GetMapping("/admin-panel")
    public String showAdminPage(){
        return "admin";
    }

    @PostMapping("/loginAdmin")
    public String loginAdmin(@RequestParam String username, @RequestParam String password, Model model, HttpServletResponse httpServletResponse){

        if(username!=null && password!= null && username.equals("adminLogin") && password.equals("adminPass")){
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(24 * 60 * 60);
            httpServletResponse.addCookie(cookie);
            return "redirect:/admin-info";
        }

        return "redirect:/admin-panel";
    }
    @GetMapping("/admin-info")
    public String adminInfoPage(Model model){
        List<Monitoring> monitorings = monitoringService.findAll();
        model.addAttribute("data",monitorings);
        return "adminInfo";
    }
}
