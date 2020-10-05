package com.shandov.jdbcHomework.dao;

import com.shandov.jdbcHomework.domain.Developers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DevelopersDAO extends GenericDAO{

    public List<Developers> getAllDevelopersByProjectName(String message){

        try  (Connection connection = DriverManager.getConnection(URL, username, password);
              PreparedStatement statement = connection.prepareStatement("SELECT pr.project_name, dev.* FROM developers dev " +
                      "join dev_projects dp on dev.dev_id = dp.dev_id " +
                      "join projects pr on dp.project_id = pr.project_id " +
                      "WHERE pr.project_name = ? " +
                      "GROUP BY pr.project_name, dev.dev_id " +
                      "ORDER BY pr.project_name;")){
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            List<Developers> developersList = new ArrayList<>();
            while (resultSet.next()){
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
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Developers> getAllJavaDevelopers(String message){

        try  (Connection connection = DriverManager.getConnection(URL, username, password);
              PreparedStatement statement = connection.prepareStatement("select dev.* from developers dev " +
                      "join dev_skills ds on dev.dev_id = ds.dev_id " +
                      "join skills s on dev.dev_id = s.skills_id " +
                      "where s.skills_name = ?;")){
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            List<Developers> developersList = new ArrayList<>();
            while (resultSet.next()){
                Developers developers = new Developers();
                developers.setDevId(resultSet.getLong("dev_id"));
                developers.setDevName(resultSet.getString("dev_name"));
                developers.setDevAge(resultSet.getLong("dev_age"));
                developers.setDevGender(resultSet.getString("dev_gender"));
                developers.setDevSalary(resultSet.getBigDecimal("salary"));
                developersList.add(developers);
            }
            return developersList;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Developers> getAllMiddleDevelopers(String message){

        try  (Connection connection = DriverManager.getConnection(URL, username, password);
              PreparedStatement statement = connection.prepareStatement("select dev.* from developers dev " +
                      "join dev_skills ds on dev.dev_id = ds.dev_id " +
                      "join skills s on dev.dev_id = s.skills_id " +
                      "where s.skills_lvl = ?;")){
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            List<Developers> developersList = new ArrayList<>();
            while (resultSet.next()){
                Developers developers = new Developers();
                developers.setDevId(resultSet.getLong("dev_id"));
                developers.setDevName(resultSet.getString("dev_name"));
                developers.setDevAge(resultSet.getLong("dev_age"));
                developers.setDevGender(resultSet.getString("dev_gender"));
                developers.setDevSalary(resultSet.getBigDecimal("salary"));
                developersList.add(developers);
            }
            return developersList;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Developers> getAllDevelopers(){
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);

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
        } catch (SQLException e){
            throw  new RuntimeException();
        }
    }

    public void insertIntoDevelopers() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.execute("INSERT into developers(dev_id, dev_name, dev_age, dev_gender, salary) VALUES (6, 'Vasya', 23, 'Male', 8000)");
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    public void updateIntoDevelopers() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("UPDATE developers SET salary = 10000 WHERE dev_id = 6");
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    public void deleteFromDevelopers() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM developers WHERE dev_id = 6");
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
        }
        finally {
            connection.close();
            statement.close();
        }
    }
}
