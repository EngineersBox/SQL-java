package com.examplepackage.mysql;

import java.sql.*;

public class SQLLink {

	public static void setValueInColumn(String column, String row, String tableName) throws SQLException {

		try {

			String sql;
			sql = "SELECT " + column + " FROM " + tableName + " WHERE row = '" + row + "';";
			ResultSet rs = Main.MySQL.querySQL(sql);

			if (rs.next()) {
				throw new SQLException();
			} else {

				sql = "INSERT INTO " + tableName +" (row, column) VALUES ('" + row + "', '" + column + ");";
				Main.MySQL.noRetUpdate(sql);

			}

		} catch (SQLException | ClassNotFoundException se) {
			throw new SQLException(se);
		}

	}

	public static String getValueFromColumn(String column, String row, String tableName) throws SQLException {

		try {

			String rank;
			String sql;
			sql = "SELECT " + column + " FROM " + tableName + " WHERE row = '" + row + "';";
			ResultSet rs = Main.MySQL.querySQL(sql);
			rs.next();

			value = rs.getString(row);
			return value;

		} catch (SQLException | ClassNotFoundException se) {
			throw new SQLException(se);
		}

	}

}
