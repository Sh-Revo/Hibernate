package com.shandov.jdbc1homework.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Developer {

    private Long id;
    private String name;
    private Integer age;
    private DevGender gender;
    private BigDecimal salary;

    public void setGender(String gender) {
        gender = gender.toLowerCase();
        if (gender.equals(DevGender.MALE.getDevGender())){
            this.gender = DevGender.MALE;
        }else if (gender.equals(DevGender.FEMALE.getDevGender())){
            this.gender =  DevGender.FEMALE;
        }
    }

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

