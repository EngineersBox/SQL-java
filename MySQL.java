package com.exmaplepackage.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.exmaplepackage.Database;

public class MySQL extends Database {

	private final String hostname;
	private final String database;
	private final String port;
	private final String user;
	private final String password;

	//Creates a new MySQL instance for a specific database
	public MySQL(String hostname, String port, String database, String username, String password) {
		this.hostname = hostname;
		this.port = port;
		this.database = database;
		this.user = username;
		this.password = password;
	}

	@Override
	public Connection openConnection() throws SQLException, ClassNotFoundException {
		System.out.println("Opening Connection With Database...");
		if (checkConnection()) {
			return connection;
		}

		String connectionURL = "jdbc:mysql://" + this.hostname + this.port;
		if (database != null) {
			connectionURL = connectionURL + "/" + this.database;
		}

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(connectionURL, this.user, this.password);
		System.out.println("Connection Established.");
		return connection;
	}

}
