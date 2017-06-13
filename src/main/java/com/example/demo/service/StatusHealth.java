package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/13.
 */
@Component
public class StatusHealth implements HealthIndicator {


    @Autowired
    StatusService statusService;

    @Override
    public Health health() {
        String status = statusService.getStatus();
        if(status == null || !status.equals("running")){
            return Health.down().withDetail("Error","Not Running").build();
        }
        return Health.up().build();
    }
}
