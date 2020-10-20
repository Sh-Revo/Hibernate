package com.shandov.jdbc1homework.service;


import com.shandov.jdbc1homework.dao.DeveloperDAO;
import com.shandov.jdbc1homework.domain.Developer;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperDAO developerDAO;

    public List<Developer> getAllDevelopersByProjectName(String name) {
        return developerDAO.getAllDevelopersByProjectName(name);
    }

    public List<Developer> getAllDevelopersBySkillsName(String name) {
        return developerDAO.getAllDevelopersBySkillsName(name);
    }

    public List<Developer> getAllDevelopersBySkillsLvl(String lvl) {
        return developerDAO.getAllDevelopersBySkillsLvl(lvl);
    }

    public List<Developer> getAllDevelopers() {
        return developerDAO.getAllDevelopers();
    }

    public void insertIntoDevelopers(String name, Integer age, String gender, BigDecimal salary) {
        developerDAO.insertIntoDevelopers(name, age, gender, salary);
    }

    public void updateIntoDevelopers(Long id, String name, Integer age, String gender, BigDecimal salary) {
        developerDAO.updateIntoDevelopers(id, name, age, gender, salary);
    }

    public void deleteFromDevelopers(Long id) {
        developerDAO.deleteFromDevelopers(id);
    }
}
