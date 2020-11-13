package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link Herd} representing entities of the
 * {@code herd}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Herd$ {
    
    /**
     * This Field corresponds to the {@link Herd} field isDeleted.
     */
    public static final IntField<Herd> isDeleted = IntField.create(
        Herd.class,
        "isDeleted",
        Herd::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Herd} field cotes.
     */
    public static final ReferenceField<Herd, Set<Cote>> cotes = ReferenceField.create(
        Herd.class,
        "cotes",
        Herd::getCotes,
        false
    );
    /**
     * This Field corresponds to the {@link Herd} field feeds.
     */
    public static final ReferenceField<Herd, Set<Feed>> feeds = ReferenceField.create(
        Herd.class,
        "feeds",
        Herd::getFeeds,
        false
    );
    /**
     * This Field corresponds to the {@link Herd} field description.
     */
    public static final StringField<Herd> description = StringField.create(
        Herd.class,
        "description",
        Herd::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Herd} field id.
     */
    public static final IntField<Herd> id = IntField.create(
        Herd.class,
        "id",
        Herd::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Herd} field name.
     */
    public static final StringField<Herd> name = StringField.create(
        Herd.class,
        "name",
        Herd::getName,
        false
    );
}