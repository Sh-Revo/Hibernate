package com.shandov.jdbcHomework.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Developers {

    private Long dev_id;
    private String dev_name;
    private Long dev_age;
    private String dev_gender;
    private BigDecimal salary;
}
