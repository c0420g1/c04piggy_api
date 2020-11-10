package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link Account} representing entities of the
 * {@code account}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Account$ {
    
    /**
     * This Field corresponds to the {@link Account} field password.
     */
    public static final StringField<Account> password = StringField.create(
        Account.class,
        "password",
        Account::getPassword,
        false
    );
    /**
     * This Field corresponds to the {@link Account} field description.
     */
    public static final StringField<Account> description = StringField.create(
        Account.class,
        "description",
        Account::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Account} field password.
     */
    public static final StringField<Account> password = StringField.create(
        Account.class,
        "password",
        Account::getPassword,
        false
    );
    /**
<<<<<<< HEAD
     * This Field corresponds to the {@link Account} field id.
     */
    public static final IntField<Account> id = IntField.create(
        Account.class,
        "id",
        Account::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Account} field username.
     */
    public static final StringField<Account> username = StringField.create(
        Account.class,
        "username",
        Account::getUsername,
        false
    );
    /**
     * This Field corresponds to the {@link Account} field isDeleted.
     */
    public static final IntField<Account> isDeleted = IntField.create(
        Account.class,
        "isDeleted",
        Account::getIsDeleted,
=======
     * This Field corresponds to the {@link Account} field roleAccounts.
     */
    public static final ReferenceField<Account, Set<RoleAccount>> roleAccounts = ReferenceField.create(
        Account.class,
        "roleAccounts",
        Account::getRoleAccounts,
>>>>>>> hai-BE-10-11
        false
    );
}