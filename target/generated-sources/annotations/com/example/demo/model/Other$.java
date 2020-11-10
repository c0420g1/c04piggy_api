package com.example.demo.model;

import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.StringField;

import java.time.LocalDate;

/**
 * The generated base for entity {@link Other} representing entities of the
 * {@code other}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Other$ {
    
    /**
<<<<<<< HEAD
=======
     * This Field corresponds to the {@link Other} field url.
     */
    public static final StringField<Other> url = StringField.create(
        Other.class,
        "url",
        Other::getUrl,
        false
    );
    /**
>>>>>>> develop
     * This Field corresponds to the {@link Other} field name.
     */
    public static final StringField<Other> name = StringField.create(
        Other.class,
        "name",
        Other::getName,
<<<<<<< HEAD
=======
        false
    );
    /**
     * This Field corresponds to the {@link Other} field createDate.
     */
    public static final ComparableField<Other, LocalDate> createDate = ComparableField.create(
        Other.class,
        "createDate",
        Other::getCreateDate,
>>>>>>> develop
        false
    );
    /**
     * This Field corresponds to the {@link Other} field refId.
     */
    public static final IntField<Other> refId = IntField.create(
        Other.class,
        "refId",
        Other::getRefId,
        false
    );
    /**
<<<<<<< HEAD
     * This Field corresponds to the {@link Other} field title.
     */
    public static final StringField<Other> title = StringField.create(
        Other.class,
        "title",
        Other::getTitle,
=======
     * This Field corresponds to the {@link Other} field id.
     */
    public static final IntField<Other> id = IntField.create(
        Other.class,
        "id",
        Other::getId,
>>>>>>> develop
        false
    );
    /**
     * This Field corresponds to the {@link Other} field isOther.
     */
    public static final IntField<Other> isOther = IntField.create(
        Other.class,
        "isOther",
        Other::getIsOther,
        false
    );
    /**
     * This Field corresponds to the {@link Other} field description.
     */
    public static final StringField<Other> description = StringField.create(
        Other.class,
        "description",
        Other::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Other} field url.
     */
    public static final StringField<Other> url = StringField.create(
        Other.class,
        "url",
        Other::getUrl,
        false
    );
    /**
     * This Field corresponds to the {@link Other} field type.
     */
    public static final StringField<Other> type = StringField.create(
        Other.class,
        "type",
        Other::getType,
        false
    );
    /**
     * This Field corresponds to the {@link Other} field type.
     */
    public static final StringField<Other> type = StringField.create(
        Other.class,
        "type",
        Other::getType,
        false
    );
    /**
     * This Field corresponds to the {@link Other} field isDeleted.
     */
    public static final IntField<Other> isDeleted = IntField.create(
        Other.class,
        "isDeleted",
        Other::getIsDeleted,
        false
    );
}