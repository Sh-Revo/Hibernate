package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.CustomersDAO;
import com.shandov.jdbc1homework.domain.Customers;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class CustomersService {

    private final CustomersDAO customersDAO;

    public List<Customers> getAllCustomers() {
        return customersDAO.getAllCustomers();
    }

    public void insertIntoCustomers() {
        try {
            customersDAO.insertIntoCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateInCustomers() {
        try {
            customersDAO.updateInCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromCustomers() {
        try {
            customersDAO.deleteFromCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
