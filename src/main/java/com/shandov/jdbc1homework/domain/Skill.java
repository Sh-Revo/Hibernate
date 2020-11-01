package com.shandov.jdbc1homework.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "skills_id")
    private Long id;

    @Column(name = "skills_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "skills_lvl")
    private SkillLvl lvl;

    public void setLvl(String lvl){
        lvl = lvl.toLowerCase();
        if (lvl.equals(SkillLvl.JUNIOR.getSkillLvl())){
            this.lvl = SkillLvl.JUNIOR;
        } else if (lvl.equals(SkillLvl.MIDDLE.getSkillLvl())){
            this.lvl = SkillLvl.MIDDLE;
        } else if (lvl.equals(SkillLvl.SENIOR.getSkillLvl())) {
            this.lvl = SkillLvl.SENIOR;
        }
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillsId=" + id +
                ", skillsName='" + name + '\'' +
                ", skillsLvl='" + lvl + '\'' +
                '}' + "\n";
    }
}
