package com.example.demo.service.impl;

import com.example.demo.common.GlobalUtil;
import com.example.demo.model.Cote;
import com.example.demo.model.Notification;
import com.example.demo.model.Notification$;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.service.NotificationService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    JPAStreamer jpaStreamer;
    @Autowired
    NotificationRepository notificationRepository;


    @Override
    public List<Notification> getAll() {
        return jpaStreamer.stream(Notification.class).sorted(Notification$.id.reversed()).collect(Collectors.toList());
    }

    @Override
    public Optional<Notification> getById(int id) {
        return  jpaStreamer.stream(Notification.class).filter(Notification$.id.equal(id)).findFirst();
    }

    @Override
    public int save(Notification notification) {
        try{
            notificationRepository.save(notification);
            return 1;
        }
        catch (Exception e){
            System.out.println(e);
            return 0;
        }

    }

    @Override
    public int delete(int[] ids) {
        try{
            Arrays.stream(ids).forEach(e ->
            {
                Notification notification = jpaStreamer.stream(Notification.class).filter(f -> f.getId() == e).findFirst().get();
                notification.setIsDeleted(1);
                notificationRepository.save(notification);
            });
            return 1;
        }
        catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public List<Notification> search(int pageNum, int pageSize, String search) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<Notification> notificationList= jpaStreamer.stream(Notification.class).filter(e-> e.getContent().contains(search) || e.getTitle().contains(search)).sorted(Notification$.id.reversed())
                .collect(Collectors.toList()).stream().skip((pageNum-1)* pageSize).limit(pageSize).collect(Collectors.toList());
        return notificationList;
    }
}
