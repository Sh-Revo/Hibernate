package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.SkillsDAO;
import com.shandov.jdbc1homework.domain.Skills;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class SkillsService {

    private final SkillsDAO skillsDAO;

    public List<Skills> getAllSkills() {
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
