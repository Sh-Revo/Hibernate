package com.shandov.jdbc1homework;


import com.shandov.jdbc1homework.dao.*;
import com.shandov.jdbc1homework.domain.*;
import com.shandov.jdbc1homework.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static void main(String[] args) {

//         System.out.println("\nЗарплата всех разработчиков отдельного проекта: " + serviceFactory.getDeveloperService().salaryAllDevelopersByProjectName("Internet_Shop") + "\n");
//         System.out.println("\nСпикок разработчиков отдельного проекта " + serviceFactory.getDeveloperService().getDeveloperByProjectName("Internet_Shop"));
//         System.out.println("\nСпикок Java разработчиков " + serviceFactory.getDeveloperService().getDeveloperBySkillsName("JS"));
//         Skill skill = new Skill();
//         skill.setLvl("MIDDLE");
//         System.out.println("\nСпикок Middle разработчиков " + serviceFactory.getDeveloperService().getDeveloperBySkillsLvl(skill));
//         System.out.println("Get ALL " + serviceFactory.getDeveloperService().getAllDeveloper());

        //-----Project

//        Project project = new Project();
//        project.setName("Doggy");
//        project.setDescription("FleetWord");
//        project.setCost(BigDecimal.valueOf(11000));
//        project.setStart(LocalDate.of(2010,10,10));
//        serviceFactory.getProjectService().insertInProject(project);
//        project.setId(6l);
//        project.setName("DogFood");
//        project.setDescription("Food for Dog");
//        project.setCost(BigDecimal.valueOf(9000));
//        project.setStart(LocalDate.of(2010,10,10));
//        serviceFactory.getProjectService().updateInProject(project);
//        serviceFactory.getProjectService().deleteInProject(6l);
//        System.out.println("\nСписок всех проектов " + serviceFactory.getProjectService().getAllProject());


        //-----Developer

//        Developer developer = new Developer();
//        developer.setName("Andrew");
//        developer.setAge(29);
//        developer.setGender("Male");
//        developer.setSalary(BigDecimal.valueOf(8500));
//        serviceFactory.getDeveloperService().insertInDeveloper(developer);
//        developer.setId(15l);
//        developer.setName("Oleg");
//        developer.setAge(22);
//        developer.setGender("Male");
//        developer.setSalary(BigDecimal.valueOf(10000));
//        serviceFactory.getDeveloperService().updateInDeveloper(developer);
//        serviceFactory.getDeveloperService().deleteInDeveloper(15l);
//        System.out.println("\nСписок всех разработчиков " + serviceFactory.getDeveloperService().getAllDeveloper());


        //-----Company

        //Company company = new Company();
        //company.setName("Volodya");
        //company.setLocation("Paris");
        //serviceFactory.getCompanyService().insertInCompany(company);
        //company.setId(5l);
        //company.setName("Ubisoft");
        //company.setLocation("London");
        //serviceFactory.getCompanyService().updateInCompany(company);
        //serviceFactory.getCompanyService().deleteInCompany(6l);
        //System.out.println("\nСписок всех компаний " + serviceFactory.getCompanyService().getAllCompanies());


        //-----Customer

//        Customer customer = new Customer();
//        customer.setName("Vladimir");
//        customer.setSecondName("Belov");
//        serviceFactory.getCustomerService().insertInCustomer(customer);
//        customer.setId(4l);
//        customer.setName("Alex");
//        customer.setSecondName("Belyaev");
//        serviceFactory.getCustomerService().updateInCustomer(customer);
//        serviceFactory.getCustomerService().deleteInCustomer(4l);
//        System.out.println("\nСписок всех клиентов " + serviceFactory.getCustomerService().getAllCustomer());


        //-----Skill

//        Skill skill = new Skill();
//        skill.setName("Basic");
//        skill.setLvl("middle");
//        serviceFactory.getSkillService().insertInSkill(skill);
//        skill.setId(14l);
//        skill.setName("Css");
//        skill.setLvl("Junior");
//        serviceFactory.getSkillService().updateInSkill(skill);
//        serviceFactory.getSkillService().deleteInSkill(16l);
//        System.out.println("\nНазвания всех скиллов " + serviceFactory.getSkillService().getAllSkill());
    }
}
