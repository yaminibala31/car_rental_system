package util;
import java.sql.*;

public class DBConnection { 
	
	private static Connection con;
	
	public static Connection getConnection() throws Exception {
		
		con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/car_rental", "root", "B@la31");
		System.out.println("connection done");
		return con;
		
	}
}
