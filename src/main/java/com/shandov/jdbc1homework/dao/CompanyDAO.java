package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Company;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j

public class CompanyDAO extends GenericDAO<Company, Long> {

    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }

    @Getter
    private final EntityManager entityManager;

    public CompanyDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public Optional<Company> getCompanyByName(String name) {

        EntityManager entityManager = getEntityManager();
        //Object optional =  entityManager.createQuery("from Company c where c.name = ?1").setParameter(1, name).getSingleResult();
        Company company = (Company) entityManager.createQuery("from Company c where c.name = ?1").setParameter(1, name).getSingleResult();
        entityManager.close();
        return Optional.ofNullable(company);
    }


}
