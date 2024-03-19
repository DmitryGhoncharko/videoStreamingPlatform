package com.example.videostreamingplatform.controller;

import com.example.videostreamingplatform.DahuaCameraConnection;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class VideoController {
    @Autowired
    private DahuaCameraConnection dahuaCameraConnection;
    @GetMapping(value = "/video", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getVideo() throws IOException {
        Resource videoResource = new ClassPathResource("static/vd.mp4");
        try{
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1","admin","admin");
        }catch (Throwable e){

        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(videoResource);
    }
    @GetMapping(value = "/videoUpload", produces = "video/mp4")
    public ResponseEntity<Resource> getVideoUpload() throws IOException {
        Resource videoResource = new ClassPathResource("static/vd.mp4");
        HttpHeaders headers = new HttpHeaders();
        try{
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1","admin","admin");
        }catch (Throwable e){

        }
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "vd.mp4");

        return ResponseEntity.ok()
                .headers(headers)
                .body(videoResource);
    }
    @GetMapping("/zoom/add")
    public ResponseEntity zoomAdd(){
        try{
            Resource videoResource = new ClassPathResource("static/vd.mp4");
            HttpHeaders headers = new HttpHeaders();
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().zoom("127.0.0.1","admin","admin",true);
        }catch (Throwable e){

        }
        return ResponseEntity.ok("");
    }
    @GetMapping("/zoom/reduce")
    public ResponseEntity zoomReduce(){
        try{
            Resource videoResource = new ClassPathResource("static/vd.mp4");
            HttpHeaders headers = new HttpHeaders();
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().zoom("127.0.0.1","admin","admin",false);
        }catch (Throwable e){

        }
        return ResponseEntity.ok("");
    }

}

