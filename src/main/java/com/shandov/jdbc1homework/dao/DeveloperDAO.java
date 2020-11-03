package com.shandov.jdbc1homework.dao;

import com.shandov.jdbc1homework.domain.Developer;
import com.shandov.jdbc1homework.domain.Skill;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


@Slf4j
public class DeveloperDAO extends GenericDAO<Developer, Long> {

    @Override
    public Class getEntityClass() {
        return Developer.class;
    }

    @Getter
    private final EntityManager entityManager;

    public DeveloperDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Developer> getDeveloperBySkillsName(String name){
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = (List<Developer>) entityManager.createQuery("select dev from Developer dev join dev.skills s where s.name = ?1").setParameter(1, name).getResultList();
        entityManager.close();
        return developers;
    }

//    public List<Developer> getDeveloperBySkillsLvl(Skill skill){
//        EntityManager entityManager = getEntityManager();
//        List<Developer> developers = (List<Developer>) entityManager.createQuery("from Skill s join s.developers where s.lvl = ?1").setParameter(1,skill.getLvl()).getResultList();
//        entityManager.close();
//        return developers;
//    }
}


//    public List<Developer> getAllDevelopersByProjectName(String name) {
//
//        try (Connection connection = DriverManager.getConnection(URL, username, password);
//             PreparedStatement statement = connection.prepareStatement("SELECT dev.* FROM developers dev " +
//                     "join dev_projects dp on dev.dev_id = dp.dev_id " +
//                     "join projects pr on dp.project_id = pr.project_id " +
//                     "WHERE pr.project_name = ? ;")) {
//            statement.setString(1, name);
//            ResultSet resultSet = statement.executeQuery();
//            List<Developer> developersList = new ArrayList<>();
//            while (resultSet.next()) {
//                Developer developer = new Developer();
//                developer.setId(resultSet.getLong("dev_id"));
//                developer.setName(resultSet.getString("dev_name"));
//                developer.setAge(resultSet.getInt("dev_age"));
//                developer.setGender(resultSet.getString("dev_gender"));
//                developer.setSalary(resultSet.getBigDecimal("salary"));
//
//                developersList.add(developer);
//            }
//            return developersList;
//        } catch (SQLException e) {
//            log.info("SQLState: " + e.getSQLState());
//            log.info("Message: " + e.getMessage());
//            log.info("Vendor: " + e.getErrorCode());
//            throw new InternalException(e.getMessage());
//        }
//
//    }
//

