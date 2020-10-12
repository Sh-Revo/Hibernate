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

    public void insertIntoCustomers(String name, String secondName) {
        customersDAO.insertIntoCustomers(name, secondName);
    }

    public void updateInCustomers(Long id, String secondName) {
        customersDAO.updateInCustomers(id, secondName);
    }

    public void deleteFromCustomers(Long id) {
        customersDAO.deleteFromCustomers(id);
    }
}
