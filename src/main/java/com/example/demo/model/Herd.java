package com.example.demo.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "herd")
public class Herd extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "herd", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Feed> feeds;

    @OneToMany(mappedBy = "herd", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Cote> cotes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(Collection<Feed> feeds) {
        this.feeds = feeds;
    }

    public Collection<Cote> getCotes() {
        return cotes;
    }

    public void setCotes(Collection<Cote> cotes) {
        this.cotes = cotes;
    }
}
