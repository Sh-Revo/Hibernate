package com.shandov.jdbcHomework.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Projects {

    private Long project_id;
    private String project_name;
    private String project_description;
    private BigDecimal cost;
}
