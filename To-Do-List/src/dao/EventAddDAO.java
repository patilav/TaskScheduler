package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DbConnection.connection;

public class EventAddDAO {

	
	Connection con = null;
	
	ResultSet rs = null;
	
	public String addEvent(String name, String venue, String startDate, String endDate, String occurence) {
	
		connection c = new connection();
		con = c.getConnection();
		try {
			System.out.println("here");
			String query1 = "insert into `user-activity`(name) values (?)";
			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setString(1, name);
			boolean status1 = preparedStmt1.execute();
			System.out.println(status1);
			String query2 = "select id from `user-activity` where name = ? order by id desc limit 1";
			String query3 = "insert into `user-events`(id,venue, `start-date`, `end-date`, occurrence) values (?,?,?,?,?)";
			
			if (status1 == false)
			{
				System.out.println("inserted value in activity table");
				PreparedStatement preparedStmt2 = con.prepareStatement(query2);
				preparedStmt2.setString(1, name);
				rs = preparedStmt2.executeQuery();
				
				while (rs.next())
				{
					System.out.println("record found in activity table");
					int id = rs.getInt(1);
					PreparedStatement preparedStmt3 = con.prepareStatement(query3);
					preparedStmt3.setInt(1, id);
					preparedStmt3.setString(2, venue);
					preparedStmt3.setString(3, startDate);
					preparedStmt3.setString(4, endDate);
					preparedStmt3.setString(5, occurence);
					boolean inserted = preparedStmt3.execute();
					
					if(inserted = true)
						return "success";
				}
			}
		} 
		
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		return "failure";
	}
}
