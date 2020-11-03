package com.shandov.jdbc1homework.service;


import com.shandov.jdbc1homework.dao.CustomerDAO;
import com.shandov.jdbc1homework.domain.Customer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;

    public void insertInCustomer(Customer customer) {
        customerDAO.insert(customer);
    }

    public void updateInCustomer(Customer customer) {
        customerDAO.update(customer, customer.getId());
    }

    public void deleteInCustomer(Long id) {
        customerDAO.delete(id);
    }

    public List<Customer> getAllCustomer() {
        return customerDAO.getAll();
    }
}
