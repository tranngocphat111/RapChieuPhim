package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.HinhAnh;
import Entity.LoaiPhim;
import Entity.Phim;

public class HinhAnh_Dao {
	
	public HinhAnh_Dao() {
		
	}
	public ArrayList<HinhAnh> printAll() throws SQLException{
		ArrayList<HinhAnh> list = new ArrayList<HinhAnh>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("Select * from  HinhAnh");
			
			while (rs.next()) {
				String maAnh = rs.getString(1);
				String url = rs.getString(2);
		
				HinhAnh hinh = new HinhAnh(maAnh, url);
				
			
				list.add(hinh);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
}
