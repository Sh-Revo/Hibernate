package com.shandov.jdbcHomework;


import com.shandov.jdbcHomework.dao.*;
import com.shandov.jdbcHomework.domain.Companies;
import com.shandov.jdbcHomework.domain.Developers;
import com.shandov.jdbcHomework.service.*;

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

        // developersService.insertIntoDevelopers();
        // developersService.updateIntoDevelopers();
        // developersService.deleteFromDevelopers();
        // System.out.println("\nСписок всех разработчиков " + developersService.getAllDevelopers());



        //-----Companies

        // companiesService.insertIntoCompanies();
        // companiesService.updateInCompanies();
        // companiesService.deleteFromCompanies();
        // System.out.println("\nСписок всех компаний " + companiesService.getAllCompanies());



        //-----Customers

        // customersService.insertIntoCustomers();
        // customersService.updateInCustomers();
        // customersService.deleteFromCustomers();
        // System.out.println("\nСписок всех клиентов " + customersService.getAllCustomers());



        //-----Skills

        // skillsService.insertIntoSkills();
        // skillsService.updateInSkills();
        // skillsService.deleteFromSkills();
        // System.out.println("\nНазвания всех скиллов " + skillsService.getAllSkills());
    }
}
