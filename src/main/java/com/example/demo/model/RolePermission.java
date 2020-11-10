package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer default 0", name ="is_deleted")
    private int isDeleted=0;

    @Column(length = 1000)
    private String description;
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
