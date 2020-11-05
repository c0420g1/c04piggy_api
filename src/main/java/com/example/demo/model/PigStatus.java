package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Builder
@Data
@Entity
@Table(name = "pig_status")
public class PigStatus extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "pigStatus", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<PigAssociateStatus> pigAssociateStatuses;
}
