package com.shandov.jdbc1homework.service;


import com.shandov.jdbc1homework.dao.CompaiesDAO;
import com.shandov.jdbc1homework.domain.Companies;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class CompaniesService {

    private final CompaiesDAO compaiesDAO;

    public List<Companies> getAllCompanies() {
        return compaiesDAO.getAllCompanies();
    }

    public void insertIntoCompanies(String name, String location) {
        compaiesDAO.insertIntoCompanies(name, location);
    }

    public void updateInCompanies(Long id, String name) {
        compaiesDAO.updateInCompanies(id, name);
    }

    public void deleteFromCompanies(Long id) {
        compaiesDAO.deleteFromCompanies(id);
    }
}
