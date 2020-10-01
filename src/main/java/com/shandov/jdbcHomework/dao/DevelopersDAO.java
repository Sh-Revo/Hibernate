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

}
