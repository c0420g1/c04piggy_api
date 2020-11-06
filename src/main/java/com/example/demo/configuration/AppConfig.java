package com.example.demo.configuration;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public JPAStreamer jpaStreamer(){
        return JPAStreamer.of("c04piggy");
    }
}
