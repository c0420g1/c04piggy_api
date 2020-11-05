package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Builder
@Data
@Entity
@Table(name = "account")
public class Account extends BaseEntity {
    private String username;
    @Column(length = 250)
    private String password;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<RoleAccount> roleAccounts;
}
