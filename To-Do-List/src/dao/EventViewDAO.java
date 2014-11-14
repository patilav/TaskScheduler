package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EventBean;

import DbConnection.connection;

public class EventViewDAO {


	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<EventBean> view(int id) {
	
		EventBean eb;
		List<EventBean> le = new ArrayList<EventBean>();
		connection c=new connection();
		con = c.getConnection();
		try {
			String query1 = "select a.name, e.venue, e.`start-date`, e.`end-date`, e.occurrence from `user-activity` a, `user-events` e where a.id = e.id and a.id = ?";
			ps = con.prepareStatement(query1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				eb = new EventBean();
				eb.setName(rs.getString(1));
				eb.setVenue(rs.getString(2));
				eb.setStartDate(rs.getString(3));
				eb.setEndDate(rs.getString(4));
				eb.setOccurrence(rs.getString(5));
			/*	li.add(rs.getString(1));
				li.add(rs.getString(2));
				li.add(rs.getString(3));
				li.add(rs.getString(4));
				li.add(rs.getString(5)); */
				le.add(eb);
				
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		

return le;
}
}
