package com.shandov.jdbc1homework.domain;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Projects {

    private Long projectId;
    private String projectName;
    private String projectDescription;
    private Date projectStart;
    private BigDecimal projectCost;

    @Override
    public String toString() {
        return "Projects{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectStart=" + projectStart +
                ", projectCost=" + projectCost +
                '}' + "\n";
    }
}
