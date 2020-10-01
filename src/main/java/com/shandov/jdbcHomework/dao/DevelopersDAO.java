package com.shandov.jdbcHomework.dao;

import com.shandov.jdbcHomework.domain.Developers;

import java.sql.*;

public class DevelopersDAO extends GenericDAO{

    public Developers getAllDevelopersByProjectName(String message){

        try  (Connection connection = DriverManager.getConnection(URL, username, password);
              PreparedStatement statement = connection.prepareStatement("SELECT pr.project_name, dev.* FROM developers dev " +
                      "join dev_projects dp on dev.dev_id = dp.dev_id " +
                      "join projects pr on dp.project_id = pr.project_id " +
                      "WHERE pr.project_name = ? " +
                      "GROUP BY pr.project_name, dev.dev_id " +
                      "ORDER BY pr.project_name;")){
            statement.setString(1, message);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Developers developers = new Developers();
                developers.setDevId(resultSet.getLong("dev_id"));
                developers.setDevName(resultSet.getString("dev_name"));
                developers.setDevAge(resultSet.getLong("dev_age"));
                developers.setDevGender(resultSet.getString("dev_gender"));
                developers.setDevSalary(resultSet.getBigDecimal("salary"));
                return developers;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
