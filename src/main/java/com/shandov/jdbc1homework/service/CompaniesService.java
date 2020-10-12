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

    public void insertIntoCompanies() {
        try {
            compaiesDAO.insertIntoCompanies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateInCompanies() {
        try {
            compaiesDAO.updateInCompanies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromCompanies() {
        try {
            compaiesDAO.deleteFromCompanies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
