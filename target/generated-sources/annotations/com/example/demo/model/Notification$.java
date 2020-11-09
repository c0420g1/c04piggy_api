package com.example.demo.model;

import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.time.LocalDate;
import java.util.Set;

/**
 * The generated base for entity {@link Notification} representing entities of
 * the {@code notification}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Notification$ {
    
    /**
     * This Field corresponds to the {@link Notification} field employee.
     */
    public static final ReferenceField<Notification, Employee> employee = ReferenceField.create(
        Notification.class,
        "employee",
        Notification::getEmployee,
        false
    );
    /**
     * This Field corresponds to the {@link Notification} field title.
     */
    public static final StringField<Notification> title = StringField.create(
        Notification.class,
        "title",
        Notification::getTitle,
        false
    );
    /**
     * This Field corresponds to the {@link Notification} field
     * notificationEmployees.
     */
    public static final ReferenceField<Notification, Set<NotificationEmployee>> notificationEmployees = ReferenceField.create(
        Notification.class,
        "notificationEmployees",
        Notification::getNotificationEmployees,
        false
    );
    /**
     * This Field corresponds to the {@link Notification} field content.
     */
    public static final StringField<Notification> content = StringField.create(
        Notification.class,
        "content",
        Notification::getContent,
        false
    );
    /**
     * This Field corresponds to the {@link Notification} field createDate.
     */
    public static final ComparableField<Notification, LocalDate> createDate = ComparableField.create(
        Notification.class,
        "createDate",
        Notification::getCreateDate,
        false
    );
    /**
     * This Field corresponds to the {@link Notification} field type.
     */
    public static final StringField<Notification> type = StringField.create(
        Notification.class,
        "type",
        Notification::getType,
        false
    );
}