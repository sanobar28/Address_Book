package com.bridgelabz.JavaPractice.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	
	private final static String DB_URL = "jdbc:mysql://localhost:3306/address_book_service?autoReconnect=true&useSSL=false";
	private final static String DB_USERNAME = "root";
	private final static String DB_PASSWORD = "Sanobar@28397";

	public static Connection getConnection() {
		Connection con = null;
		try {
			// create the connection now
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB Connection created successfully");
		return con;
	}

}
