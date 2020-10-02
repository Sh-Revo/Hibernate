package com.shandov.jdbcHomework.service;

import com.shandov.jdbcHomework.dao.ProjectsDAO;
import com.shandov.jdbcHomework.domain.Projects;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class ProjectsService {


    private final ProjectsDAO projectsDAO;

    public BigDecimal salaryAllDevelopersByProjectName(String message){
        return projectsDAO.salaryAllDevelopersByProjectName(message);
    }

    public List<Projects> getAllProjects(){
        return projectsDAO.getAllProjects();
    }
}
