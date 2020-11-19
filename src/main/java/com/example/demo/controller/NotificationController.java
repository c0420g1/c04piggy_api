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

    @GetMapping("getNotification/{pageNum}")
    public List<NotificationDTO> getData(@PathVariable int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String search){
        return notificationService.getDataDTO(pageNum,pageSize,search);
    }

    @PutMapping("deleteNotification")
    public int deleteNotification(@RequestParam int[] ids){
        return notificationService.delete(ids);
    }

    @PostMapping("addEditNotificationDTO")
    public void addEditNotificationDTO(@RequestBody NotificationDTO notificationDTO) {
        notificationService.addEditNotificationDTO(notificationDTO);
    }
}
