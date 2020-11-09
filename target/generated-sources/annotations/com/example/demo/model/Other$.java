package com.example.demo.model;

import com.speedment.jpastreamer.field.ByteField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.StringField;

/**
 * The generated base for entity {@link Other} representing entities of the
 * {@code other}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Other$ {
    
    /**
     * This Field corresponds to the {@link Other} field isOther.
     */
    public static final ByteField<Other> isOther = ByteField.create(
        Other.class,
        "isOther",
        Other::getIsOther,
        false
    );
    /**
     * This Field corresponds to the {@link Other} field name.
     */
    public static final StringField<Other> name = StringField.create(
        Other.class,
        "name",
        Other::getName,
        false
    );
    /**
     * This Field corresponds to the {@link Other} field title.
     */
    public static final StringField<Other> title = StringField.create(
        Other.class,
        "title",
        Other::getTitle,
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
     * This Field corresponds to the {@link Other} field refId.
     */
    public static final IntField<Other> refId = IntField.create(
        Other.class,
        "refId",
        Other::getRefId,
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
}