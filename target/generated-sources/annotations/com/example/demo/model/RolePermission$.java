package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

/**
 * The generated base for entity {@link RolePermission} representing entities of
 * the {@code rolePermission}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class RolePermission$ {
    
    /**
     * This Field corresponds to the {@link RolePermission} field id.
     */
    public static final IntField<RolePermission> id = IntField.create(
        RolePermission.class,
        "id",
        RolePermission::getId,
        false
    );
    /**
     * This Field corresponds to the {@link RolePermission} field permission.
     */
    public static final ReferenceField<RolePermission, Permission> permission = ReferenceField.create(
        RolePermission.class,
        "permission",
        RolePermission::getPermission,
        false
    );
    /**
     * This Field corresponds to the {@link RolePermission} field isDeleted.
     */
    public static final IntField<RolePermission> isDeleted = IntField.create(
        RolePermission.class,
        "isDeleted",
        RolePermission::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link RolePermission} field description.
     */
    public static final StringField<RolePermission> description = StringField.create(
        RolePermission.class,
        "description",
        RolePermission::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link RolePermission} field role.
     */
    public static final ReferenceField<RolePermission, Role> role = ReferenceField.create(
        RolePermission.class,
        "role",
        RolePermission::getRole,
        false
    );
}