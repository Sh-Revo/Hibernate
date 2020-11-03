package com.shandov.jdbc1homework.domain;


import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "projects")
@ToString(exclude = "developers")
public class Project {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String name;

    @Column(name = "project_description")
    private String description;

    @Column(name = "project_start")
    private LocalDate start;

    @Column(name = "cost")
    private BigDecimal cost;

    @ManyToMany(mappedBy = "projects")
    List<Developer> developers;

}
