package com.shandov.jdbcHomework.dao;


import com.shandov.jdbcHomework.domain.Developers;
import com.shandov.jdbcHomework.domain.Projects;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProjectsDAO extends GenericDAO{


    public BigDecimal salaryAllDevelopersByProjectName(String message){

        try (Connection connection = DriverManager.getConnection(URL, username, password);
            PreparedStatement statement = connection.prepareStatement("select pr.project_name, sum(salary) from developers dev " +
                    "join dev_projects dp on dev.dev_id = dp.dev_id " +
                    "join projects pr on dp.project_id = pr.project_id " +
                    "where pr.project_name = ? " +
                    "group by pr.project_name;")){
            statement.setString(1,message);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){

                BigDecimal sum = resultSet.getBigDecimal(2);
                return sum;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }



    public List<Projects> getAllProjects(){
        try (Connection connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery("SELECT pr.project_start, pr.project_name, count(d.dev_id) FROM projects pr \n" +
                    "JOIN dev_projects dp on pr.project_id = dp.project_id \n" +
                    "JOIN developers d on dp.dev_id = d.dev_id  \n" +
                    "GROUP BY pr.project_name, pr.project_start;");
            List<Projects> projectsList = new ArrayList<>();
            while (resultSet.next()){
                Projects projects = new Projects();
                projects.setProjectName(resultSet.getString("project_name"));
                projects.setProjectStart(resultSet.getDate("project_start"));
                projectsList.add(projects);
            }
            return projectsList;
        } catch (SQLException e){

            throw new RuntimeException(e);
        }


    }



}
