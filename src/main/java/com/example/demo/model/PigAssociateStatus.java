package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "pig_associate_status")
public class PigAssociateStatus extends BaseEntity {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pig_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Pig pig;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pig_status_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PigStatus pigStatus;
}
