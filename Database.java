package com.exmaplepackage.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Database {

	protected Connection connection;

	//Creates a new database
	protected Database() {
		this.connection = null;
	}

	//Opens a connection with the database
	public abstract Connection openConnection() throws SQLException, ClassNotFoundException;

	//Checks if a connection is open with the database
	public boolean checkConnection() throws SQLException {
		return connection != null && !connection.isClosed();
	}

	//Gets the connection with the database
	public Connection getConnection() {
		return connection;
	}

	//Closes the connection with the database
	public boolean closeConnection() throws SQLException {
		System.out.println("Closing Connection With Database...");
		if (connection == null) {
			System.out.println("No Open Connection, Skipping.");
			return false;
		}
		connection.close();
		System.out.println("Connection Closed");
		return true;
	}

	//Executes a SQL Query
	public ResultSet querySQL(String query) throws SQLException, ClassNotFoundException {
		if (!checkConnection()) {
			openConnection();
		}

		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		return result;
	}

	//Executes an Update SQL Query
	public int updateSQL(String query) throws SQLException, ClassNotFoundException {
		if (!checkConnection()) {
			openConnection();
		}

		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		return result;
	}

	//Executes an Update SQL Query Without Returns
	public void noRetUpdate(String query) throws SQLException, ClassNotFoundException {
		if (!checkConnection()) {
			openConnection();
		}

		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
	}

}
