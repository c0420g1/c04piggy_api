package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Account$;
import com.example.demo.model.Cote;
import com.example.demo.model.FeedType;
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

    @GetMapping("/test")
    public List<Account> test(){
        List<Account> a= jpaStreamer.stream(Account.class).filter(Account$.username.contains("2")).collect(Collectors.toList());
        return a;
    }

    @GetMapping("/hai")
    public List<Account> haiCote(){
        List<Account> r= jpaStreamer.stream(Account.class).collect(Collectors.toList());
        return r;
    }
}
