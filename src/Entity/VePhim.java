package Entity;

import java.sql.Time;
import java.time.LocalDateTime;

public class VePhim {
	private String maVe;
	private ChiTietGhe chiTietGhe;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private double donGia;
	private LocalDateTime thoiGianDat;
	private Phong phong;
	private Phim phim;
	private XuatChieu xuatChieu;
	private Ghe ghe;
	private Time thoiGianBatDau;
	public VePhim(String maVe, ChiTietGhe chiTietGhe, NhanVien nhanVien, KhachHang khachHang, double donGia,
			LocalDateTime thoiGianDat, Phong phong, Phim phim, XuatChieu xuatChieu, Ghe ghe, Time thoiGianBatDau) {
		super();
		this.maVe = maVe;
		this.chiTietGhe = chiTietGhe;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.donGia = donGia;
		this.thoiGianDat = thoiGianDat;
		this.phong = phong;
		this.phim = phim;
		this.xuatChieu = xuatChieu;
		this.ghe = ghe;
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public VePhim() {
		super();
	}
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public ChiTietGhe getChiTietGhe() {
		return chiTietGhe;
	}
	public void setChiTietGhe(ChiTietGhe chiTietGhe) {
		this.chiTietGhe = chiTietGhe;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public LocalDateTime getThoiGianDat() {
		return thoiGianDat;
	}
	public void setThoiGianDat(LocalDateTime thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public Phim getPhim() {
		return phim;
	}
	public void setPhim(Phim phim) {
		this.phim = phim;
	}
	public XuatChieu getXuatChieu() {
		return xuatChieu;
	}
	public void setXuatChieu(XuatChieu xuatChieu) {
		this.xuatChieu = xuatChieu;
	}
	public Ghe getGhe() {
		return ghe;
	}
	public void setGhe(Ghe ghe) {
		this.ghe = ghe;
	}
	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	
	
	
}
