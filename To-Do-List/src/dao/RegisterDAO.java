package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DbConnection.connection;

public class RegisterDAO {

	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	public String registerCustomer(String fname, String lname, String username, String password, String dob, String secretQuestion, String secretAnswer) {
	
		connection c = new connection();
		con = c.getConnection();
		try {
			
			st = con.createStatement();
			rs = st.executeQuery("insert into customer(username, fname, lname, password, dob, secret_question, secret_answer) values ('"+username+"','"+fname+"','"+lname+"','"+password+"',to_date('"+dob+"','dd/mm/yyyy'),'"+secretQuestion+"','"+secretAnswer+"')");
			
			while(rs.next())
			{
				System.out.println("customer details added");
				return "done";
				
			}
		
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(rs!=null)
		{
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return "invalid";
	}
}




