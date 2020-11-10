package com.example.demo.model;

import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Collection;

/**
 * The generated base for entity {@link Account} representing entities of the
 * {@code account}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Account$ {
    
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
     * This Field corresponds to the {@link Account} field roleAccounts.
     */
    public static final ReferenceField<Account, Collection<RoleAccount>> roleAccounts = ReferenceField.create(
        Account.class,
        "roleAccounts",
        Account::getRoleAccounts,
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
}