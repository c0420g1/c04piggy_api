package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link Diseases} representing entities of the
 * {@code diseases}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Diseases$ {
    
    /**
     * This Field corresponds to the {@link Diseases} field name.
     */
    public static final StringField<Diseases> name = StringField.create(
        Diseases.class,
        "name",
        Diseases::getName,
        false
    );
    /**
     * This Field corresponds to the {@link Diseases} field description.
     */
    public static final StringField<Diseases> description = StringField.create(
        Diseases.class,
        "description",
        Diseases::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Diseases} field treatmentVacxins.
     */
    public static final ReferenceField<Diseases, Set<TreatmentVacxin>> treatmentVacxins = ReferenceField.create(
        Diseases.class,
        "treatmentVacxins",
        Diseases::getTreatmentVacxins,
        false
    );
    /**
     * This Field corresponds to the {@link Diseases} field id.
     */
    public static final IntField<Diseases> id = IntField.create(
        Diseases.class,
        "id",
        Diseases::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Diseases} field isDeleted.
     */
    public static final IntField<Diseases> isDeleted = IntField.create(
        Diseases.class,
        "isDeleted",
        Diseases::getIsDeleted,
        false
    );
}