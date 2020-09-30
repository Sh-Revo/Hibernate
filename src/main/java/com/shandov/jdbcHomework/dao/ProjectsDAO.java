package com.shandov.jdbcHomework.dao;


import com.shandov.jdbcHomework.domain.Projects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProjectsDAO extends GenericDAO{


    public Integer salaryAllDevelopersByProjectName(String message){

        try (Connection connection = DriverManager.getConnection(URL, username, password);
            PreparedStatement statement = connection.prepareStatement("select pr.project_name, sum(salary) from developers dev join dev_projects dp on dev.dev_id = dp.dev_id join projects pr on dp.project_id = pr.project_id where pr.project_name = ? group by pr.project_name;")){
            statement.setString(1,message);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){

                int sum = resultSet.getInt(2);
                return sum;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
