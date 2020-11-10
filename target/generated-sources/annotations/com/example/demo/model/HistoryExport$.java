package com.example.demo.model;

import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.time.LocalDate;

/**
 * The generated base for entity {@link HistoryExport} representing entities of
 * the {@code historyExport}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class HistoryExport$ {
    
    /**
     * This Field corresponds to the {@link HistoryExport} field quantity.
     */
    public static final IntField<HistoryExport> quantity = IntField.create(
        HistoryExport.class,
        "quantity",
        HistoryExport::getQuantity,
        false
    );
    /**
     * This Field corresponds to the {@link HistoryExport} field stock.
     */
    public static final ReferenceField<HistoryExport, Stock> stock = ReferenceField.create(
        HistoryExport.class,
        "stock",
        HistoryExport::getStock,
        false
    );
    /**
     * This Field corresponds to the {@link HistoryExport} field company.
     */
    public static final StringField<HistoryExport> company = StringField.create(
        HistoryExport.class,
        "company",
        HistoryExport::getCompany,
        false
    );
    /**
     * This Field corresponds to the {@link HistoryExport} field unit.
     */
    public static final StringField<HistoryExport> unit = StringField.create(
        HistoryExport.class,
        "unit",
        HistoryExport::getUnit,
        false
    );
    /**
     * This Field corresponds to the {@link HistoryExport} field type.
     */
    public static final StringField<HistoryExport> type = StringField.create(
        HistoryExport.class,
        "type",
        HistoryExport::getType,
        false
    );
    /**
     * This Field corresponds to the {@link HistoryExport} field exportDate.
     */
    public static final ComparableField<HistoryExport, LocalDate> exportDate = ComparableField.create(
        HistoryExport.class,
        "exportDate",
        HistoryExport::getExportDate,
        false
    );
    /**
     * This Field corresponds to the {@link HistoryExport} field employee.
     */
    public static final ReferenceField<HistoryExport, Employee> employee = ReferenceField.create(
        HistoryExport.class,
        "employee",
        HistoryExport::getEmployee,
        false
    );
    /**
     * This Field corresponds to the {@link HistoryExport} field cote.
     */
    public static final ReferenceField<HistoryExport, Cote> cote = ReferenceField.create(
        HistoryExport.class,
        "cote",
        HistoryExport::getCote,
        false
    );
    /**
     * This Field corresponds to the {@link HistoryExport} field
     * receivedEmployeeId.
     */
    public static final IntField<HistoryExport> receivedEmployeeId = IntField.create(
        HistoryExport.class,
        "receivedEmployeeId",
        HistoryExport::getReceivedEmployeeId,
        false
    );
}