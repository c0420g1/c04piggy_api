package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "notification")
public class Notification extends BaseEntity {
    private String title;
    private String content;
    @Column(columnDefinition="DATE")
    private LocalDate createDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;
}
