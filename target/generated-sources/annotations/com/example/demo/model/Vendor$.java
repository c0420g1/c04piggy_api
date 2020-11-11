package com.example.demo.model;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.Set;

/**
 * The generated base for entity {@link Vendor} representing entities of the
 * {@code vendor}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Vendor$ {
    
    /**
<<<<<<< HEAD
     * This Field corresponds to the {@link Vendor} field id.
     */
    public static final IntField<Vendor> id = IntField.create(
        Vendor.class,
        "id",
        Vendor::getId,
=======
     * This Field corresponds to the {@link Vendor} field code.
     */
    public static final StringField<Vendor> code = StringField.create(
        Vendor.class,
        "code",
        Vendor::getCode,
>>>>>>> develop
        false
    );
    /**
     * This Field corresponds to the {@link Vendor} field description.
     */
    public static final StringField<Vendor> description = StringField.create(
        Vendor.class,
        "description",
        Vendor::getDescription,
        false
    );
    /**
<<<<<<< HEAD
     * This Field corresponds to the {@link Vendor} field isDeleted.
     */
    public static final IntField<Vendor> isDeleted = IntField.create(
        Vendor.class,
        "isDeleted",
        Vendor::getIsDeleted,
        false
    );
    /**
     * This Field corresponds to the {@link Vendor} field stocks.
     */
    public static final ReferenceField<Vendor, Set<Stock>> stocks = ReferenceField.create(
        Vendor.class,
        "stocks",
        Vendor::getStocks,
=======
     * This Field corresponds to the {@link Vendor} field stocks.
     */
    public static final ReferenceField<Vendor, Set<Stock>> stocks = ReferenceField.create(
        Vendor.class,
        "stocks",
        Vendor::getStocks,
        false
    );
    /**
     * This Field corresponds to the {@link Vendor} field isDeleted.
     */
    public static final IntField<Vendor> isDeleted = IntField.create(
        Vendor.class,
        "isDeleted",
        Vendor::getIsDeleted,
>>>>>>> develop
        false
    );
    /**
     * This Field corresponds to the {@link Vendor} field id.
     */
    public static final IntField<Vendor> id = IntField.create(
        Vendor.class,
        "id",
        Vendor::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Vendor} field name.
     */
    public static final StringField<Vendor> name = StringField.create(
        Vendor.class,
        "name",
        Vendor::getName,
        false
    );
}