package pl.sdacademy.jdbc.person;
import pl.sdacademy.jdbc.animal.Animal;
import pl.sdacademy.jdbc.db.DBUtil;
import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PersonDAO {

    private final Connection connection;

    public PersonDAO() {
        this.connection = DBUtil.getConnection();
    }

    public Optional<Person> findById(Long personId) {

        try {
            // 1) Statement lub PreparedStatement
            String sql = "select * from person where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 2) executeQuery()
            statement.setLong(1, personId);
            ResultSet resultSet = statement.executeQuery();

            // 3) next()
            while (resultSet.next()) {
                Long personID = resultSet.getLong("id");
                String personName = resultSet.getString("first_name");
                String personSurname = resultSet.getString("last_name");

                // 4) new Person() || empty()
                Person person1 = new Person();
                person1.setId(personID);
                person1.setFirstName(personName);
                person1.setLastName(personSurname);

                return Optional.of(person1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * A gdyby jednak zwracac nowoutworzony Person?
     * https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-last-insert-id.html
     */
    public Optional<Person> addPerson(Person person) {
        try {
            String sql = "insert into person (first_name, last_name) values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
             return findById(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public void deletePerson(Long personId) {
        try {
            // 1) Statement lub PreparedStatement
            String sql = "delete from person where id=?";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // 2) executeQuery()
            statement.setLong(1, personId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(Person person) {
        try {
            String sql = "update person set first_name = ?, last_name = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setLong(3, 4L);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Person> showAnimals(Person person) {
        try {
            String sql = "select * from person p left join animal a where p.id = a.person_id";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, person.getId());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                return findById(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        Person person = new Person();
        person.setLastName("dedede4");
        person.setFirstName("rrere2");
        personDAO.deletePerson(2L);
        personDAO.updatePerson(person);
        personDAO.showAnimals(person);

    }


}
