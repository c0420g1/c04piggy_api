package com.example.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "other")
public class Other extends BaseEntity {
    private String name;
    private String title;
    private String type;
    private String url;
    @Column(columnDefinition="DATE", name="create_date")
    private LocalDate createDate;
    @Column(columnDefinition = "integer default 0", name = "is_other")
    private int isOther=0;
    @Column(columnDefinition = "integer default 0", name = "ref_id")
    private int refId;
}
