package com.shandov.jdbcHomework.domain;


import lombok.Data;

@Data
public class Companies {

    private Long companyId;
    private String companyName;
    private String companyLocation;

    @Override
    public String toString() {
        return "Companies{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                '}' + "\n";
    }
}
