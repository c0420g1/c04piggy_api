package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link Vacxin} representing entities of the
 * {@code vacxin}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Vacxin$ {
    
    /**
     * This Field corresponds to the {@link Vacxin} field description.
     */
    public static final StringField<Vacxin> description = StringField.create(
        Vacxin.class,
        "description",
        Vacxin::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Vacxin} field name.
     */
    public static final StringField<Vacxin> name = StringField.create(
        Vacxin.class,
        "name",
        Vacxin::getName,
        false
    );
    /**
     * This Field corresponds to the {@link Vacxin} field isDeleted.
     */
    public static final IntField<Vacxin> isDeleted = IntField.create(
        Vacxin.class,
        "isDeleted",
        Vacxin::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Vacxin} field id.
     */
    public static final IntField<Vacxin> id = IntField.create(
        Vacxin.class,
        "id",
        Vacxin::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Vacxin} field treatmentVacxins.
     */
    public static final ReferenceField<Vacxin, Set<TreatmentVacxin>> treatmentVacxins = ReferenceField.create(
        Vacxin.class,
        "treatmentVacxins",
        Vacxin::getTreatmentVacxins,
        false
    );
}