package common;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	private static String url = "jdbc:mysql://127.0.0.1:3306/javafx";
	private static String username = "root";
	private static String password = "Shree@123";

	static Connection connection;
	static Statement statement;

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		DatabaseUtil.connection = connection;
	}

	static {
		try {
			setConnection(DriverManager.getConnection(url, username, password));
			statement = connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static ResultSet resultQuery(String query) {
		try {
			ResultSet result = statement.executeQuery(query);
			return result;
		} catch (SQLException e) {
			System.out.println("Some error occured in DBUtil ResultSet method");
			e.printStackTrace();
			return null;
		}
	}

	public static boolean executeQuery(String query) throws SQLException {
		getConnection();
		return statement.execute(query);
	}

}
