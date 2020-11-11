package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

/**
 * The generated base for entity {@link PigAssociateStatus} representing
 * entities of the {@code pigAssociateStatus}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class PigAssociateStatus$ {
    
    /**
     * This Field corresponds to the {@link PigAssociateStatus} field isDeleted.
     */
    public static final IntField<PigAssociateStatus> isDeleted = IntField.create(
        PigAssociateStatus.class,
        "isDeleted",
        PigAssociateStatus::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link PigAssociateStatus} field id.
     */
    public static final IntField<PigAssociateStatus> id = IntField.create(
        PigAssociateStatus.class,
        "id",
        PigAssociateStatus::getId,
        false
    );
    /**
     * This Field corresponds to the {@link PigAssociateStatus} field
     * description.
     */
    public static final StringField<PigAssociateStatus> description = StringField.create(
        PigAssociateStatus.class,
        "description",
        PigAssociateStatus::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link PigAssociateStatus} field pig.
     */
    public static final ReferenceField<PigAssociateStatus, Pig> pig = ReferenceField.create(
        PigAssociateStatus.class,
        "pig",
        PigAssociateStatus::getPig,
        false
    );
    /**
     * This Field corresponds to the {@link PigAssociateStatus} field pigStatus.
     */
    public static final ReferenceField<PigAssociateStatus, PigStatus> pigStatus = ReferenceField.create(
        PigAssociateStatus.class,
        "pigStatus",
        PigAssociateStatus::getPigStatus,
        false
    );
}