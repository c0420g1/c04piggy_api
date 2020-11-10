package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link Role} representing entities of the
 * {@code role}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Role$ {
    
    /**
     * This Field corresponds to the {@link Role} field name.
     */
    public static final StringField<Role> name = StringField.create(
        Role.class,
        "name",
        Role::getName,
        false
    );
    /**
     * This Field corresponds to the {@link Role} field id.
     */
    public static final IntField<Role> id = IntField.create(
        Role.class,
        "id",
        Role::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Role} field description.
     */
    public static final StringField<Role> description = StringField.create(
        Role.class,
        "description",
        Role::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Role} field isDeleted.
     */
    public static final IntField<Role> isDeleted = IntField.create(
        Role.class,
        "isDeleted",
        Role::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Role} field roleAccounts.
     */
    public static final ReferenceField<Role, Set<RoleAccount>> roleAccounts = ReferenceField.create(
        Role.class,
        "roleAccounts",
        Role::getRoleAccounts,
        false
    );
    /**
     * This Field corresponds to the {@link Role} field rolePermissions.
     */
    public static final ReferenceField<Role, Set<RolePermission>> rolePermissions = ReferenceField.create(
        Role.class,
        "rolePermissions",
        Role::getRolePermissions,
        false
    );
}