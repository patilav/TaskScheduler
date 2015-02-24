package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.AppointmentBean;
import bean.EventBean;
import bean.NotesBean;

import DbConnection.connection;

public class NotesViewDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public List<NotesBean> view(int id) throws SQLException {
		NotesBean nb;
		List<NotesBean> le = new ArrayList<NotesBean>();
		connection c = new connection();
		con = c.getConnection();
		try {
			System.out.println("The login ID is :" + id);
			String query1 = "select a.id, a.name, n.text, ni.image from `user-activity` a, `user-notes` n, `user-notes-images` ni where a.id = n.id and n.id = ni.id and a.user_id = ?";
			ps = con.prepareStatement(query1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				nb = new NotesBean();
				nb.setNotes_id(rs.getInt(1));
				nb.setName(rs.getString(2));
				nb.setText(rs.getString(3));
				nb.setImagePath(rs.getBlob(4));
				le.add(nb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			con.close();
		}
		return le;
	}


	/*
	 * public List<NotesBean> view(int id) throws SQLException { NotesBean nb;
	 * List<NotesBean> la = new ArrayList<NotesBean>(); connection c = new
	 * connection(); con = c.getConnection(); try {
	 * System.out.println("The login ID is :" + id); String query1 =
	 * "select ua.name, un.text, un.id, uni.image from `user-activity` ua, `user-notes` un, `user-notes-images` uni"
	 * + "where ua.id = un.id and un.id = uni.id and ua.user_id = ?"; ps =
	 * con.prepareStatement(query1); ps.setInt(1, id); rs = ps.executeQuery();
	 * while (rs.next()) { ab = new NotesBean();
	 * ab.setAppointmentId(rs.getInt(1)); ab.setName(rs.getString(2));
	 * ab.setDateOfAppointment(rs.getString(3)); ab.setPurpose(rs.getString(4));
	 * ab.setLocation(rs.getString(5)); ab.setDuration(rs.getInt(6));
	 * ab.setPriority(rs.getString(7)); la.add(ab); } } catch (SQLException e) {
	 * e.printStackTrace(); throw new SQLException(e); } finally { con.close();
	 * } return la; }
	 */

	/*
	 * public NotesBean getAppointmentForEdit(int eventBeanId) throws
	 * SQLException { NotesBean nb = new NotesBean(); connection c = new
	 * connection(); con = c.getConnection(); try {
	 * System.out.println("id before the query:"+eventBeanId); String query1 =
	 * "select a.id, a.name, ap.`date-of-appointment`, ap.purpose, ap.location, ap.duration, ap.priority from `user-activity` a, `user-appointments` ap where a.id = ap.id and a.id = ?"
	 * ; ps = con.prepareStatement(query1); ps.setInt(1, eventBeanId); rs =
	 * ps.executeQuery(); while (rs.next()) { nb = new NotesBean();
	 * 
	 * nb.setAppointmentId(rs.getInt(1)); nb.setName(rs.getString(2));
	 * nb.setDateOfAppointment(rs.getString(3)); nb.setPurpose(rs.getString(4));
	 * ab.setLocation(rs.getString(5)); ab.setDuration(rs.getInt(6));
	 * ab.setPriority(rs.getString(7)); } } catch (SQLException e) {
	 * e.printStackTrace(); throw new SQLException(e); } finally { con.close();
	 * } return ab; }
	 */

	
	public NotesBean getNotesForEdit(int eventBeanId) throws SQLException {
		NotesBean nb = new NotesBean();
		connection c = new connection();
		con = c.getConnection();
		try {
			
			String query2 = "select a.id, a.name, n.text, ni.image from `user-activity` a, `user-notes` n, `user-notes-images` ni where a.id = n.id and n.id = ni.id and n.id = ?";
			
			ps = con.prepareStatement(query2);
			ps.setInt(1, eventBeanId);
			rs = ps.executeQuery();
			while (rs.next()) {
				nb = new NotesBean();
				nb.setNotes_id(rs.getInt(1));
				nb.setName(rs.getString(2));
				nb.setText(rs.getString(3));
				nb.setImagePath(rs.getBlob(4));
			
			}

		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			con.close();
		}
		return nb;
	}

	
	
	public List getNotesInfo(int notesBeanId) throws SQLException {
		NotesBean nb = new NotesBean();
		List<NotesBean> li = new ArrayList<NotesBean>();
		List<Blob> li2 = new ArrayList<Blob>();
		Map m = new HashMap();

		connection c = new connection();
		con = c.getConnection();
		try {
			
			String query2 = "select a.id, a.name, n.text, ni.image from `user-activity` a, `user-notes` n, `user-notes-images` ni where a.id = n.id and n.id = ni.id and a.user_id = ?";
			Blob im = null;
			ps = con.prepareStatement(query2);
			ps.setInt(1, notesBeanId);
			rs = ps.executeQuery();
			while (rs.next()) {
				nb = new NotesBean();
				nb.setNotes_id(rs.getInt(1));
				nb.setName(rs.getString(2));
				nb.setText(rs.getString(3));
				nb.setImagePath(rs.getBlob(4));
				li.add(nb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			con.close();
		}
		return li;
	}
}
