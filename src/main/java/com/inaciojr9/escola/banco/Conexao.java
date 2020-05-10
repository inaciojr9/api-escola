package com.inaciojr9.escola.banco;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexao {
 
	// Para conexão ao oracle
	/*
	 * private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	 * private static final String DB_CONNECTION =
	 * "jdbc:oracle:thin:@localhost:1521:xe"; private static final String DB_USER =
	 * "HR"; private static final String DB_PASSWORD = "HR";
	 */
	
	/*
	// Para conexão mysql
	static final String DB_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_CONNECTION = "jdbc:mysql://localhost/escola";
	static final String DB_USER = "root";
	static final String DB_PASSWORD = "root";
	*/
	
	// Para conexão postgres
	static final String DB_DRIVER = "org.postgresql.Driver";  
	static final String DB_CONNECTION = "jdbc:postgresql://localhost/escola";
	static final String DB_USER = "inaciojr9";
	static final String DB_PASSWORD = "inaciojr9";
	
	// Para conexão ao oracle inacio
	/*private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:49161:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "oracle";*/
	
	/*private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:49161:xe";
	private static final String DB_USER = "HR";
	private static final String DB_PASSWORD = "HR";*/
 
	public static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
 
}
