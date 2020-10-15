package com.shandov.jdbc1homework.dao;


import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Companies;
import com.shandov.jdbc1homework.domain.Skills;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SkillsDAO extends GenericDAO {

    public List<Skills> getAllSkills() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from skills");
            List<Skills> skillsList = new ArrayList<>();
            while (resultSet.next()) {
                Skills skills = new Skills();
                skills.setSkillsId(resultSet.getLong("skills_id"));
                skills.setSkillsName(resultSet.getString("skills_name"));
                skills.setSkillsLvl(resultSet.getString("skills_lvl"));
                skillsList.add(skills);
            }
            return skillsList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void insertIntoSkills(String name, String lvl) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT into skills(skills_name, skills_lvl) VALUES (?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, lvl);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void updateInSkills(Long id, String name, String lvl) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE skills SET skills_name = ?, skills_lvl = ? WHERE skills_id = ?")) {
            statement.setString(1, name);
            statement.setString(2, lvl);
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void deleteFromSkills(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM skills WHERE skills_id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }
}
