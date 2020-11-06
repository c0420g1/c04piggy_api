package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Data
@Entity
@Table(name = "other")
public class Other extends BaseEntity {
    private String name;
    private String title;
    private String type;
    private String url;
    private byte isOther;
    private int refId;
}
