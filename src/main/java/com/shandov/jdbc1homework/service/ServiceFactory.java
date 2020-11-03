package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.*;


public class ServiceFactory {

    public CompanyService getCompanyService() {
        return new CompanyService(new CompanyDAO());
    }

    public CustomerService getCustomerService() {
        return new CustomerService(new CustomerDAO());
    }

    public ProjectService getProjectService() {
        return new ProjectService(new ProjectDAO());
    }

    public DeveloperService getDeveloperService() {
        return new DeveloperService(new DeveloperDAO());
    }

    public SkillService getSkillService() {
        return new SkillService(new SkillDAO());
    }

}
