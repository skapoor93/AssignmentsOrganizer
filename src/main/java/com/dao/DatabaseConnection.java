package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static final String database = "cs3220final";
	public static final String url = "jdbc:mysql://localhost/" + database +"?useSSL=false";
	public static final String username = "root";
	public static final String password = "database";

	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch( ClassNotFoundException e ) {
			throw new IllegalStateException(e);
		}
	}

	public Connection connection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

}
