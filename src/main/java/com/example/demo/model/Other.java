package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
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
