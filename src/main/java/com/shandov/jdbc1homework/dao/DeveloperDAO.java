package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Developer;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class DeveloperDAO extends GenericDAO {


    public List<Developer> getAllDevelopersByProjectName(String name) {

        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT dev.* FROM developers dev " +
                     "join dev_projects dp on dev.dev_id = dp.dev_id " +
                     "join projects pr on dp.project_id = pr.project_id " +
                     "WHERE pr.project_name = ? ;")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            List<Developer> developersList = new ArrayList<>();
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("dev_id"));
                developer.setName(resultSet.getString("dev_name"));
                developer.setAge(resultSet.getInt("dev_age"));
                developer.setGender(resultSet.getString("dev_gender"));
                developer.setSalary(resultSet.getBigDecimal("salary"));

                developersList.add(developer);
            }
            return developersList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }

    }

    public List<Developer> getAllDevelopersBySkillsName(String name) {

        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("select dev.* from developers dev " +
                     "join dev_skills ds on dev.dev_id = ds.dev_id " +
                     "join skills s on dev.dev_id = s.skills_id " +
                     "where s.skills_name = ?;")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            List<Developer> developersList = new ArrayList<>();
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("dev_id"));
                developer.setName(resultSet.getString("dev_name"));
                developer.setAge(resultSet.getInt("dev_age"));
                developer.setGender(resultSet.getString("dev_gender"));
                developer.setSalary(resultSet.getBigDecimal("salary"));
                developersList.add(developer);
            }
            return developersList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }

    }

    public List<Developer> getAllDevelopersBySkillsLvl(String lvl) {

        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("select dev.* from developers dev " +
                     "join dev_skills ds on dev.dev_id = ds.dev_id " +
                     "join skills s on dev.dev_id = s.skills_id " +
                     "where s.skills_lvl = ?;")) {
            statement.setString(1, lvl);
            ResultSet resultSet = statement.executeQuery();
            List<Developer> developersList = new ArrayList<>();
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("dev_id"));
                developer.setName(resultSet.getString("dev_name"));
                developer.setAge(resultSet.getInt("dev_age"));
                developer.setGender(resultSet.getString("dev_gender"));
                developer.setSalary(resultSet.getBigDecimal("salary"));
                developersList.add(developer);
            }
            return developersList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new RuntimeException(e);
        }

    }

    public List<Developer> getAllDevelopers() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from developers");
            List<Developer> developersList = new ArrayList<>();
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("dev_id"));
                developer.setName(resultSet.getString("dev_name"));
                developer.setAge(resultSet.getInt("dev_age"));
                developer.setGender(resultSet.getString("dev_gender"));
                developer.setSalary(resultSet.getBigDecimal("salary"));
                developersList.add(developer);
            }
            return developersList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void insertIntoDevelopers(String name, Integer age, String gender, BigDecimal salary) {


        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT into developers(dev_name, dev_age, dev_gender, salary) VALUES ( ?, ? , ?, ?)")) {

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setBigDecimal(4, salary);
            statement.executeUpdate();

        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void updateIntoDevelopers(Long id, String name, Integer age, String gender, BigDecimal salary) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE developers SET dev_name = ?, dev_age = ?, dev_gender = ?, salary = ? WHERE dev_id = ?")) {

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setBigDecimal(4, salary);
            statement.setLong(5, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void deleteFromDevelopers(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM developers WHERE dev_id = ?")) {

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
