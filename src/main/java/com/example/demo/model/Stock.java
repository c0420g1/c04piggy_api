package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Builder
@Data
@Entity
@Table(name = "stock")
public class Stock extends BaseEntity {
    private String shipmentCode;
    @Column(columnDefinition="DATE")
    private LocalDate importDate;
    @Column(columnDefinition="DATE")
    private LocalDate mfgDate;
    @Column(columnDefinition="DATE")
    private LocalDate expDate;
    private int quantity;
    private String unit;

    @ManyToOne
    @JoinColumn(name = "feed_type_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FeedType feedType;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Vendor vendor;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<HistoryExport> historyExports;
}
