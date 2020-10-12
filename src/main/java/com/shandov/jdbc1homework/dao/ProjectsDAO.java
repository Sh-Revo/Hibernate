package com.shandov.jdbc1homework.dao;


import com.shandov.jdbc1homework.domain.Projects;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
            if (resultSet.next()) {
                return resultSet.getBigDecimal(2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

            throw new RuntimeException(e);
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
            throw new RuntimeException();
        }
    }

    public void insertIntoProjects() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.execute("INSERT INTO projects(project_id, project_name, project_description, cost, project_start) VALUES(7, 'Doggy', 'FleetWord', 15000, '2010-11-13')");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void updateIntoProjects() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("UPDATE projects SET project_description = 'DogFood' WHERE project_id = 7");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void deleteFromProjects() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM projects WHERE project_id = 7");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }
}
