package ConnectDB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyRapPhim";
	private String user = "sa";
	private String pass = "12345";
	
	private Connection con = null;
	public ConnectDB() throws SQLException {
		con = DriverManager.getConnection(url, user, pass);
		
	}
	
	public Connection getCon() {
		return con;
	}
	
}
