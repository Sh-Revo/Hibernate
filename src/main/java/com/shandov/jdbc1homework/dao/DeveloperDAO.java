package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.domain.Developer;
import com.shandov.jdbc1homework.domain.Skill;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;


@Slf4j
public class DeveloperDAO extends GenericDAO<Developer, Long> {

    @Override
    public Class getEntityClass() {
        return Developer.class;
    }

    @Getter
    private final EntityManager entityManager;

    public DeveloperDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Developer> getDeveloperBySkillsName(String name) {
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = (List<Developer>) entityManager.createQuery("select dev from Developer dev join dev.skills s where s.name = ?1").setParameter(1, name).getResultList();
        entityManager.close();
        return developers;
    }

    public List<Developer> getDeveloperBySkillsLvl(Skill skill) {
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = (List<Developer>) entityManager.createQuery("select dev from Developer dev join dev.skills s where s.lvl = ?1").setParameter(1, skill.getLvl()).getResultList();
        entityManager.close();
        return developers;
    }

    public List<Developer> getDeveloperByProjectName(String name) {
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = (List<Developer>) entityManager.createQuery("select dev from Developer dev join dev.projects pr where pr.name = ?1").setParameter(1, name).getResultList();
        entityManager.close();
        return developers;
    }

    public BigDecimal salaryAllDevelopersByProjectName(String name) {
        EntityManager entityManager = getEntityManager();
        BigDecimal developers = (BigDecimal) entityManager.createQuery("select sum(dev.salary) from Developer dev join dev.projects pr where pr.name = ?1").setParameter(1, name).getSingleResult();
        entityManager.close();
        return developers;
    }

}


