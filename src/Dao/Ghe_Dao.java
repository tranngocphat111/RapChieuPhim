package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.Ghe;
import Entity.LoaiGhe;


public class Ghe_Dao {
	
	public Ghe_Dao() {
		
	}
	
	
	public ArrayList<Ghe> printAll() throws SQLException{
		ArrayList<Ghe> list = new ArrayList<Ghe>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("exec SelectGhe");
			
			while (rs.next()) {
				String maGhe = rs.getString(1);
				String maLoaiGhe = rs.getString(2);
				double donGia = rs.getDouble(3);
				String tenLoaiGhe = rs.getString(4);
				
				Ghe ghe = new Ghe(maGhe, new LoaiGhe(maLoaiGhe, tenLoaiGhe), donGia);
				list.add(ghe);	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
	
}