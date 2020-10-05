package com.shandov.jdbcHomework.dao;

import com.shandov.jdbcHomework.domain.Companies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompaiesDAO extends GenericDAO{

    public List<Companies> getAllCompanies(){
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement();
            ){
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery("select * from companies");
            List<Companies> companiesList = new ArrayList<>();
            while (resultSet.next()){
                Companies companies = new Companies();
                companies.setCompanyId(resultSet.getLong("company_id"));
                companies.setCompanyName(resultSet.getString("company_name"));
                companies.setCompanyLocation(resultSet.getString("company_location"));
                companiesList.add(companies);
            }
            return companiesList;

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public void insertIntoCompanies() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.execute("INSERT into companies(company_id, company_name, company_location) VALUES (5, 'Volodya', 'Paris')");
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void updateInCompanies() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("UPDATE companies SET company_name = 'Ubisoft' WHERE company_id = 5");
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void deleteFromCompanies() throws SQLException{
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM companies WHERE company_id = 5");
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
