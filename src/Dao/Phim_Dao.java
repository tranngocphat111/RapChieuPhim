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

public class Phim_Dao {
	
	public Phim_Dao() {
		
	}
	
	
	public ArrayList<Phim> printAll() throws SQLException{
		ArrayList<Phim> list = new ArrayList<Phim>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("Select * from  Phim P JOIN HinhAnh anh on P.MaAnh=anh.MaAnh");
			
			while (rs.next()) {
				String maPhim = rs.getString(1);
				String MaLoai = rs.getString(2);
				String tenPhim = rs.getString(3);
				int thoiLuong = Integer.parseInt(rs.getString(4));
				LocalDate ngayPhatHanh = LocalDate.parse(rs.getDate(5).toString()) ;
				String maAnh = rs.getString(6);
				String url = rs.getString(8);
				Phim phim = new Phim(maPhim, new LoaiPhim(MaLoai), tenPhim, thoiLuong, ngayPhatHanh, new HinhAnh(maAnh, url));
				
				list.add(phim);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
	
}
