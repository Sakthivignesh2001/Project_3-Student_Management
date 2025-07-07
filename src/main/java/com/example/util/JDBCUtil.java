package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	private JDBCUtil() {
	}

	public static Connection getJdbcConnection() throws SQLException {

		String jdbcUrl = "jdbc:mysql:///javafsdcourse";
		String userName = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
		return connection;
	}

	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {

		if (connection != null)
			connection.close();
		if (statement != null)
			statement.close();
		if (resultSet != null)
			resultSet.close();
	}
}
