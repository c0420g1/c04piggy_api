package com.example.demo.model;

import com.speedment.jpastreamer.field.ByteField;
import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.time.LocalDate;
import java.util.Set;

/**
 * The generated base for entity {@link Employee} representing entities of the
 * {@code employee}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Employee$ {
    
    /**
     * This Field corresponds to the {@link Employee} field birthday.
     */
    public static final ComparableField<Employee, LocalDate> birthday = ComparableField.create(
        Employee.class,
        "birthday",
        Employee::getBirthday,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field id.
     */
    public static final IntField<Employee> id = IntField.create(
        Employee.class,
        "id",
        Employee::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field cotes.
     */
    public static final ReferenceField<Employee, Set<Cote>> cotes = ReferenceField.create(
        Employee.class,
        "cotes",
        Employee::getCotes,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field code.
     */
    public static final StringField<Employee> code = StringField.create(
        Employee.class,
        "code",
        Employee::getCode,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field cardId.
     */
    public static final StringField<Employee> cardId = StringField.create(
        Employee.class,
        "cardId",
        Employee::getCardId,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field isDeleted.
     */
    public static final IntField<Employee> isDeleted = IntField.create(
        Employee.class,
        "isDeleted",
        Employee::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field email.
     */
    public static final StringField<Employee> email = StringField.create(
        Employee.class,
        "email",
        Employee::getEmail,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field
     * notificationEmployees.
     */
    public static final ReferenceField<Employee, Set<NotificationEmployee>> notificationEmployees = ReferenceField.create(
        Employee.class,
        "notificationEmployees",
        Employee::getNotificationEmployees,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field notifications.
     */
    public static final ReferenceField<Employee, Set<Notification>> notifications = ReferenceField.create(
        Employee.class,
        "notifications",
        Employee::getNotifications,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field description.
     */
    public static final StringField<Employee> description = StringField.create(
        Employee.class,
        "description",
        Employee::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field gender.
     */
    public static final ByteField<Employee> gender = ByteField.create(
        Employee.class,
        "gender",
        Employee::getGender,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field historyExports.
     */
    public static final ReferenceField<Employee, Set<HistoryExport>> historyExports = ReferenceField.create(
        Employee.class,
        "historyExports",
        Employee::getHistoryExports,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field account.
     */
    public static final ReferenceField<Employee, Account> account = ReferenceField.create(
        Employee.class,
        "account",
        Employee::getAccount,
        false
    );
    /**
     * This Field corresponds to the {@link Employee} field name.
     */
    public static final StringField<Employee> name = StringField.create(
        Employee.class,
        "name",
        Employee::getName,
        false
    );
}