package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "stock")
public class Stock extends BaseEntity {
    @Column(name = "shipment_code")
    private String shipmentCode;
    @Column(columnDefinition="DATE", name="import_date")
    private LocalDate importDate;
    @Column(columnDefinition="DATE", name="mfg_date")
    private LocalDate mfgDate;
    @Column(columnDefinition="DATE", name="exp_date")
    private LocalDate expDate;
    private int quantity;
    private String unit;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "feed_type_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FeedType feedType;

    @JsonIgnore
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
