	package DbConnection;

	import java.sql.SQLException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import oracle.jdbc.driver.OracleDriver;

	public class connection {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	///////////................................CONNECTIONG TO DATABASE FUNCTION............////////////////
		public Connection getConnection() {
				
			try {
				String driverName = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost/myorganiser";
				String uname = "mydb";
				String pwd = "mayu1009";
				Class.forName(driverName);
				System.out.println("Driver Registered");
				con = DriverManager.getConnection(url, uname, pwd);
				System.out.println("Connection Successful");
			//	return con;
			} 
			catch (Exception e) {
				System.out.println("ERROR: Unable to Connect to Database.");
				e.printStackTrace();
			}
			return con;
		}
		
		public void close()
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(Exception e)
			{}
		}
		
		
	
}
