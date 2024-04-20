package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.HinhAnh;
import Entity.LoaiPhim;
import Entity.Phim;
import Entity.XuatChieu;

public class XuatChieu_Dao {
	public XuatChieu_Dao () {
		
	}
	
	public ArrayList<XuatChieu> printAll() throws SQLException{
		ArrayList<XuatChieu> list = new ArrayList<XuatChieu>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("Select * from  XuatChieu");
			
			while (rs.next()) {
				String maXC = rs.getString(1);
				Time thoiGianBatDau = rs.getTime(2);
				
				XuatChieu xc = new XuatChieu(maXC, thoiGianBatDau);
				
				list.add(xc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
	
	
}
