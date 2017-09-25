package pl.sdacademy.jdbc.animal;

import pl.sdacademy.jdbc.db.DBUtil;
import pl.sdacademy.jdbc.person.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by RENT on 2017-09-25.
 */
public class AnimalDAO {

    private final Connection connection;

    public AnimalDAO() {
        this.connection = DBUtil.getConnection();
    }

    public Optional<Animal> findById(Long animal_id) {

        try {
            // 1) Statement lub PreparedStatement
            String sql = "select * from person p left join animal a where p.id = a.person_id";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 2) executeQuery()
            statement.setLong(1, animal_id);
            ResultSet resultSet = statement.executeQuery();

            // 3) next()
            while (resultSet.next()) {
                Long animalID = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String breed = resultSet.getString("breed");
                Long person_id = resultSet.getLong("person_id");


                // 4) new Person() || empty()
                Animal animal = new Animal();
                animal.setId(animalID);
                animal.setName(name);
                animal.setBreed(breed);
                animal.setPerson_id(person_id);

                return Optional.of(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
