package com.shandov.jdbc1homework.service;


import com.shandov.jdbc1homework.dao.DeveloperDAO;
import com.shandov.jdbc1homework.domain.Developer;
import com.shandov.jdbc1homework.domain.Skill;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperDAO developerDAO;

    public void insertInDeveloper(Developer developer) {
        developerDAO.insert(developer);
    }

    public void updateInDeveloper(Developer developer) {
        developerDAO.update(developer, developer.getId());
    }

    public void deleteInDeveloper(Long id) {
        developerDAO.delete(id);
    }

    public List<Developer> getAllDeveloper() {
        return developerDAO.getAll();
    }

    public List<Developer> getDeveloperBySkillsName(String name) {
        return developerDAO.getDeveloperBySkillsName(name);
    }

    public List<Developer> getDeveloperBySkillsLvl(Skill skill) {
        return developerDAO.getDeveloperBySkillsLvl(skill);
    }

    public List<Developer> getDeveloperByProjectName(String name) {
        return developerDAO.getDeveloperByProjectName(name);
    }

    public BigDecimal salaryAllDevelopersByProjectName(String name) {
        return developerDAO.salaryAllDevelopersByProjectName(name);
    }
}
