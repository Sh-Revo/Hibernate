package com.shandov.jdbc1homework.service;


import com.shandov.jdbc1homework.dao.DevelopersDAO;
import com.shandov.jdbc1homework.domain.Developers;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class DevelopersService {

    private final DevelopersDAO developersDAO;

    public List<Developers> getAllDevelopersByProjectName(String message) {
        return developersDAO.getAllDevelopersByProjectName(message);
    }

    public List<Developers> getAllJavaDevelopers(String message) {
        return developersDAO.getAllJavaDevelopers(message);
    }

    public List<Developers> getAllMiddleDevelopers(String message) {
        return developersDAO.getAllMiddleDevelopers(message);
    }

    public List<Developers> getAllDevelopers() {
        return developersDAO.getAllDevelopers();
    }

    public void insertIntoDevelopers(String devName, Long devAge, String devGender, BigDecimal devSalary) {
        developersDAO.insertIntoDevelopers(devName, devAge, devGender, devSalary);
    }

    public void updateIntoDevelopers(Long id, BigDecimal salary) {
        developersDAO.updateIntoDevelopers(id,salary);
    }

    public void deleteFromDevelopers(Long id) {
        developersDAO.deleteFromDevelopers(id);
    }
}
