package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FeedDTO {
    private int id;
    private int isDeleted;
    private String description;
    private String code;
    private int amount;
    private String unit;
    private String feedTypeName;
    private int feedTypeId;
    private String herdName;
    private int herdId;
}
