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

//    public List<Skill> getAllSkills() {
//        try (Connection connection = DriverManager.getConnection(URL, username, password);
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("select * from skills");
//            List<Skill> skillsList = new ArrayList<>();
//            while (resultSet.next()) {
//                Skill skill = new Skill();
//                skill.setSkillsId(resultSet.getLong("skills_id"));
//                skill.setSkillsName(resultSet.getString("skills_name"));
//                skill.setSkillLvl(resultSet.getString("skills_lvl"));
//                skillsList.add(skill);
//            }
//            return skillsList;
//        } catch (SQLException e) {
//            log.info("SQLState: " + e.getSQLState());
//            log.info("Message: " + e.getMessage());
//            log.info("Vendor: " + e.getErrorCode());
//            throw new InternalException(e.getMessage());
//        }
//    }
//
//    public void insertIntoSkills(String name, String lvl) {
//        try (Connection connection = DriverManager.getConnection(URL, username, password);
//             PreparedStatement statement = connection.prepareStatement("INSERT into skills(skills_name, skills_lvl) VALUES (?, ?)")) {
//            statement.setString(1, name);
//            statement.setString(2, lvl);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            log.info("SQLState: " + e.getSQLState());
//            log.info("Message: " + e.getMessage());
//            log.info("Vendor: " + e.getErrorCode());
//            throw new InternalException(e.getMessage());
//        }
//    }
//
//    public void updateInSkills(Long id, String name, String lvl) {
//        try (Connection connection = DriverManager.getConnection(URL, username, password);
//             PreparedStatement statement = connection.prepareStatement("UPDATE skills SET skills_name = ?, skills_lvl = ? WHERE skills_id = ?")) {
//            statement.setString(1, name);
//            statement.setString(2, lvl);
//            statement.setLong(3, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            log.info("SQLState: " + e.getSQLState());
//            log.info("Message: " + e.getMessage());
//            log.info("Vendor: " + e.getErrorCode());
//            throw new InternalException(e.getMessage());
//        }
//    }
//
//    public void deleteFromSkills(Long id) {
//        try (Connection connection = DriverManager.getConnection(URL, username, password);
//             PreparedStatement statement = connection.prepareStatement("DELETE FROM skills WHERE skills_id = ?")) {
//            statement.setLong(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            log.info("SQLState: " + e.getSQLState());
//            log.info("Message: " + e.getMessage());
//            log.info("Vendor: " + e.getErrorCode());
//            throw new InternalException(e.getMessage());
//        }
//    }
}
