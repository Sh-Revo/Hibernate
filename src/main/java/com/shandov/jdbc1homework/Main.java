package com.shandov.jdbc1homework;


import com.shandov.jdbc1homework.dao.*;
import com.shandov.jdbc1homework.service.*;

import java.math.BigDecimal;

public class Main {

    public static final ProjectsService projectsService = new ProjectsService(new ProjectsDAO());
    public static final DevelopersService developersService = new DevelopersService(new DevelopersDAO());
    public static final CompaniesService companiesService = new CompaniesService(new CompaiesDAO());
    public static final CustomersService customersService = new CustomersService(new CustomersDAO());
    public static final SkillsService skillsService = new SkillsService(new SkillsDAO());

    public static void main(String[] args) {
        //System.out.println("\nЗарплата всех разработчиков отдельного проекта: " + projectsService.salaryAllDevelopersByProjectName("Internet_Shop") + "\n");
        //System.out.println("\nСпикок разработчиков отдельного проекта " + developersService.getAllDevelopersByProjectName("Internet_Shop"));
        //System.out.println("\nСпикок Java разработчиков " + developersService.getAllJavaDevelopers("Java"));
        //System.out.println("\nСпикок Middle разработчиков " + developersService.getAllMiddleDevelopers("Middle"));


        //-----Projects

        // projectsService.insertIntoProjects();
        // projectsService.updateIntoProjects();
        // projectsService.deleteFromProjects();

        // System.out.println("\nСписок всех проектов " + projectsService.getAllProjects());


        //-----Developers

        // developersService.insertIntoDevelopers("Ivan", 24l, "Male", BigDecimal.valueOf(11000));
        // developersService.updateIntoDevelopers(15l, BigDecimal.valueOf(10000));
        // developersService.deleteFromDevelopers(14l);
        // System.out.println("\nСписок всех разработчиков " + developersService.getAllDevelopers());


        //-----Companies

        // companiesService.insertIntoCompanies("Volodya", "Paris");
        // companiesService.updateInCompanies(8l, "Ubisoft");
        // companiesService.deleteFromCompanies(8l);
        // System.out.println("\nСписок всех компаний " + companiesService.getAllCompanies());


        //-----Customers

        // customersService.insertIntoCustomers("Vladimir", "Belov");
        // customersService.updateInCustomers(4l, "Belyaev");
        // customersService.deleteFromCustomers(4l);
        // System.out.println("\nСписок всех клиентов " + customersService.getAllCustomers());


        //-----Skills

        // skillsService.insertIntoSkills("HTML", "Middle");
        // skillsService.updateInSkills(13l, "Css");
        // skillsService.deleteFromSkills(13l);
        // System.out.println("\nНазвания всех скиллов " + skillsService.getAllSkills());
    }
}
