package com.shandov.jdbc1homework.domain;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

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


    @Override
    public String toString() {
        return "Developer{" +
                "devId=" + id +
                ", devName='" + name + '\'' +
                ", devAge=" + age +
                ", devGender='" + gender + '\'' +
                ", devSalary=" + salary +
                '}' + "\n";
    }
}

