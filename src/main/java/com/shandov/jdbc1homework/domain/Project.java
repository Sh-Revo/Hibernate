package com.shandov.jdbc1homework.domain;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Project {

    private Long projectId;
    private String projectName;
    private String projectDescription;
    private Date projectStart;
    private BigDecimal projectCost;

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectStart=" + projectStart +
                ", projectCost=" + projectCost +
                '}' + "\n";
    }
}
