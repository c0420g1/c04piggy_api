package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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
public class Employee extends BaseEntity {
    private String code;
    private String name;
    @Column(columnDefinition="DATE", name="birthday")
    private Date birthday;
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
