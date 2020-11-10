package com.example.demo.service.impl;

import com.example.demo.model.Notification;
import com.example.demo.service.NotificationService;

import java.util.List;
import java.util.Optional;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public List<Notification> getAll() {
        return null;
    }

    @Override
    public Optional<Notification> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Notification notification) {

    }

    @Override
    public void delete(int[] ids) {

    }
}
