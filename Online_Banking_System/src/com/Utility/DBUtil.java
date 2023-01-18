package com.Utility;

import java.sql.Connection;

public class DBUtil {

	public static Connection provideConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/Banking";
		
		
		
		
		return con;
		
		
	}
	
}
