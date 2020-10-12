package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.domain.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO extends GenericDAO {


    public List<Customers> getAllCustomers() {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement();
        ) {

            ResultSet resultSet = statement.executeQuery("select * from customers");
            List<Customers> customersList = new ArrayList<>();
            while (resultSet.next()) {
                Customers customers = new Customers();
                customers.setCustomersId(resultSet.getLong("customer_id"));
                customers.setCustomersName(resultSet.getString("customer_name"));
                customers.setCustomersSecondName(resultSet.getString("customer_second_name"));
                customersList.add(customers);
            }
            return customersList;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void insertIntoCustomers() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.execute("INSERT into customers(customer_id, customer_name, customer_second_name) VALUES (4, 'Volodya', 'Spilov')");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void updateInCustomers() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("UPDATE customers SET customer_second_name = 'Moiseenko' WHERE customer_id = 4");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void deleteFromCustomers() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM customers WHERE customer_id = 4");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
            statement.close();
        }
    }
}
