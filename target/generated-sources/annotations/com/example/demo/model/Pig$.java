package com.example.demo.model;

import com.speedment.jpastreamer.field.ByteField;
import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.DoubleField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.time.LocalDate;
import java.util.Set;

/**
 * The generated base for entity {@link Pig} representing entities of the {@code
 * pig}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Pig$ {
    
    /**
     * This Field corresponds to the {@link Pig} field treatmentVacxins.
     */
    public static final ReferenceField<Pig, Set<TreatmentVacxin>> treatmentVacxins = ReferenceField.create(
        Pig.class,
        "treatmentVacxins",
        Pig::getTreatmentVacxins,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field pigAssociateStatuses.
     */
    public static final ReferenceField<Pig, Set<PigAssociateStatus>> pigAssociateStatuses = ReferenceField.create(
        Pig.class,
        "pigAssociateStatuses",
        Pig::getPigAssociateStatuses,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field color.
     */
    public static final StringField<Pig> color = StringField.create(
        Pig.class,
        "color",
        Pig::getColor,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field spec.
     */
    public static final StringField<Pig> spec = StringField.create(
        Pig.class,
        "spec",
        Pig::getSpec,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field fatherId.
     */
    public static final IntField<Pig> fatherId = IntField.create(
        Pig.class,
        "fatherId",
        Pig::getFatherId,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field feed.
     */
    public static final ReferenceField<Pig, Feed> feed = ReferenceField.create(
        Pig.class,
        "feed",
        Pig::getFeed,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field herd.
     */
    public static final ReferenceField<Pig, Herd> herd = ReferenceField.create(
        Pig.class,
        "herd",
        Pig::getHerd,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field description.
     */
    public static final StringField<Pig> description = StringField.create(
        Pig.class,
        "description",
        Pig::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field id.
     */
    public static final IntField<Pig> id = IntField.create(
        Pig.class,
        "id",
        Pig::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field weight.
     */
    public static final DoubleField<Pig> weight = DoubleField.create(
        Pig.class,
        "weight",
        Pig::getWeight,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field gender.
     */
    public static final ByteField<Pig> gender = ByteField.create(
        Pig.class,
        "gender",
        Pig::getGender,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field motherId.
     */
    public static final IntField<Pig> motherId = IntField.create(
        Pig.class,
        "motherId",
        Pig::getMotherId,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field code.
     */
    public static final StringField<Pig> code = StringField.create(
        Pig.class,
        "code",
        Pig::getCode,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field isDeleted.
     */
    public static final IntField<Pig> isDeleted = IntField.create(
        Pig.class,
        "isDeleted",
        Pig::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field cote.
     */
    public static final ReferenceField<Pig, Cote> cote = ReferenceField.create(
        Pig.class,
        "cote",
        Pig::getCote,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field importDate.
     */
    public static final ComparableField<Pig, LocalDate> importDate = ComparableField.create(
        Pig.class,
        "importDate",
        Pig::getImportDate,
        false
    );
    /**
     * This Field corresponds to the {@link Pig} field exportDate.
     */
    public static final ComparableField<Pig, LocalDate> exportDate = ComparableField.create(
        Pig.class,
        "exportDate",
        Pig::getExportDate,
        false
    );
}