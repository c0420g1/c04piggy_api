package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link Feed} representing entities of the
 * {@code feed}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Feed$ {
    
    /**
     * This Field corresponds to the {@link Feed} field amount.
     */
    public static final IntField<Feed> amount = IntField.create(
        Feed.class,
        "amount",
        Feed::getAmount,
        false
    );
    /**
     * This Field corresponds to the {@link Feed} field description.
     */
    public static final StringField<Feed> description = StringField.create(
        Feed.class,
        "description",
        Feed::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Feed} field code.
     */
    public static final StringField<Feed> code = StringField.create(
        Feed.class,
        "code",
        Feed::getCode,
        false
    );
    /**
     * This Field corresponds to the {@link Feed} field id.
     */
    public static final IntField<Feed> id = IntField.create(
        Feed.class,
        "id",
        Feed::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Feed} field isDeleted.
     */
    public static final IntField<Feed> isDeleted = IntField.create(
        Feed.class,
        "isDeleted",
        Feed::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Feed} field herd.
     */
    public static final ReferenceField<Feed, Herd> herd = ReferenceField.create(
        Feed.class,
        "herd",
        Feed::getHerd,
        false
    );
    /**
     * This Field corresponds to the {@link Feed} field unit.
     */
    public static final StringField<Feed> unit = StringField.create(
        Feed.class,
        "unit",
        Feed::getUnit,
        false
    );
    /**
     * This Field corresponds to the {@link Feed} field pigs.
     */
    public static final ReferenceField<Feed, Set<Pig>> pigs = ReferenceField.create(
        Feed.class,
        "pigs",
        Feed::getPigs,
        false
    );
    /**
     * This Field corresponds to the {@link Feed} field feedType.
     */
    public static final ReferenceField<Feed, FeedType> feedType = ReferenceField.create(
        Feed.class,
        "feedType",
        Feed::getFeedType,
        false
    );
}