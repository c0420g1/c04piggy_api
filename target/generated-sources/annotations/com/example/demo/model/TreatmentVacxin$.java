package com.example.demo.model;

import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.time.LocalDate;

/**
 * The generated base for entity {@link TreatmentVacxin} representing entities
 * of the {@code treatmentVacxin}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class TreatmentVacxin$ {
    
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field description.
     */
    public static final StringField<TreatmentVacxin> description = StringField.create(
        TreatmentVacxin.class,
        "description",
        TreatmentVacxin::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field pig.
     */
    public static final ReferenceField<TreatmentVacxin, Pig> pig = ReferenceField.create(
        TreatmentVacxin.class,
        "pig",
        TreatmentVacxin::getPig,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field type.
     */
    public static final StringField<TreatmentVacxin> type = StringField.create(
        TreatmentVacxin.class,
        "type",
        TreatmentVacxin::getType,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field isDeleted.
     */
    public static final IntField<TreatmentVacxin> isDeleted = IntField.create(
        TreatmentVacxin.class,
        "isDeleted",
        TreatmentVacxin::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field veterinary.
     */
    public static final StringField<TreatmentVacxin> veterinary = StringField.create(
        TreatmentVacxin.class,
        "veterinary",
        TreatmentVacxin::getVeterinary,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field id.
     */
    public static final IntField<TreatmentVacxin> id = IntField.create(
        TreatmentVacxin.class,
        "id",
        TreatmentVacxin::getId,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field diseases.
     */
    public static final ReferenceField<TreatmentVacxin, Diseases> diseases = ReferenceField.create(
        TreatmentVacxin.class,
        "diseases",
        TreatmentVacxin::getDiseases,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field treatDate.
     */
    public static final ComparableField<TreatmentVacxin, LocalDate> treatDate = ComparableField.create(
        TreatmentVacxin.class,
        "treatDate",
        TreatmentVacxin::getTreatDate,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field vacxin.
     */
    public static final ReferenceField<TreatmentVacxin, Vacxin> vacxin = ReferenceField.create(
        TreatmentVacxin.class,
        "vacxin",
        TreatmentVacxin::getVacxin,
        false
    );
    /**
     * This Field corresponds to the {@link TreatmentVacxin} field cote.
     */
    public static final ReferenceField<TreatmentVacxin, Cote> cote = ReferenceField.create(
        TreatmentVacxin.class,
        "cote",
        TreatmentVacxin::getCote,
        false
    );
}