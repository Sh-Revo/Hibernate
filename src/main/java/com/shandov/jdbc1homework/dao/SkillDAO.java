package com.shandov.jdbc1homework.dao;


import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Skill;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SkillDAO extends GenericDAO<Skill, Long> {
    @Override
    public Class getEntityClass() {
        return Skill.class;
    }

    @Getter
    private final EntityManager entityManager;

    public SkillDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

}
