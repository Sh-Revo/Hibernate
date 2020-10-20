package com.shandov.jdbc1homework.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Developer {

    private Long devId;
    private String devName;
    private Long devAge;
    private DevGender devGender;
    private BigDecimal devSalary;

    public void setDevGender(String devGender) {
        devGender = devGender.toLowerCase();
        if (devGender.equals(DevGender.MALE.getDevGender())){
            this.devGender = DevGender.MALE;
        }else if (devGender.equals(DevGender.FEMALE.getDevGender())){
            this.devGender =  DevGender.FEMALE;
        }
    }

    @Override
    public String toString() {
        return "Developer{" +
                "devId=" + devId +
                ", devName='" + devName + '\'' +
                ", devAge=" + devAge +
                ", devGender='" + devGender + '\'' +
                ", devSalary=" + devSalary +
                '}' + "\n";
    }
}

