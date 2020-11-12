package com.example.demo.configuration;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class    AppConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }

    @Bean
    public JPAStreamer jpaStreamer(){
        return JPAStreamer.of("c04piggy");
    }
}
