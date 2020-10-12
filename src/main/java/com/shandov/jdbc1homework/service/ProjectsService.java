package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.ProjectsDAO;
import com.shandov.jdbc1homework.domain.Projects;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.sql.SQLException;
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

    public void insertIntoProjects() {
        try {
            projectsDAO.insertIntoProjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateIntoProjects() {
        try {
            projectsDAO.updateIntoProjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromProjects() {
        try {
            projectsDAO.deleteFromProjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
