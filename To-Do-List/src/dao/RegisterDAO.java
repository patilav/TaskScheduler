package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DbConnection.connection;

public class RegisterDAO {

	Connection con;
	public boolean registerCustomer(String fname, String lname, String username, String password, String dob, String secretquestion, String secretanswer) {
	
		connection c = new connection();
		con = c.getConnection();
		try {
			String query = "insert into user(username, password, firstname, lastname, dateofbirth, secretquestion, secretanswer)"
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, username);
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, fname);
			preparedStmt.setString(4, lname);
			preparedStmt.setString(5, dob);
			preparedStmt.setString(6, secretquestion);
			preparedStmt.setString(7, secretanswer);
			
			boolean status = preparedStmt.execute();
			System.out.println(status);
			con.close();
			return status;
			
		} 
		
		catch (SQLException e) {
			System.out.println("Found an error");
			e.printStackTrace();
		}
		return false;
	}
}




