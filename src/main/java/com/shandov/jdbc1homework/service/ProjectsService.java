package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.ProjectsDAO;
import com.shandov.jdbc1homework.domain.Projects;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class ProjectsService {


    private final ProjectsDAO projectsDAO;

    public BigDecimal salaryAllDevelopersByProjectName(String message) {
        return projectsDAO.salaryAllDevelopersByProjectName(message);
    }

    public List<Projects> getAllProjectsByCountDevelopers() {
        return projectsDAO.getAllProjectsByCountDevelopers();
    }

    public List<Projects> getAllProjects() {
        return projectsDAO.getAllProjects();
    }

    public void insertIntoProjects(String name, String description, BigDecimal cost, LocalDate start) {
        projectsDAO.insertIntoProjects(name, description, cost, start);
    }

    public void updateIntoProjects(Long id, String description) {
        projectsDAO.updateIntoProjects(id, description);
    }

    public void deleteFromProjects(Long id) {
        projectsDAO.deleteFromProjects(id);
    }
}
