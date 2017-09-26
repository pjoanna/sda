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
            String sql = "select p.id idfromperson, p.first_name, p.last_name, a.id animalid, a.name, a.breed breed, a.person_id personid from person p left join animal a on p.id= a.person_id where a.person_id =?";


            PreparedStatement statement = connection.prepareStatement(sql);

            // 2) executeQuery()
            statement.setLong(1, animal_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long personID = resultSet.getLong(1);
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                Long animalID = resultSet.getLong(4);
                String name = resultSet.getString(5);
                String breed = resultSet.getString(6);
                Long person_id = resultSet.getLong(7);

                Person person = new Person();
                person.setId(personID);
                person.setFirstName(first_name);
                person.setLastName(last_name);
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

    public static void main(String[] args) {
        AnimalDAO animalDAO = new AnimalDAO();
        Optional<Animal> animal = animalDAO.findById(1L);

        System.out.println(animal.toString());
    }

}
