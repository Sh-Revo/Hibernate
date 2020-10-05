package com.shandov.jdbcHomework.domain;

import lombok.Data;

@Data
public class Skills {

    private Long skillsId;
    private String skillsName;
    private String skillsLvl;


    @Override
    public String toString() {
        return "Skills{" +
                "skillsId=" + skillsId +
                ", skillsName='" + skillsName + '\'' +
                ", skillsLvl='" + skillsLvl + '\'' +
                '}' + "\n";
    }
}
