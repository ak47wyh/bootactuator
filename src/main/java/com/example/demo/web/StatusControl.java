package com.example.demo.web;

import com.example.demo.service.StatusEndPoint;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/13.
 */
@RestController
public class StatusControl {

    @Autowired
    StatusService statusService;

    @Bean
    public Endpoint<String> status(){
        Endpoint<String> status = new StatusEndPoint();
        return status;
    }

    @RequestMapping("/change")
    public String changeStatus(String status){
        statusService.setStatus(status);
        return "ok";
    }
}
