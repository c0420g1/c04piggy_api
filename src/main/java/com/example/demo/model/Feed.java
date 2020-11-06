package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "feed")
public class Feed extends BaseEntity {
    private String code;
    private int amount;
    private String unit;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Pig> pigs;

    @ManyToOne
    @JoinColumn(name = "feed_type_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FeedType feedType;

    @ManyToOne
    @JoinColumn(name = "herd_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Herd herd;
}
