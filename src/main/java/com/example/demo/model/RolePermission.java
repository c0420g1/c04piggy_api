package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Role role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "permission_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Permission permission;
}
