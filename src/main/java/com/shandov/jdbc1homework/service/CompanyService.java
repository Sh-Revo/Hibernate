package com.shandov.jdbc1homework.service;


import com.shandov.jdbc1homework.dao.CompanyDAO;
import com.shandov.jdbc1homework.domain.Company;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompanyService {

    private final CompanyDAO companyDAO;

    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    public void insertIntoCompanies(String name, String location) {
        companyDAO.insertIntoCompanies(name, location);
    }

    public void updateInCompanies(Long id, String name, String location) {
        companyDAO.updateInCompanies(id, name, location);
    }

    public void deleteFromCompanies(Long id) {
        companyDAO.deleteFromCompanies(id);
    }
}
