package com.codebind.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBconnection {
	
	private String database;
	
	public Connection get_connection() throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost:3306/lab_project";
		String name = "root";
		String Pass = "codebind";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(url, name, Pass);
		
		return conn;
	}

	
	public DBconnection() {
		this.database = "lab_project";
	}


	public DBconnection(String database) {
		this.database = database;
	}
	
	public Connection get_second_connection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/lab_practise";
		String name = "root";
		String Pass = "codebind";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(url, name, Pass);
		
		return conn;
		
	}
}
