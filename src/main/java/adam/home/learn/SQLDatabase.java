package adam.home.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabase {
	
	String database;
	String username;
	String password;
	
	public SQLDatabase(String dbName, String dbUser, String dbPassword) {
		database = dbName;
		username = dbUser;
		password = dbPassword;
	}
	
	// Connect to database. Use database name input to connect to SQL server.
	public Connection establishConnection() {
		Connection conn = null;
		
		String connectionString = "jdbc:sqlserver://35.242.178.132:1433;" + "database="+database+";" + "user="+username+";"
				+ "password="+password+";" + "encrypt=false;" + "trustServerCertificate=false;" + "loginTimeout=30;";

		
		// Attempt connection to SQL server
		try {
			System.out.println("INFO - Attempting connection to SQL server.");
			conn = DriverManager.getConnection(connectionString);
		
		// Catch error if connection fails.
		} catch (SQLException e) {
			System.out.println("ERROR - SQL Database connection FAILED!");
			e.printStackTrace();
		}
		return conn;
	}

	public boolean connectionStatus(Connection conn) {
		
		try {
			
			return conn != null && !conn.isClosed();
			
		} catch (SQLException e) {}
		
		return false;
	}
}
