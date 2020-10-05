package com.shandov.jdbcHomework.dao;


import com.shandov.jdbcHomework.domain.Skills;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillsDAO extends GenericDAO {

    public List<Skills> getAllSkills(){
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement();
        ){
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery("select * from skills");
            List<Skills> skillsList = new ArrayList<>();
            while (resultSet.next()){
                Skills skills = new Skills();
                skills.setSkillsId(resultSet.getLong("skills_id"));
                skills.setSkillsName(resultSet.getString("skills_name"));
                skills.setSkillsLvl(resultSet.getString("skills_lvl"));
                skillsList.add(skills);

            }
            return skillsList;

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public void insertIntoSkills() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.execute("INSERT into skills(skills_id, skills_name, skills_lvl) VALUES (13, 'VisualBasic', 'Senior')");
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void updateInSkills() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("UPDATE skills SET skills_name = 'HTML' WHERE skills_id = 13");
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void deleteFromSkills() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM skills WHERE skills_id = 13");
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }
}
