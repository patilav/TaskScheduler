package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DbConnection.connection;

public class EventEditDAO {

	
	Connection con = null;
	
	ResultSet rs = null;
	
	public String editEvent(int id, String name, String venue, String startDate, String endDate, String occurence) {
	
		connection c = new connection();
		con = c.getConnection();
		try {
			String query1 = "update `user-activity` set name = ? where id = ?";
			String query2 = "update `user-events` set venue = ?, `start-date` = ?, `end-date` = ?, occurrence = ? where id =? ";
			
			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setString(1, name);
			preparedStmt1.setInt(2,id);
			int result1 = preparedStmt1.executeUpdate();
			
			if(result1 != 0)
			{
				PreparedStatement preparedStmt2 = con.prepareStatement(query2);
				preparedStmt2.setString(1, venue);
				preparedStmt2.setString(2, startDate);
				preparedStmt2.setString (3,endDate);
				preparedStmt2.setString(4, occurence);
				preparedStmt2.setInt(5, id);
				preparedStmt2.executeUpdate();
				return "update success";
			}
		} 
		
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		return "update fail";
	}
}
