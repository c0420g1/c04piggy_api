package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@Entity
@Table(name = "notification")
public class Notification extends BaseEntity {
    private String title;
    private String content;
    @Column(columnDefinition="DATE")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;
}
