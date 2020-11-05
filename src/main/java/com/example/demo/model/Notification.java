package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Data
@Entity
@Table(name = "notification")
public class Notification extends BaseEntity {
    private String title;
    private String content;
}
