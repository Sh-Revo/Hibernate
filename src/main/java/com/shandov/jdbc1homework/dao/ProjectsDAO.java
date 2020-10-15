package com.shandov.jdbc1homework.dao;


import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Projects;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Slf4j
public class ProjectsDAO extends GenericDAO {


    public BigDecimal salaryAllDevelopersByProjectName(String message) {

        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("select pr.project_name, sum(salary) from developers dev " +
                     "join dev_projects dp on dev.dev_id = dp.dev_id " +
                     "join projects pr on dp.project_id = pr.project_id " +
                     "where pr.project_name = ? " +
                     "group by pr.project_name;")) {
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getBigDecimal(2);
            }

        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
        return null;
    }


    public List<Projects> getAllProjectsByCountDevelopers() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT pr.project_start, pr.project_name, count(d.dev_id) FROM projects pr \n" +
                    "JOIN dev_projects dp on pr.project_id = dp.project_id \n" +
                    "JOIN developers d on dp.dev_id = d.dev_id  \n" +
                    "GROUP BY pr.project_name, pr.project_start;");
            List<Projects> projectsList = new ArrayList<>();
            while (resultSet.next()) {
                Projects projects = new Projects();
                projects.setProjectName(resultSet.getString("project_name"));
                projects.setProjectStart(resultSet.getDate("project_start"));
                projectsList.add(projects);
            }
            return projectsList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }


    }

    public List<Projects> getAllProjects() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");
            List<Projects> projectsList = new ArrayList<>();
            while (resultSet.next()) {
                Projects projects = new Projects();
                projects.setProjectId(resultSet.getLong("project_id"));
                projects.setProjectName(resultSet.getString("project_name"));
                projects.setProjectDescription(resultSet.getString("project_description"));
                projects.setProjectCost(resultSet.getBigDecimal("cost"));
                projects.setProjectStart(resultSet.getDate("project_start"));
                projectsList.add(projects);
            }
            return projectsList;

        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void insertIntoProjects(String name, String description, BigDecimal cost, LocalDate start) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO projects(project_name, project_description, cost, project_start) VALUES(?, ?, ?, ?)")) {

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setBigDecimal(3, cost);
            statement.setDate(4, Date.valueOf(start));
            statement.executeUpdate();

        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void updateIntoProjects(Long id, String name, String description, BigDecimal cost, LocalDate start) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE projects SET project_name = ?, project_description = ? , cost = ?, project_start = ?  WHERE project_id = ?");) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setBigDecimal(3, cost);
            statement.setDate(4, Date.valueOf(start));
            statement.setLong(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void deleteFromProjects(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM projects WHERE project_id = ?")) {
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
