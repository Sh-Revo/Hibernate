package com.shandov.jdbc1homework.dao;


import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Project;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProjectDAO extends GenericDAO {


    public BigDecimal salaryAllDevelopersByProjectName(String message) {

        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("select sum(salary) from developers dev " +
                     "join dev_projects dp on dev.dev_id = dp.dev_id " +
                     "join projects pr on dp.project_id = pr.project_id " +
                     "where pr.project_name = ?; ")) {
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            BigDecimal sum = null;
            if (resultSet.next()) {
                sum = resultSet.getBigDecimal(2);
            }
            return sum;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }


    public List<Project> getAllProjectsByCountDevelopers() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT pr.project_start, pr.project_name, count(d.dev_id) FROM projects pr \n" +
                    "JOIN dev_projects dp on pr.project_id = dp.project_id \n" +
                    "JOIN developers d on dp.dev_id = d.dev_id  \n" +
                    "GROUP BY pr.project_name, pr.project_start;");
            List<Project> projectsList = new ArrayList<>();
            while (resultSet.next()) {
                Project project = new Project();
                project.setProjectName(resultSet.getString("project_name"));
                project.setProjectStart(resultSet.getDate("project_start"));
                projectsList.add(project);
            }
            return projectsList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }


    }

    public List<Project> getAllProjects() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");
            List<Project> projectsList = new ArrayList<>();
            while (resultSet.next()) {
                Project project = new Project();
                project.setProjectId(resultSet.getLong("project_id"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setProjectDescription(resultSet.getString("project_description"));
                project.setProjectCost(resultSet.getBigDecimal("cost"));
                project.setProjectStart(resultSet.getDate("project_start"));
                projectsList.add(project);
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
