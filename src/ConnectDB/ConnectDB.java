package ConnectDB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection con = null;
	private static ConnectDB insatance = new ConnectDB();
	
	public static ConnectDB getInstance(){
		return insatance;
	}
	

	
	public static void  Connect() throws SQLException {
		
		String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyRapPhim";
		String user = "sa";
		String pass = "12345";
		con = DriverManager.getConnection(url, user, pass);
		
	}
	
	public void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getCon() {
		return con;
	}
	
}
