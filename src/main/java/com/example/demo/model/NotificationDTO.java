package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class NotificationDTO {
    private int id;
    private String title;
    private int createById;
    private String createdBy;
    private String createDate;
    private String type;
    private String content;
    private List<SelectedEmployee> employees;
}
