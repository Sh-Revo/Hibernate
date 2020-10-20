package com.shandov.jdbc1homework.domain;

public enum SkillLvl {

    JUNIOR("junior"),
    MIDDLE("middle"),
    SENIOR("senior");

    private String skillLvl;

    SkillLvl(String skillLvl){
        this.skillLvl = skillLvl;
    }

    String getSkillLvl(){
        return skillLvl;
    }
}
