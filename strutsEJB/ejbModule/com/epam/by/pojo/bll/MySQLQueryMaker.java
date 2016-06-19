package com.epam.by.pojo.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLQueryMaker {
	private static Connection connection;
	private static Context initialContext;
	private static PreparedStatement statement;
	
	private static Connection getConnection() throws NamingException, SQLException {
		DataSource ds = null;
		initialContext = new InitialContext();
		ds = (DataSource) initialContext.lookup("java:/MySqlDS");
		connection = ds.getConnection();
		return connection;
	}
	
	
	public static ResultSet exequteQuery(String query, String... parameters) throws SQLException, NamingException{
		
		ResultSet result=null;
		Connection connect=getConnection();
		statement = connect.prepareStatement(query);
		int i=0;
		for(i=0;i<parameters.length;i++){
			statement.setString(i+1, parameters[i]);
		}
		result = statement.executeQuery();		
		closeConnection();		
		return result;
	}

	public static void closeConnection() {
		try {			
			if(statement!=null){
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
			if(initialContext!=null){
				initialContext.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
}
