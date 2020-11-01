package com.shandov.jdbc1homework.domain;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "projects")
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

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + id +
                ", projectName='" + name + '\'' +
                ", projectDescription='" + description + '\'' +
                ", projectStart=" + start +
                ", projectCost=" + cost +
                '}' + "\n";
    }

}
