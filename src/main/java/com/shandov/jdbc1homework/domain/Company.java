package com.shandov.jdbc1homework.domain;


import lombok.Data;

@Data
public class Company {

    private Long companyId;
    private String companyName;
    private String companyLocation;

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                '}' + "\n";
    }
}
