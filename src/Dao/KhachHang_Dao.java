package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.HinhAnh;
import Entity.KhachHang;

public class KhachHang_Dao {
	public KhachHang_Dao () {
		
	}
	
	public ArrayList<KhachHang> printAll() throws SQLException{
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("Select * from  KhachHang");
			
			while (rs.next()) {
				String maKH = rs.getString(1);
				String TenKH = rs.getString(2);
				int DiemTichLuy =rs.getInt(3);
				
				KhachHang kh = new KhachHang(maKH, TenKH, DiemTichLuy);
				list.add(kh);
				
			
		
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
	
	
}
