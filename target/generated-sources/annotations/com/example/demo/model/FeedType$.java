package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link FeedType} representing entities of the
 * {@code feedType}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class FeedType$ {
    
    /**
     * This Field corresponds to the {@link FeedType} field feeds.
     */
    public static final ReferenceField<FeedType, Set<Feed>> feeds = ReferenceField.create(
        FeedType.class,
        "feeds",
        FeedType::getFeeds,
        false
    );
    /**
     * This Field corresponds to the {@link FeedType} field description.
     */
    public static final StringField<FeedType> description = StringField.create(
        FeedType.class,
        "description",
        FeedType::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link FeedType} field name.
     */
    public static final StringField<FeedType> name = StringField.create(
        FeedType.class,
        "name",
        FeedType::getName,
        false
    );
    /**
     * This Field corresponds to the {@link FeedType} field isDeleted.
     */
    public static final IntField<FeedType> isDeleted = IntField.create(
        FeedType.class,
        "isDeleted",
        FeedType::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link FeedType} field stocks.
     */
    public static final ReferenceField<FeedType, Set<Stock>> stocks = ReferenceField.create(
        FeedType.class,
        "stocks",
        FeedType::getStocks,
        false
    );
    /**
     * This Field corresponds to the {@link FeedType} field id.
     */
    public static final IntField<FeedType> id = IntField.create(
        FeedType.class,
        "id",
        FeedType::getId,
        false
    );
}