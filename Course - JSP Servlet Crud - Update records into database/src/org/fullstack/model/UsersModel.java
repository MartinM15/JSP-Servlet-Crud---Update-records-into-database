package org.fullstack.model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.fullstack.entity.User;


public class UsersModel {
	
	public List<User> listUsers(DataSource dataSource) {
		// Step 1: Initialize connection objects
				//PrintWriter out= response.getWriter();
				List<User> listUsers = new ArrayList<>();
				Connection connect = null;
				Statement stmt = null;
				ResultSet rs= null;
				try {
					connect = dataSource.getConnection();
					
					// Step 2: Create a SQL statements string
					String query = "Select * from users";
					stmt = connect.createStatement();
					
					// Step 3: Execute SQL query
					
					rs = stmt.executeQuery(query);
					// Step 4: Process the result set
					while(rs.next()) {
						//out.print("<br/>" + rs.getString("email") + "correos");
						listUsers.add(new User(rs.getInt("users_id"),rs.getString("username"),rs.getString("email")));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return listUsers;
				
	}

	public void addUser(DataSource dataSource, User newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		
		try {
			connect = dataSource.getConnection();
			String username = newUser.getUsername();
			String email = newUser.getEmail();
			String query = "INSERT INTO users(username, email) VALUES (?, ?)"; 
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			 statement.execute();
			//return statement.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
			//return false;
		}
		
		
		
	}

	public void updateUser(DataSource dataSource, User updateUser) {
		
		Connection connect = null;
		PreparedStatement statement = null;
		
		try {
			connect = dataSource.getConnection();
			int userId = updateUser.getUsers_id();
			String username = updateUser.getUsername();
			String email = updateUser.getEmail();
			
			String query = "update users set username=?, email=? where users_id=?"; 
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setInt(3, userId);
			statement.execute();
			//return statement.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
			//return false;
		}
		
	}

	public void deleteUser(DataSource dataSource ,int usersId) {
		
		Connection connect = null;
		PreparedStatement statement = null;
		
		try {
			connect = dataSource.getConnection();
			String query = "Delete from users where users_id=?"; 
			statement = connect.prepareStatement(query);
			statement.setInt(1, usersId);
			
			statement.execute();
			//return statement.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
			//return false;
		}
		
	}

}
