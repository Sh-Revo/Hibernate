package com.shandov.jdbc1homework.domain;


import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "dev_id")
    private Long id;

    @Column(name = "dev_name")
    private String name;

    @Column(name = "dev_age")
    private Integer age;

    @Column(name = "dev_gender")
    @Enumerated(EnumType.STRING)
    private DevGender gender;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToMany
    @JoinTable(name = "dev_skills", joinColumns = @JoinColumn(name = "dev_id"), inverseJoinColumns = @JoinColumn(name = "skills_id"))
    private List<Skill> skills;

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}

