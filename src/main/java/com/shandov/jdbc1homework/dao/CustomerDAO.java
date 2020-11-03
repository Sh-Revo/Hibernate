package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.domain.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Slf4j
public class CustomerDAO extends GenericDAO<Customer, Long> {

    @Override
    public Class getEntityClass() {
        return Customer.class;
    }

    @Getter
    private final EntityManager entityManager;

    public CustomerDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

}
