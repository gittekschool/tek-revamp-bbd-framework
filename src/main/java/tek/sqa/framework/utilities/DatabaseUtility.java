package tek.sqa.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseUtility {
	
	private String url; 
	private String username; 
	private String password; 

	public DatabaseUtility(String url, String username, String password) {
		this.url = url; 
		this.username = username; 
		this.password = password; 
	}
	
	public ArrayList<Map<String, Object>> executeSelectQuery(String query) {
		Connection connection = null; 
		Statement statement = null; 
		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			
			ResultSet resultSet =statement.executeQuery(query);
			ResultSetMetaData metaData = resultSet.getMetaData();
			
			ArrayList<Map<String, Object>> result = new ArrayList<>();
			while (resultSet.next()) {
				Map<String, Object> row = new HashMap<>();
				for (int col = 1; col <= metaData.getColumnCount(); col ++ ) {
					String key = metaData.getColumnName(col);
					Object value = resultSet.getObject(col);
					
					row.put(key, value);
				}
				result.add(row);
			}
			return result; 
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getSQLState());
			throw new RuntimeException("Exception Happened test stop here.");
		} finally {
			try {
				if (statement != null ) {
					statement.close();
				}
				
				if (connection != null ) {
					connection.close();
				}
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println(ex.getSQLState());
				throw new RuntimeException("Exception Happened test stop here.");
			}
		}
	}
	
}
