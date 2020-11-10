package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "notification_employee")
public class NotificationEmployee extends BaseEntity {
    @Column(columnDefinition = "integer default 0", name ="is_read")
    private int isRead=0;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Notification notification;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;
}
