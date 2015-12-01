/**
 * 
 */
package fr.esigelec.projectHibernate.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Rolland
 *
 */
public class ConnectionManager {
	
	private static String url ="jdbc:mysql://localhost:3306/bdd_geographie";
	private static String username ="root";
	private static String password = "";
	
	private static Connection connection=null;
	
	public static Connection getConnection() throws SQLException{
			try {
				System.out.println("Connecting to MySQL ...");
					Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception e) {
				System.out.println("Connection failed. ");
				e.printStackTrace();
			}
			
			System.out.println("Connecting to database...");

			try {
					connection = DriverManager.getConnection(url, username, password);
			    System.out.println("Database connected!");
			} catch (SQLException e) {
			    throw new IllegalStateException("Cannot connect the database!", e);
			}
			return connection;
	}
	
	public static void close(){
		try {
			connection.close();
			System.out.println("\n Connection closed!\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
