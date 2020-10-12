package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Developers;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class DevelopersDAO extends GenericDAO {


    public List<Developers> getAllDevelopersByProjectName(String message) {

        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT pr.project_name, dev.* FROM developers dev " +
                     "join dev_projects dp on dev.dev_id = dp.dev_id " +
                     "join projects pr on dp.project_id = pr.project_id " +
                     "WHERE pr.project_name = ? " +
                     "GROUP BY pr.project_name, dev.dev_id " +
                     "ORDER BY pr.project_name;")) {
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            List<Developers> developersList = new ArrayList<>();
            while (resultSet.next()) {
                Developers developers = new Developers();
                developers.setDevId(resultSet.getLong("dev_id"));
                developers.setDevName(resultSet.getString("dev_name"));
                developers.setDevAge(resultSet.getLong("dev_age"));
                developers.setDevGender(resultSet.getString("dev_gender"));
                developers.setDevSalary(resultSet.getBigDecimal("salary"));

//                developersList.stream().map(developers1 -> developers).filter(developers1 -> {
//                    System.out.println("\nNew " + developers1);
//                    return Boolean.parseBoolean(null);
//                }).collect(Collectors.toList());
                developersList.add(developers);
            }
            return developersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Developers> getAllJavaDevelopers(String message) {

        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("select dev.* from developers dev " +
                     "join dev_skills ds on dev.dev_id = ds.dev_id " +
                     "join skills s on dev.dev_id = s.skills_id " +
                     "where s.skills_name = ?;")) {
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            List<Developers> developersList = new ArrayList<>();
            while (resultSet.next()) {
                Developers developers = new Developers();
                developers.setDevId(resultSet.getLong("dev_id"));
                developers.setDevName(resultSet.getString("dev_name"));
                developers.setDevAge(resultSet.getLong("dev_age"));
                developers.setDevGender(resultSet.getString("dev_gender"));
                developers.setDevSalary(resultSet.getBigDecimal("salary"));
                developersList.add(developers);
            }
            return developersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Developers> getAllMiddleDevelopers(String message) {

        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("select dev.* from developers dev " +
                     "join dev_skills ds on dev.dev_id = ds.dev_id " +
                     "join skills s on dev.dev_id = s.skills_id " +
                     "where s.skills_lvl = ?;")) {
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            List<Developers> developersList = new ArrayList<>();
            while (resultSet.next()) {
                Developers developers = new Developers();
                developers.setDevId(resultSet.getLong("dev_id"));
                developers.setDevName(resultSet.getString("dev_name"));
                developers.setDevAge(resultSet.getLong("dev_age"));
                developers.setDevGender(resultSet.getString("dev_gender"));
                developers.setDevSalary(resultSet.getBigDecimal("salary"));
                developersList.add(developers);
            }
            return developersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Developers> getAllDevelopers() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {


            ResultSet resultSet = statement.executeQuery("select * from developers");
            List<Developers> developersList = new ArrayList<>();
            while (resultSet.next()) {
                Developers developers = new Developers();
                developers.setDevId(resultSet.getLong("dev_id"));
                developers.setDevName(resultSet.getString("dev_name"));
                developers.setDevAge(resultSet.getLong("dev_age"));
                developers.setDevGender(resultSet.getString("dev_gender"));
                developers.setDevSalary(resultSet.getBigDecimal("salary"));

                developersList.add(developers);
            }
            return developersList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void insertIntoDevelopers(String devName, Long devAge, String devGender, BigDecimal devSalary) {


        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT into developers(dev_name, dev_age, dev_gender, salary) VALUES ( ?, ? , ?, ?)");) {

            statement.setString(1, devName);
            statement.setLong(2, devAge);
            statement.setString(3, devGender);
            statement.setBigDecimal(4, devSalary);
            statement.executeUpdate();

        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
        }
    }

    public void updateIntoDevelopers() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("UPDATE developers SET salary = 10000 WHERE dev_id = 6");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void deleteFromDevelopers() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM developers WHERE dev_id = 6");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }
}
