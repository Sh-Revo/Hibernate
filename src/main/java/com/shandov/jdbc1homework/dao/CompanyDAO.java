package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Company;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CompanyDAO extends GenericDAO {

    public List<Company> getAllCompanies() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from companies");
            List<Company> companiesList = new ArrayList<>();
            while (resultSet.next()) {
                Company companies = new Company();
                companies.setCompanyId(resultSet.getLong("company_id"));
                companies.setCompanyName(resultSet.getString("company_name"));
                companies.setCompanyLocation(resultSet.getString("company_location"));
                companiesList.add(companies);
            }
            return companiesList;
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }


    public void insertIntoCompanies(String name, String location) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT into companies(company_name, company_location) VALUES (?,?)")) {

            statement.setString(1, name);
            statement.setString(2, location);
            statement.executeUpdate();

        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void updateInCompanies(Long id, String name, String location) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE companies SET company_name = ?, company_location = ? WHERE company_id = ?");) {

            statement.setString(1, name);
            statement.setString(2, location);
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }

    public void deleteFromCompanies(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM companies WHERE company_id = ?");) {

            statement.setLong(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            log.info("SQLState: " + e.getSQLState());
            log.info("Message: " + e.getMessage());
            log.info("Vendor: " + e.getErrorCode());
            throw new InternalException(e.getMessage());
        }
    }


}
