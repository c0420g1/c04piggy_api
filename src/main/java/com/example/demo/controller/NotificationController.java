package com.example.demo.controller;

import com.example.demo.model.*;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NotificationController {
    @Autowired
    private JPAStreamer jpaStreamer;

    @GetMapping("/notification")
    public List<Notification> test(){
        return jpaStreamer.stream(Notification.class).sorted(Notification$.id.reversed()).collect(Collectors.toList());
    }
}
