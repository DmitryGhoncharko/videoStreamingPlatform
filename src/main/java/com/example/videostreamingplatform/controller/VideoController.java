package com.example.videostreamingplatform.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class VideoController {

    @GetMapping(value = "/video", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getVideo() throws IOException {
        Resource videoResource = new ClassPathResource("static/vd.mp4");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(videoResource);
    }
    @GetMapping(value = "/videoUpload", produces = "video/mp4")
    public ResponseEntity<Resource> getVideoUpload() throws IOException {
        Resource videoResource = new ClassPathResource("static/vd.mp4");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "vd.mp4");

        return ResponseEntity.ok()
                .headers(headers)
                .body(videoResource);
    }
}

