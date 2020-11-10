package com.example.demo.model;

import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.time.LocalDate;
import java.util.Set;

/**
 * The generated base for entity {@link Stock} representing entities of the
 * {@code stock}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Stock$ {
    
    /**
     * This Field corresponds to the {@link Stock} field historyExports.
     */
    public static final ReferenceField<Stock, Set<HistoryExport>> historyExports = ReferenceField.create(
        Stock.class,
        "historyExports",
        Stock::getHistoryExports,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field unit.
     */
    public static final StringField<Stock> unit = StringField.create(
        Stock.class,
        "unit",
        Stock::getUnit,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field feedType.
     */
    public static final ReferenceField<Stock, FeedType> feedType = ReferenceField.create(
        Stock.class,
        "feedType",
        Stock::getFeedType,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field mfgDate.
     */
    public static final ComparableField<Stock, LocalDate> mfgDate = ComparableField.create(
        Stock.class,
        "mfgDate",
        Stock::getMfgDate,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field id.
     */
    public static final IntField<Stock> id = IntField.create(
        Stock.class,
        "id",
        Stock::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field vendor.
     */
    public static final ReferenceField<Stock, Vendor> vendor = ReferenceField.create(
        Stock.class,
        "vendor",
        Stock::getVendor,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field expDate.
     */
    public static final ComparableField<Stock, LocalDate> expDate = ComparableField.create(
        Stock.class,
        "expDate",
        Stock::getExpDate,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field shipmentCode.
     */
    public static final StringField<Stock> shipmentCode = StringField.create(
        Stock.class,
        "shipmentCode",
        Stock::getShipmentCode,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field isDeleted.
     */
    public static final IntField<Stock> isDeleted = IntField.create(
        Stock.class,
        "isDeleted",
        Stock::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field quantity.
     */
    public static final IntField<Stock> quantity = IntField.create(
        Stock.class,
        "quantity",
        Stock::getQuantity,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field importDate.
     */
    public static final ComparableField<Stock, LocalDate> importDate = ComparableField.create(
        Stock.class,
        "importDate",
        Stock::getImportDate,
        false
    );
    /**
     * This Field corresponds to the {@link Stock} field description.
     */
    public static final StringField<Stock> description = StringField.create(
        Stock.class,
        "description",
        Stock::getDescription,
        false
    );
}