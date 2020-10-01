package com.shandov.jdbcHomework.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Projects {

    private Long projectId;
    private String projectName;
    private String projectDescription;
    private BigDecimal projectCost;
}
