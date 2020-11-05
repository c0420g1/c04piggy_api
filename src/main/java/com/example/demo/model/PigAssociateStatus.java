package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Builder
@Data
@Entity
@Table(name = "pig_associate_status")
public class PigAssociateStatus extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "pig_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Pig pig;

    @ManyToOne
    @JoinColumn(name = "pig_status_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PigStatus pigStatus;
}
