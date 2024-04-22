package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChiTietXuatChieu;
import Entity.HinhAnh;
import Entity.LoaiPhim;
import Entity.Phim;
import Entity.Phong;
import Entity.XuatChieu;

public class ChiTietXuatChieu_Dao {
	public ChiTietXuatChieu_Dao() {
		
	}
	
	
	public ArrayList<ChiTietXuatChieu> printAll() throws SQLException{
		ArrayList<ChiTietXuatChieu> list = new ArrayList<ChiTietXuatChieu>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("exec SelectCTXT");
			
			while (rs.next()) {
				String MaCTXC = rs.getString(1);
				 String MaPhong = rs.getString(2);
				 int soPhong = Integer.parseInt(rs.getString(3)) ;
				 String MaPhim = rs.getString(4);
				 String tenPhim = rs.getString(5);
				 String maXC = rs.getString(6);
				 int soLuonGheDat = Integer.parseInt(rs.getString(7)) ;
				 int SoLuongGheTrong = Integer.parseInt(rs.getString(8)) ;
				 int SOluongGhe = Integer.parseInt(rs.getString(9)) ;
				 Time thoiGianBatDau = rs.getTime(10);
				 String maLoai = rs.getString(11);
				 int thoiLuong = rs.getInt(12);
				 LocalDate ngayPhatHang = LocalDate.parse(rs.getDate(13).toString());
				 String maAnh = rs.getString(14);
				 String url = rs.getString(15);
				 XuatChieu xc =  new XuatChieu(maXC, thoiGianBatDau);
				 Phong phong = new Phong(MaPhong, soPhong, SOluongGhe);
				 HinhAnh hinhanh = new HinhAnh(maAnh,url);
				 Phim phim = new Phim(MaPhim, new LoaiPhim(maLoai), tenPhim, thoiLuong, ngayPhatHang, hinhanh);
				 ChiTietXuatChieu ct = new ChiTietXuatChieu(MaCTXC, xc, phim, phong,soLuonGheDat,SoLuongGheTrong);
				 
				 list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
}
