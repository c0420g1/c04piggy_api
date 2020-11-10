package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "other")
public class Other {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer default 0", name ="is_deleted")
    private int isDeleted=0;

    @Column(length = 1000)
    private String description;
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
