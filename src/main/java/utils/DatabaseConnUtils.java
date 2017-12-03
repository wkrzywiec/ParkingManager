package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnUtils {

	private static final String hostName = "localhost";
	private static final int portNumber = 3306;
	private static final String dbName = "parkingdb";
	private static final String dbUtils = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	private static final String userName = "root";
	private static final String userPassword = "admin";
	
	public static Connection getConnection(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL = "jdbc:mysql://" + hostName + ":" + portNumber + "/" + dbName + dbUtils;
			
			return DriverManager.getConnection(dbURL, userName,userPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
