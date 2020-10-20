package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.ProjectDAO;
import com.shandov.jdbc1homework.domain.Project;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class ProjectService {


    private final ProjectDAO projectDAO;

    public BigDecimal salaryAllDevelopersByProjectName(String message) {
        return projectDAO.salaryAllDevelopersByProjectName(message);
    }

    public List<Project> getAllProjectsByCountDevelopers() {
        return projectDAO.getAllProjectsByCountDevelopers();
    }

    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    public void insertIntoProjects(String name, String description, BigDecimal cost, LocalDate start) {
        projectDAO.insertIntoProjects(name, description, cost, start);
    }

    public void updateIntoProjects(Long id, String name, String description, BigDecimal cost, LocalDate start) {
        projectDAO.updateIntoProjects(id, name, description, cost, start);
    }

    public void deleteFromProjects(Long id) {
        projectDAO.deleteFromProjects(id);
    }
}
