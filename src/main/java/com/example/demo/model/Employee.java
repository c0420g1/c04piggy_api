package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer default 0", name ="is_deleted")
    private int isDeleted=0;

    @Column(length = 1000)
    private String description;
    private String code;
    private String name;
    @Column(columnDefinition="DATE", name="birthday")
    private LocalDate birthday;
    private String email;
    private byte gender;
    @Column(columnDefinition="varchar(45)", name = "card_id")
    private String cardId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Account account;

    @OneToMany(mappedBy = "employee")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Cote> cotes;

    @OneToMany(mappedBy = "employee")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<HistoryExport> historyExports;

    @OneToMany(mappedBy = "employee")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "employee")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<NotificationEmployee> notificationEmployees;
}
