import java.sql.*;

/**
 * Created by RENT on 2017-09-23.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bookstore"; //3306 standardowy port mysql
        String login = "user_nordea";
        String password = "nordea2";

        Connection connection = DriverManager.getConnection(url, login, password);
        Statement statement = connection.createStatement();

        String sql = "select * from books";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String title = resultSet.getString(1); // getString("title");
            System.out.println(title);
        }
    }
}
