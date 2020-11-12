package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link PigStatus} representing entities of the
 * {@code pigStatus}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class PigStatus$ {
    
    /**
     * This Field corresponds to the {@link PigStatus} field id.
     */
    public static final IntField<PigStatus> id = IntField.create(
        PigStatus.class,
        "id",
        PigStatus::getId,
        false
    );
    /**
     * This Field corresponds to the {@link PigStatus} field name.
     */
    public static final StringField<PigStatus> name = StringField.create(
        PigStatus.class,
        "name",
        PigStatus::getName,
        false
    );
    /**
     * This Field corresponds to the {@link PigStatus} field isDeleted.
     */
    public static final IntField<PigStatus> isDeleted = IntField.create(
        PigStatus.class,
        "isDeleted",
        PigStatus::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link PigStatus} field
     * pigAssociateStatuses.
     */
    public static final ReferenceField<PigStatus, Set<PigAssociateStatus>> pigAssociateStatuses = ReferenceField.create(
        PigStatus.class,
        "pigAssociateStatuses",
        PigStatus::getPigAssociateStatuses,
        false
    );
    /**
     * This Field corresponds to the {@link PigStatus} field description.
     */
    public static final StringField<PigStatus> description = StringField.create(
        PigStatus.class,
        "description",
        PigStatus::getDescription,
        false
    );
}