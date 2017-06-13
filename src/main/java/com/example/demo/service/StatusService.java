package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/13.
 */
@Service
public class StatusService {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
