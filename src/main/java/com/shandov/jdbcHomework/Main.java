package com.shandov.jdbcHomework;


import com.shandov.jdbcHomework.dao.DevelopersDAO;
import com.shandov.jdbcHomework.dao.ProjectsDAO;
import com.shandov.jdbcHomework.domain.Developers;
import com.shandov.jdbcHomework.service.DevelopersService;
import com.shandov.jdbcHomework.service.ProjectsService;

public class Main {

    public static final ProjectsService projectsService = new ProjectsService(new ProjectsDAO());
    public static final DevelopersService developersService = new DevelopersService(new DevelopersDAO());


    public static void main(String[] args) {
        System.out.println("Зарплата всех разработчиков отдельного проекта: " + projectsService.salaryAllDevelopersByProjectName("Internet_Shop") + "\n");
        System.out.println("Спикок разработчиков отдельного проекта " + developersService.getAllDevelopersByProjectName("Internet_Shop"));
        System.out.println("Спикок Java разработчиков " + developersService.getAllJavaDevelopers("Java"));

    }
}
