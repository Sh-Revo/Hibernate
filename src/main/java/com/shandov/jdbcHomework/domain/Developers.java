package com.shandov.jdbcHomework.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Developers {

    private Long devId;
    private String devName;
    private Long devAge;
    private String devGender;
    private BigDecimal devSalary;
}
