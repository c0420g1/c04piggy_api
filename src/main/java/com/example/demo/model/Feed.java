package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "feed")
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer default 0", name ="is_deleted")
    private int isDeleted=0;

    @Column(length = 1000)
    private String description;
    private String code;
    private int amount;
    private String unit;

    @OneToMany(mappedBy = "feed")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Pig> pigs;

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
