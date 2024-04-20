package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class TaiKhoan_Dao {
	
	
	
	public TaiKhoan_Dao(){
		
	}
	
	public ArrayList<TaiKhoan> printAll() throws SQLException { 
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("Select * from TaiKhoan");
			while(rs.next()) {
				String tenTaiKhoan = rs.getString(1);
				String matKhau = rs.getString(2);
				String maNV = rs.getString(3);
				
				TaiKhoan tk = new TaiKhoan(tenTaiKhoan, matKhau, new NhanVien(maNV));
				list.add(tk);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		state.close();
		return list;
				
	}
}
