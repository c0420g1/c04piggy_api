package com.example.demo.service.impl;

import com.example.demo.common.GlobalUtil;
import com.example.demo.model.*;
import com.example.demo.repository.NotificationEmployeeRepository;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.service.NotificationService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @Autowired
    NotificationEmployeeRepository notificationEmployeeRepository;

    @Override
    public List<Notification> getAll() {
        return jpaStreamer.stream(Notification.class).sorted(Notification$.id.reversed()).collect(Collectors.toList());
    }

    @Override
    public Optional<Notification> getById(int id) {
        return jpaStreamer.stream(Notification.class).filter(Notification$.id.equal(id)).findFirst();
    }

    @Override
    public int save(Notification notification) {
        try {
            notificationRepository.save(notification);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

    @Override
    public int delete(int[] ids) {
        try {
            Arrays.stream(ids).forEach(e ->
            {
                Notification notification = jpaStreamer.stream(Notification.class).filter(f -> f.getId() == e).findFirst().get();
                notification.setIsDeleted(1);
                notificationRepository.save(notification);
            });
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public List<Notification> getData(int pageNum, int pageSize, String search) {
        JPAStreamer jpaStreamer = JPAStreamer.of("c04piggy");
        if (pageNum == -1)
            return jpaStreamer.stream(Notification.class).filter(e -> e.getContent().contains(search) || e.getTitle().contains(search)).sorted(Notification$.id.reversed()).collect(Collectors.toList());

        List<Notification> notificationList = jpaStreamer.stream(Notification.class).filter(e -> e.getContent().contains(search) || e.getTitle().contains(search)).sorted(Notification$.id.reversed())
                .collect(Collectors.toList()).stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());

        jpaStreamer.close();
        return notificationList;
    }

    @Override
    public void addEditNotificationDTO(NotificationDTO notificationDTO) {
        JPAStreamer jpaStreamer = JPAStreamer.of("c04piggy");
        Employee employee= jpaStreamer.stream(Employee.class).filter(Employee$.id.equal(notificationDTO.getCreateById())).findFirst().get();
          Notification notification= Notification.builder().id(notificationDTO.getId()).isDeleted(0).title(notificationDTO.getTitle()).content(notificationDTO.getContent())
          .employee(employee).type(notificationDTO.getType()).createDate( LocalDate.parse(notificationDTO.getCreateDate())).build();
          notificationRepository.save(notification);
          Notification noti= jpaStreamer.stream(Notification.class).sorted(Notification$.id.reversed()).findFirst().get();
          notificationDTO.getEmployees().forEach(f -> {
              Employee emp= jpaStreamer.stream(Employee.class).filter(Employee$.id.equal(f.getId())).findFirst().get();
              NotificationEmployee notificationEmployee= NotificationEmployee.builder().notification(noti).employee(emp).build();
              notificationEmployeeRepository.save(notificationEmployee);
          });
    }

    @Override
    public List<NotificationDTO> getDataDTO(int pageNum, int pageSize, String search) {
        return getDataWithPage(pageNum, pageSize, search);
    }

    private List<NotificationDTO> getDataWithPage(int pageNum, int pageSize, String search){
        JPAStreamer jpaStreamer = JPAStreamer.of("c04piggy");
        List<NotificationDTO> res= new ArrayList<>();
            jpaStreamer.stream(Notification.class).filter(e -> (e.getEmployee().getName().contains(search) || e.getContent().contains(search) || e.getTitle().contains(search)) && e.getIsDeleted()==0).sorted(Notification$.id.reversed()).collect(Collectors.toList()).stream()
                    .forEach(f->{
                        List<SelectedEmployee> se= new ArrayList<>();
                        jpaStreamer.stream(NotificationEmployee.class).filter(t-> t.getNotification().getId()== f.getId()).forEach(c->{
                            SelectedEmployee s= SelectedEmployee.builder().id(c.getEmployee().getId()).itemName(c.getEmployee().getName()).build();
                            se.add(s);
                        });

                        NotificationDTO notificationDTO= NotificationDTO.builder().id(f.getId()).title(f.getTitle())
                                .content(f.getContent()).createDate(f.getCreateDate().toString()).createdBy(f.getEmployee().getName())
                                .type(f.getType()).employees(se).createById(f.getEmployee().getId()).build();
                        res.add(notificationDTO);
                    });
            if(pageNum>=0){
                return res.stream().skip((pageNum-1)*pageSize).limit(pageSize).collect(Collectors.toList());
            }
            return res;
    }
}
