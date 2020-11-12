package com.example.demo.service;

import com.example.demo.model.Notification;

import java.util.List;

public interface NotificationService extends BaseService<Notification> {
    List<Notification> search(int pageNum, int pageSize, String search);
}
