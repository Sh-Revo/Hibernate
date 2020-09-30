package com.shandov.jdbcHomework;


import com.shandov.jdbcHomework.dao.ProjectsDAO;
import com.shandov.jdbcHomework.service.ProjectsService;

public class Main {

    public static final ProjectsService projectsService = new ProjectsService(new ProjectsDAO());

    public static void main(String[] args) {
        System.out.println("Зарплата всех разработчиков отдельного проекта: " + projectsService.salaryAllDevelopersByProjectName("Internet_Shop"));
    }
}
