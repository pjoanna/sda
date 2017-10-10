package database;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//@Slf4j
public class JDBCUtil {

	private static Connection conn;

	public static Connection getConnection() {
		if (conn != null) {
		//	log.info("Zwracanie Connection");
			return conn;
		}

		//log.info("Ladowanie Connection");

		InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("/db.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			Class.forName(driver); // powinno sie samo zaladowac?
			conn = DriverManager.getConnection(url, user, password);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection(Connection toBeClosed) {
		if (toBeClosed == null)
			return;
		try {
			toBeClosed.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
