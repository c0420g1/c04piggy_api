package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link Permission} representing entities of the
 * {@code permission}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Permission$ {
    
    /**
     * This Field corresponds to the {@link Permission} field description.
     */
    public static final StringField<Permission> description = StringField.create(
        Permission.class,
        "description",
        Permission::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Permission} field isDeleted.
     */
    public static final IntField<Permission> isDeleted = IntField.create(
        Permission.class,
        "isDeleted",
        Permission::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Permission} field name.
     */
    public static final StringField<Permission> name = StringField.create(
        Permission.class,
        "name",
        Permission::getName,
        false
    );
    /**
     * This Field corresponds to the {@link Permission} field id.
     */
    public static final IntField<Permission> id = IntField.create(
        Permission.class,
        "id",
        Permission::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Permission} field rolePermissions.
     */
    public static final ReferenceField<Permission, Set<RolePermission>> rolePermissions = ReferenceField.create(
        Permission.class,
        "rolePermissions",
        Permission::getRolePermissions,
        false
    );
}