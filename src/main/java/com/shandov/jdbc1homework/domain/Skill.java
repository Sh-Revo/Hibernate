package com.shandov.jdbc1homework.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "skills")
@ToString(exclude = "developers")
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

    @ManyToMany(mappedBy = "skills")
    private List<Developer> developers;

    public void setLvl(String lvl) {
        lvl = lvl.toLowerCase();
        if (lvl.equals(SkillLvl.JUNIOR.getSkillLvl())) {
            this.lvl = SkillLvl.JUNIOR;
        } else if (lvl.equals(SkillLvl.MIDDLE.getSkillLvl())) {
            this.lvl = SkillLvl.MIDDLE;
        } else if (lvl.equals(SkillLvl.SENIOR.getSkillLvl())) {
            this.lvl = SkillLvl.SENIOR;
        }
    }


}
