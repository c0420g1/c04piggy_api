package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "role_permission")
public class RolePermission extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "role_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Role role;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Permission permission;
}
