package com.shandov.jdbc1homework.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_second_name")
    private String secondName;

    @Override
    public String toString() {
        return "Customer{" +
                "customersId=" + id +
                ", customersName='" + name + '\'' +
                ", customersSecondName='" + secondName + '\'' +
                '}' + "\n";
    }
}
