package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.domain.Company;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public abstract class GenericDAO<T, ID> {

    public abstract Class<T> getEntityClass();

    @Getter
    private final EntityManager entityManager;

    GenericDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void insert(T entity){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(T entity, ID id){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        T entityFromDB = entityManager.find(getEntityClass(), id);
        entityManager.merge(entity);
        entityManager.persist(entityFromDB);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(ID id){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        T entityFromDB = entityManager.find(getEntityClass(), id);
        entityManager.remove(entityFromDB);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Optional<T> findById(ID id) {
        EntityManager entityManager = getEntityManager();
        T entityFromDB = entityManager.find(getEntityClass(), id);
        entityManager.close();
        return Optional.ofNullable(entityFromDB);
    }

    public List<T> getAll() {

        EntityManager entityManager = getEntityManager();
        List<T> entityList = entityManager.createQuery("from " + getEntityClass().getSimpleName()).getResultList();
        entityManager.close();
        return entityList;
    }



}
