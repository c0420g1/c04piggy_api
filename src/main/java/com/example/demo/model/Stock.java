package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "stock")
public class Stock extends BaseEntity {
    private String shipmentCode;
    @Column(columnDefinition="DATE", name = "import_date")
    private LocalDate importDate;
    @Column(columnDefinition="DATE", name= "mfg_date")
    private LocalDate mfgDate;
    @Column(columnDefinition="DATE", name = "exp_date")
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

    @OneToMany(mappedBy = "stock")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<HistoryExport> historyExports;
}
