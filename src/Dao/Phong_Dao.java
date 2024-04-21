package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.Phong;

public class Phong_Dao {
	public Phong_Dao () {
		
	}
	
	public ArrayList<Phong> printAll() throws SQLException{
		ArrayList<Phong> list = new ArrayList<Phong>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("Select * from  Phong");
			
			while (rs.next()) {
				 String MaPhong = rs.getString(1);
				 int soPhong = Integer.parseInt(rs.getString(2)) ;
				 int SoluongGhe = Integer.parseInt(rs.getString(3)) ;
				
				Phong p = new Phong(MaPhong, soPhong, SoluongGhe);
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
	
	
}