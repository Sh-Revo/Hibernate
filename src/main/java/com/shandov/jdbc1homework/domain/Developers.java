package com.shandov.jdbc1homework.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Developers {

    private Long devId;
    private String devName;
    private Long devAge;
    private String devGender;
    private BigDecimal devSalary;

    @Override
    public String toString() {
        return "Developers{" +
                "devId=" + devId +
                ", devName='" + devName + '\'' +
                ", devAge=" + devAge +
                ", devGender='" + devGender + '\'' +
                ", devSalary=" + devSalary +
                '}' + "\n";
    }
}

