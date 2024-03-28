package com.example.videostreamingplatform.controller;

import com.example.videostreamingplatform.DahuaCameraConnection;
import com.example.videostreamingplatform.service.MonitoringService;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class VideoController {
    private final DahuaCameraConnection dahuaCameraConnection;
    private final MonitoringService monitoringService;
    @GetMapping(value = "/video", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getVideo(@CookieValue(value = "username", defaultValue = "") String username) throws IOException {
        monitoringService.create(username,"Пользователь просматривает видео с камеры 1");
        Resource videoResource = new ClassPathResource("static/vd.mp4");
        try {
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1", "admin", "admin");
        } catch (Throwable e) {

        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(videoResource);
    }

    @GetMapping(value = "/videoUpload", produces = "video/mp4")
    public ResponseEntity<Resource> getVideoUpload(@CookieValue(value = "username", defaultValue = "") String username) throws IOException {
        monitoringService.create(username,"Пользователь скачал видео с камеры 1");
        Resource videoResource = new ClassPathResource("static/vd.mp4");
        HttpHeaders headers = new HttpHeaders();
        try {
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1", "admin", "admin");
        } catch (Throwable e) {

        }
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "vd.mp4");

        return ResponseEntity.ok().headers(headers).body(videoResource);
    }


    @GetMapping(value = "/video2", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getVideo2(@CookieValue(value = "username", defaultValue = "") String username) throws IOException {
        monitoringService.create(username,"Пользователь просматривает видео с камеры 2");
        Resource videoResource = new ClassPathResource("static/vd2.mp4");
        try {
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1", "admin", "admin");
        } catch (Throwable e) {

        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(videoResource);
    }

    @GetMapping(value = "/videoUpload2", produces = "video/mp4")
    public ResponseEntity<Resource> getVideoUpload2(@CookieValue(value = "username", defaultValue = "") String username) throws IOException {
        monitoringService.create(username,"Пользователь скачал видео с камеры 2");
        Resource videoResource = new ClassPathResource("static/vd2.mp4");
        HttpHeaders headers = new HttpHeaders();
        try {
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1", "admin", "admin");
        } catch (Throwable e) {

        }
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "vd.mp4");

        return ResponseEntity.ok().headers(headers).body(videoResource);
    }


    @GetMapping(value = "/video3", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getVideo3(@CookieValue(value = "username", defaultValue = "") String username) throws IOException {
        monitoringService.create(username,"Пользователь просматривает видео с камеры 3");
        Resource videoResource = new ClassPathResource("static/vd3.mp4");
        try {
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1", "admin", "admin");
        } catch (Throwable e) {

        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(videoResource);
    }

    @GetMapping(value = "/videoUpload3", produces = "video/mp4")
    public ResponseEntity<Resource> getVideoUpload3(@CookieValue(value = "username", defaultValue = "") String username) throws IOException {
        monitoringService.create(username,"Пользователь скачал видео с камеры 3");
        Resource videoResource = new ClassPathResource("static/vd3.mp4");
        HttpHeaders headers = new HttpHeaders();
        try {
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1", "admin", "admin");
        } catch (Throwable e) {

        }
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "vd.mp4");

        return ResponseEntity.ok().headers(headers).body(videoResource);
    }



    @GetMapping(value = "/video4", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getVideo4(@CookieValue(value = "username", defaultValue = "") String username) throws IOException {
        monitoringService.create(username,"Пользователь просматривает видео с камеры 4");
        Resource videoResource = new ClassPathResource("static/vd4.mp4");
        try {
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1", "admin", "admin");
        } catch (Throwable e) {

        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(videoResource);
    }

    @GetMapping(value = "/videoUpload4", produces = "video/mp4")
    public ResponseEntity<Resource> getVideoUpload4(@CookieValue(value = "username", defaultValue = "") String username) throws IOException {
        monitoringService.create(username,"Пользователь скачал видео с камеры 4");
        Resource videoResource = new ClassPathResource("static/vd4.mp4");
        HttpHeaders headers = new HttpHeaders();
        try {
            Webcam webcam = Webcam.getDefault();
            if (webcam == null) {
                System.exit(1);
            }
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setFPSLimit(60);
            dahuaCameraConnection.connectToCamera().saveVideo("127.0.0.1", "admin", "admin");
        } catch (Throwable e) {

        }
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "vd.mp4");

        return ResponseEntity.ok().headers(headers).body(videoResource);
    }







    @GetMapping("/zoom/add")
    public ResponseEntity zoomAdd() {
        try {
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
            dahuaCameraConnection.connectToCamera().zoom("127.0.0.1", "admin", "admin", true);
        } catch (Throwable e) {

        }
        return ResponseEntity.ok("");
    }

    @GetMapping("/zoom/reduce")
    public ResponseEntity zoomReduce() {
        try {
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
            dahuaCameraConnection.connectToCamera().zoom("127.0.0.1", "admin", "admin", false);
        } catch (Throwable e) {

        }
        return ResponseEntity.ok("");
    }

}

