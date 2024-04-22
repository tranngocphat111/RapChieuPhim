package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChiTietGhe;
import Entity.ChiTietXuatChieu;
import Entity.Ghe;
import Entity.HinhAnh;
import Entity.KhachHang;
import Entity.LoaiGhe;
import Entity.LoaiPhim;
import Entity.NhanVien;
import Entity.Phim;
import Entity.Phong;
import Entity.VePhim;
import Entity.XuatChieu;

public class VePhim_Dao {
	public VePhim_Dao () {
			
	}
	
	public ArrayList<VePhim> printAll() throws SQLException{
		ArrayList<VePhim> list = new ArrayList<VePhim>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		
		java.sql.Statement state = null;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("Select * from VePhim");
			
			while (rs.next()) {
				String maVe = rs.getString(1);
				String maCTGhe = rs.getString(2);
				String maNV = rs.getString(3);
				String maKH = rs.getString(4);
				double DonGia = Double.parseDouble(rs.getString(5)) ;
				String thoigianDat = rs.getString(6);
				String maPhong = rs.getString(7);
				String maPhim = rs.getString(8);
				String maSuatChieu = rs.getString(9);
				String maGhe = rs.getString(10);
				Time thoiGianBatDau = rs.getTime(11);
				
				
				VePhim ve = new VePhim(maVe, new ChiTietGhe(maCTGhe), new NhanVien(maNV), new KhachHang(maKH), DonGia, thoigianDat, new Phong(maPhong), new Phim(maPhim), new XuatChieu(maSuatChieu), new Ghe(maGhe), thoiGianBatDau);
				list.add(ve);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state.close();
		
		return list;
	}
	
	public  boolean create(VePhim ve) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into VePhim values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, ve.getMaVe());
			stmt.setString(2, ve.getChiTietGhe().getMaCTGhe());
			stmt.setString(3, ve.getNhanVien().getMaNV());
			stmt.setString(4, ve.getKhachHang().getMaKhachHang());
			stmt.setDouble(5, ve.getDonGia());
		
			stmt.setString(6, ve.getThoiGianDat()); 
			stmt.setString(7, ve.getPhong().getMaPhong());
			stmt.setString(8, ve.getPhim().getMaPhim());
			stmt.setString(9, ve.getXuatChieu().getMaXuatChieu());
			stmt.setString(10, ve.getGhe().getMaGhe());
			stmt.setTime(11, ve.getThoiGianBatDau());
			
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
