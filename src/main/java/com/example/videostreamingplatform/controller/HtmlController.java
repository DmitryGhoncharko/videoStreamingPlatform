package com.example.videostreamingplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/video-page")
    public String showVideoPage() {
        return "videov";
    }
    @GetMapping("/vd1")
    public String vd1(){
        return "video";
    }
    @GetMapping("/vd2")
    public String vd2(){
        return "video2";
    }
    @GetMapping("/vd3")
    public String vd3(){
        return "video3";
    }
    @GetMapping("/vd4")
    public String vd4(){
        return "video4";
    }
}

