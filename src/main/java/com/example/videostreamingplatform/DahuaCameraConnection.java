package com.example.videostreamingplatform;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;
import java.util.stream.Stream;
@Component
public class DahuaCameraConnection {
    public DahuaCameraConnection connectToCamera(){
        String ipAddress = "192.168.0.100";
        String username = "admin";
        String password = "password";
        try {
            String apiUrl = "http://" + ipAddress + "/cgi-bin/snapshot.cgi";
            String authString = username + ":" + password;
            String authHeaderValue = "Basic " + Base64.getEncoder().encodeToString(authString.getBytes());
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", authHeaderValue);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                System.out.println("Ответ сервера: " + response.toString());
            } else {
                System.out.println("Ошибка подключения к видеокамере. Код ответа: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DahuaCameraConnection();
    }
    public ResponseEntity<String> saveVideo(String ipAddress, String username, String password) throws IOException {
        var saveUrl = "http://" + ipAddress + "/cgi-bin/snapshot.cgi?action=startSave&channel=1";
        var authHeaderValue = "Basic " + username + password;
        String apiUrl = "http://" + ipAddress + "/cgi-bin/snapshot.cgi";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("save","video");
        return ResponseEntity.ok(connection.getResponseMessage());
        }
    public ResponseEntity<String> zoom(String ipAddress, String username, String password, boolean zoom) throws IOException {
        var saveUrl = "http://" + ipAddress + "/cgi-bin/snapshot.cgi?action=startSave&channel=1";
        var authHeaderValue = "Basic " + username + password;
        String apiUrl = "http://" + ipAddress + "/cgi-bin/snapshot.cgi";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("zoom", String.valueOf(zoom));
        return ResponseEntity.ok(connection.getResponseMessage());
    }
}
