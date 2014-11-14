package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbConnection.*;


public class LoginDAO {
	
	
	Connection con = null;
	ResultSet rs = null;
	public String validateLogin(String username, String password) {
	
		connection c = new connection();
		con = c.getConnection();
		try {
			String query = "select * from user where username = ? and password = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setString(1, username);
			preparedStmt.setString(2, password);
			
			rs = preparedStmt.executeQuery();
			
			while (rs.next()) {
				//System.out.println("record found");
				return "match";
				
			}
			
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return "invalid";
	}
}


