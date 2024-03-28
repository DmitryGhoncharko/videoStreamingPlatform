package com.example.videostreamingplatform.service;

import com.example.videostreamingplatform.entity.Monitoring;
import com.example.videostreamingplatform.repository.MonitoringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MonitoringService {
    private final MonitoringRepository monitoringRepository;

    public List<Monitoring> findAll(){
        return monitoringRepository.findAll();
    }

    public Monitoring create(String login, String message){
        Monitoring monitoring = new Monitoring();
        monitoring.setUserLogin(login);
        monitoring.setMessageMon(message);
        monitoring.setUseDate(new Timestamp(new Date().getTime()));
       return monitoringRepository.save(monitoring);
    }
}
