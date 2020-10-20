package com.shandov.jdbc1homework.service;

import com.shandov.jdbc1homework.dao.CustomerDAO;
import com.shandov.jdbc1homework.domain.Customer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public void insertIntoCustomers(String name, String secondName) {
        customerDAO.insertIntoCustomers(name, secondName);
    }

    public void updateInCustomers(Long id, String name, String secondName) {
        customerDAO.updateInCustomers(id, name, secondName);
    }

    public void deleteFromCustomers(Long id) {
        customerDAO.deleteFromCustomers(id);
    }
}
