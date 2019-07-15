package com.examplepackage;

import java.sql.Connection;
import java.sql.SQLException;

import com.examplepackage.mysql.MySQL;

public class Main {

	//Globals
	public static boolean UseSQL;
	public static MySQL MySQL;
	static Connection c = null;

  	if (UseSQL.equals(true)) {
		MySQL = new MySQL("HOSTNAME", "", "DATABASE", "USERNAME", "PASSWORD");
		try {
			c = MySQL.openConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
  	}

}
