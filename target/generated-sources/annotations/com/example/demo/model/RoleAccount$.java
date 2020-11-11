package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

/**
 * The generated base for entity {@link RoleAccount} representing entities of
 * the {@code roleAccount}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class RoleAccount$ {
    
    /**
     * This Field corresponds to the {@link RoleAccount} field account.
     */
    public static final ReferenceField<RoleAccount, Account> account = ReferenceField.create(
        RoleAccount.class,
        "account",
        RoleAccount::getAccount,
        false
    );
    /**
     * This Field corresponds to the {@link RoleAccount} field role.
     */
    public static final ReferenceField<RoleAccount, Role> role = ReferenceField.create(
        RoleAccount.class,
        "role",
        RoleAccount::getRole,
        false
    );
    /**
     * This Field corresponds to the {@link RoleAccount} field id.
     */
    public static final IntField<RoleAccount> id = IntField.create(
        RoleAccount.class,
        "id",
        RoleAccount::getId,
        false
    );
    /**
     * This Field corresponds to the {@link RoleAccount} field isDeleted.
     */
    public static final IntField<RoleAccount> isDeleted = IntField.create(
        RoleAccount.class,
        "isDeleted",
        RoleAccount::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link RoleAccount} field description.
     */
    public static final StringField<RoleAccount> description = StringField.create(
        RoleAccount.class,
        "description",
        RoleAccount::getDescription,
        false
    );
}