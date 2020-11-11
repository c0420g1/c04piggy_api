package com.example.demo.model;

import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.time.LocalDate;
import java.util.Set;

/**
 * The generated base for entity {@link Cote} representing entities of the
 * {@code cote}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Cote$ {
    
    /**
     * This Field corresponds to the {@link Cote} field treatmentVacxins.
     */
    public static final ReferenceField<Cote, Set<TreatmentVacxin>> treatmentVacxins = ReferenceField.create(
        Cote.class,
        "treatmentVacxins",
        Cote::getTreatmentVacxins,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field importDate.
     */
    public static final ComparableField<Cote, LocalDate> importDate = ComparableField.create(
        Cote.class,
        "importDate",
        Cote::getImportDate,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field description.
     */
    public static final StringField<Cote> description = StringField.create(
        Cote.class,
        "description",
        Cote::getDescription,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field isDeleted.
     */
    public static final IntField<Cote> isDeleted = IntField.create(
        Cote.class,
        "isDeleted",
        Cote::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field exportDate.
     */
    public static final ComparableField<Cote, LocalDate> exportDate = ComparableField.create(
        Cote.class,
        "exportDate",
        Cote::getExportDate,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field historyExports.
     */
    public static final ReferenceField<Cote, Set<HistoryExport>> historyExports = ReferenceField.create(
        Cote.class,
        "historyExports",
        Cote::getHistoryExports,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field id.
     */
    public static final IntField<Cote> id = IntField.create(
        Cote.class,
        "id",
        Cote::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field type.
     */
    public static final StringField<Cote> type = StringField.create(
        Cote.class,
        "type",
        Cote::getType,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field quantity.
     */
    public static final IntField<Cote> quantity = IntField.create(
        Cote.class,
        "quantity",
        Cote::getQuantity,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field employee.
     */
    public static final ReferenceField<Cote, Employee> employee = ReferenceField.create(
        Cote.class,
        "employee",
        Cote::getEmployee,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field herd.
     */
    public static final ReferenceField<Cote, Herd> herd = ReferenceField.create(
        Cote.class,
        "herd",
        Cote::getHerd,
        false
    );
    /**
     * This Field corresponds to the {@link Cote} field code.
     */
    public static final StringField<Cote> code = StringField.create(
        Cote.class,
        "code",
        Cote::getCode,
        false
    );
}