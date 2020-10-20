package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.SkillDAO;
import com.shandov.jdbc1homework.domain.Skill;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SkillService {

    private final SkillDAO skillsDAO;

    public List<Skill> getAllSkills() {
        return skillsDAO.getAllSkills();
    }

    public void insertIntoSkills(String name, String lvl) {
        skillsDAO.insertIntoSkills(name, lvl);
    }

    public void updateInSkills(Long id, String name, String lvl) {
        skillsDAO.updateInSkills(id, name, lvl);
    }

    public void deleteFromSkills(Long id) {
        skillsDAO.deleteFromSkills(id);
    }
}
