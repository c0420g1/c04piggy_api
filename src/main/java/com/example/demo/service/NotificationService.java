package com.example.demo.service;

import com.example.demo.model.Notification;
import com.example.demo.model.NotificationDTO;

import java.util.List;

public interface NotificationService extends BaseService<Notification> {
    List<Notification> getData(int pageNum, int pageSize, String search);
    void addEditNotificationDTO(NotificationDTO notificationDTO);
    List<NotificationDTO> getDataDTO(int pageNum, int pageSize, String search);
}
