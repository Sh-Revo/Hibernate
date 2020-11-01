package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.ProjectDAO;
import com.shandov.jdbc1homework.domain.Project;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProjectService {


    private final ProjectDAO projectDAO;

    public void insertInProject(Project project){
        projectDAO.insert(project);
    }

    public void updateInProject(Project project){
        projectDAO.update(project, project.getId());
    }

    public void deleteInProject(Long id){
        projectDAO.delete(id);
    }

    public List<Project> getAllProject(){
        return projectDAO.getAll();
    }
}
