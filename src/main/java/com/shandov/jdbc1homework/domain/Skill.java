package com.shandov.jdbc1homework.domain;

import lombok.Data;

@Data
public class Skill {

    private Long skillsId;
    private String skillsName;
    private SkillLvl skillLvl;

    public void setSkillLvl(String skillLvl){
        skillLvl = skillLvl.toLowerCase();
        if (skillLvl.equals(SkillLvl.JUNIOR.getSkillLvl())){
            this.skillLvl = SkillLvl.JUNIOR;
        } else if (skillLvl.equals(SkillLvl.MIDDLE.getSkillLvl())){
            this.skillLvl = SkillLvl.MIDDLE;
        } else if (skillLvl.equals(SkillLvl.SENIOR.getSkillLvl())) {
            this.skillLvl = SkillLvl.SENIOR;
        }
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillsId=" + skillsId +
                ", skillsName='" + skillsName + '\'' +
                ", skillsLvl='" + skillLvl + '\'' +
                '}' + "\n";
    }
}
