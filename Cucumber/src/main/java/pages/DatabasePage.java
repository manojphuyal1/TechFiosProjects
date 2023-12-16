package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabasePage {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String columnValue;
	public String getDataFromDb(String columnName) {
		//this.getDataFromDb();
		//com.mysql.cj.jdbc.Driver		
		
		
		try {
			//set proprtty for my sql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//String sqlUrl = "jdbc:mysql:// hostname + :portNmber + /databaseName";
			String sqlUrl = "jdbc:mysql://44.195.13.80:3306/april_2023";
			String sqlUsername = "student";
			String sqlPassword = "Student@123";
			String sqlQuery = "Select * from users;";
			
			//making connection to the database
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			
			//Empower connection  reference variable to execute query/ies
			statement = connection.createStatement();
			
			//execute quary
			resultSet = statement.executeQuery(sqlQuery);
			
			while(resultSet.next()) {
			columnValue = resultSet.getString("columnName");
			
			}
			
		} catch (ClassNotFoundException  | SQLException e ) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					//connection.close();
				} catch (SQLException e) {
					}	
				
				}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return columnValue;
		
	}

	}
