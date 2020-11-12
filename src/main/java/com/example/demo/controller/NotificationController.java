package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.NotificationService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/getAllNotification")
    public List<Notification> getAll(){
        return notificationService.getAll();
    }

    @PostMapping("addEditNotification")
    public int addNotification(@RequestBody Notification notification){
        return notificationService.save(notification);
    }

    @PostMapping("deleteNotification")
    public int deleteNotification(@RequestBody int[] ids){
        return notificationService.delete(ids);
    }
}
