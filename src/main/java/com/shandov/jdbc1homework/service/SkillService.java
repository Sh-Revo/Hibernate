package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.SkillDAO;
import com.shandov.jdbc1homework.domain.Skill;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SkillService {

    private final SkillDAO skillsDAO;

    public void insertInSkill(Skill skill){
        skillsDAO.insert(skill);
    }

    public void updateInSkill(Skill skill){
        skillsDAO.update(skill, skill.getId());
    }

    public void deleteInSkill(Long id){
        skillsDAO.delete(id);
    }

    public List<Skill> getAllSkill(){
        return skillsDAO.getAll();
    }

}
