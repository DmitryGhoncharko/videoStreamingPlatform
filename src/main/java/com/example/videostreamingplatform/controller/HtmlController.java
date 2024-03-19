package com.example.videostreamingplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/video-page")
    public String showVideoPage() {
        return "video";
    }
}

