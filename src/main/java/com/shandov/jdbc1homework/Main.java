package com.shandov.jdbc1homework;


import com.shandov.jdbc1homework.dao.*;
import com.shandov.jdbc1homework.service.*;

import java.math.BigDecimal;

public class Main {

    public static final ProjectService projectsService = new ProjectService(new ProjectDAO());
    public static final DeveloperService developersService = new DeveloperService(new DeveloperDAO());
    public static final CompanyService companiesService = new CompanyService(new CompanyDAO());
    public static final CustomerService customersService = new CustomerService(new CustomerDAO());
    public static final SkillService skillsService = new SkillService(new SkillDAO());

    public static void main(String[] args) {
        // System.out.println("\nЗарплата всех разработчиков отдельного проекта: " + projectsService.salaryAllDevelopersByProjectName("Internet_Shop") + "\n");
        // System.out.println("\nСпикок разработчиков отдельного проекта " + developersService.getAllDevelopersByProjectName("Internet_Shop"));
        //System.out.println("\nСпикок Java разработчиков " + developersService.getAllDevelopersBySkillsName("Java"));
        //System.out.println("\nСпикок Middle разработчиков " + developersService.getAllDevelopersBySkillsLvl("Middle"));


        //-----Project

        // projectsService.insertIntoProjects("Doggy", "FleetWord", BigDecimal.valueOf(11000), LocalDate.of(2010,10,10));
        // projectsService.updateIntoProjects(6l, "DogFood", "Food for Dog", BigDecimal.valueOf(9000), LocalDate.of(2010,10,10));
        // projectsService.deleteFromProjects(7l);

        // System.out.println("\nСписок всех проектов " + projectsService.getAllProjects());


        //-----Developer

        // developersService.insertIntoDevelopers("Andrew", 29l, "Male", BigDecimal.valueOf(8500));
        // developersService.updateIntoDevelopers(15l, "Oleg", 22l, "Male", BigDecimal.valueOf(10000));
        // developersService.deleteFromDevelopers(14l);
        // System.out.println("\nСписок всех разработчиков " + developersService.getAllDevelopers());


        //-----Company

        // companiesService.insertIntoCompanies("Volodya", "Paris");
        // companiesService.updateInCompanies(1l, "Ubisoft", "London");
        // companiesService.deleteFromCompanies(8l);
        // System.out.println("\nСписок всех компаний " + companiesService.getAllCompanies());


        //-----Customer

        // customersService.insertIntoCustomers("Vladimir", "Belov");
        // customersService.updateInCustomers(2l, "Alex", "Belyaev");
        // customersService.deleteFromCustomers(4l);
        // System.out.println("\nСписок всех клиентов " + customersService.getAllCustomers());


        //-----Skill

        // skillsService.insertIntoSkills("HTML", "Middle");
        // skillsService.updateInSkills(13l, "Css", "Junior");
        // skillsService.deleteFromSkills(13l);
        // System.out.println("\nНазвания всех скиллов " + skillsService.getAllSkills());
    }
}
