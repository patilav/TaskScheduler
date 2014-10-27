package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DbConnection.*;


public class LoginDAO {
	
	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	public String validateLogin(String username, String password) {
	
		connection c = new connection();
		con = c.getConnection();
		try {
			
			st = con.createStatement();
			rs = st.executeQuery("select * from customer where username = '"+username+"' and password = '"+password+"'");
			
		
			if( rs.next()) {
				
				rs.close();
				st.close();
				con.close();
				System.out.println("customer login approved by db");
				return "customer";
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


