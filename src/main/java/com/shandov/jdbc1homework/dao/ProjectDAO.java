package com.shandov.jdbc1homework.dao;


import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Project;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProjectDAO extends GenericDAO<Project, Long> {
    @Override
    public Class<Project> getEntityClass() {
        return Project.class;
    }

    @Getter
    private final EntityManager entityManager;

    public ProjectDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

}
