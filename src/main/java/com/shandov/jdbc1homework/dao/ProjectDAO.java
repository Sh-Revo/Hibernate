package com.shandov.jdbc1homework.dao;


import com.shandov.jdbc1homework.InternalException;
import com.shandov.jdbc1homework.domain.Project;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProjectDAO extends GenericDAO<Project, Long> {
    @Override
    public Class<Project> getEntityClass() {
        return Project.class;
    }

    @Getter
    private final EntityManager entityManager;

    public ProjectDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

//    public BigDecimal salaryAllDevelopersByProjectName(String message) {
//
//        try (Connection connection = DriverManager.getConnection(URL, username, password);
//             PreparedStatement statement = connection.prepareStatement("select sum(salary) from developers dev " +
//                     "join dev_projects dp on dev.dev_id = dp.dev_id " +
//                     "join projects pr on dp.project_id = pr.project_id " +
//                     "where pr.project_name = ?; ")) {
//            statement.setString(1, message);
//            ResultSet resultSet = statement.executeQuery();
//            BigDecimal sum = null;
//            if (resultSet.next()) {
//                sum = resultSet.getBigDecimal(2);
//            }
//            return sum;
//        } catch (SQLException e) {
//            log.info("SQLState: " + e.getSQLState());
//            log.info("Message: " + e.getMessage());
//            log.info("Vendor: " + e.getErrorCode());
//            throw new InternalException(e.getMessage());
//        }
//    }
//
//
//    public List<Project> getAllProjectsByCountDevelopers() {
//        try (Connection connection = DriverManager.getConnection(URL, username, password);
//             Statement statement = connection.createStatement()) {
//
//            ResultSet resultSet = statement.executeQuery("SELECT pr.project_start, pr.project_name, count(d.dev_id) FROM projects pr \n" +
//                    "JOIN dev_projects dp on pr.project_id = dp.project_id \n" +
//                    "JOIN developers d on dp.dev_id = d.dev_id  \n" +
//                    "GROUP BY pr.project_name, pr.project_start;");
//            List<Project> projectsList = new ArrayList<>();
//            while (resultSet.next()) {
//                Project project = new Project();
//                project.setProjectName(resultSet.getString("project_name"));
//                project.setProjectStart(resultSet.getDate("project_start"));
//                projectsList.add(project);
//            }
//            return projectsList;
//        } catch (SQLException e) {
//            log.info("SQLState: " + e.getSQLState());
//            log.info("Message: " + e.getMessage());
//            log.info("Vendor: " + e.getErrorCode());
//            throw new InternalException(e.getMessage());
//        }
//
//
//    }
//

}
