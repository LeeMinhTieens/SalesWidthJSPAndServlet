package com.leminhtien.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyConnection {
	
	private static ResourceBundle resourceBunble = ResourceBundle.getBundle("connection");
	

	public static Connection  getConnection() {
		try {
			Class.forName(resourceBunble.getString("driverName"));
			String url = resourceBunble.getString("url");
			String user = resourceBunble.getString("user");
			String password = resourceBunble.getString("password");
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return  null;
			
		}
	}
	
	
}
