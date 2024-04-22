package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChiTietGhe;
import Entity.ChiTietXuatChieu;
import Entity.Ghe;
import Entity.HinhAnh;
import Entity.LoaiGhe;
import Entity.LoaiPhim;
import Entity.Phim;
import Entity.Phong;
import Entity.XuatChieu;

public class ChiTietGhe_Dao {
	public ChiTietGhe_Dao() {
		
	}
	
	
	public ArrayList<ChiTietGhe> printAll() throws SQLException{
		ArrayList<ChiTietGhe> list = new ArrayList<ChiTietGhe>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("exec SelectCTGhe");
			
			while (rs.next()) {
				String maCTGhe = rs.getString(1);
				String maCTXC = rs.getString(2);
				String maXC = rs.getString(3);
				Time thoiGianBatDau = rs.getTime(4) ;
				String maPhong = rs.getString(5);
				int SoPhong = Integer.parseInt(rs.getString(6)) ;
				int SoLuongGhe = Integer.parseInt(rs.getString(7)) ;
				String maPhim = rs.getString(8);
				String tenPhim = rs.getString(9);
				String maLoai = rs.getString(10);
				int thoiLuong = Integer.parseInt(rs.getString(11)) ;
				LocalDate NgayPhatHanh = LocalDate.parse(rs.getDate(12).toString());
				String maAnh = rs.getString(13);
				String url = rs.getString(14);
				String maGhe = rs.getString(15);
				String maLoaiGhe = rs.getString(16);
				double DonGia = rs.getDouble(17);
				String tenLoaiGhe = rs.getString(18);
				int soluongGheDat = Integer.parseInt(rs.getString(19));
				int soluongGheTrong = Integer.parseInt(rs.getString(20));
				
				XuatChieu xc = new XuatChieu(maXC, thoiGianBatDau);
				Phim phim = new Phim(maPhim, new LoaiPhim(maLoai), tenPhim, thoiLuong, NgayPhatHanh, new HinhAnh(maAnh, url));
				Phong phong = new Phong(maPhong, SoPhong, SoLuongGhe);
				ChiTietXuatChieu CTXC = new ChiTietXuatChieu(maCTXC, xc, phim, phong,soluongGheDat,soluongGheTrong);
				Ghe ghe = new Ghe(maGhe, new LoaiGhe(maLoaiGhe,tenLoaiGhe), DonGia);
				
				ChiTietGhe CTGhe = new ChiTietGhe(maCTGhe, CTXC, ghe);
				
				list.add(CTGhe);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
	
	public  boolean create(ChiTietGhe ctg) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietGhe values(?,?,?)");
			stmt.setString(1,ctg.getMaCTGhe());
			stmt.setString(2, ctg.getCTXC().getMaCTXC());
			stmt.setString(3, ctg.getGhe().getMaGhe());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
