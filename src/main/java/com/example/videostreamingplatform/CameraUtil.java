package com.example.videostreamingplatform;

import org.apache.el.stream.Stream;

public class CameraUtil {

    native Stream getVideoFromPath();

    native Stream uploadVideo();

}
