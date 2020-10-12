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

    public void insertIntoSkills() {
        try {
            skillsDAO.insertIntoSkills();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateInSkills() {
        try {
            skillsDAO.updateInSkills();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromSkills() {
        try {
            skillsDAO.deleteFromSkills();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
