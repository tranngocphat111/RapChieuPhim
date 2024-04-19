package Entity;

import java.time.LocalDate;

public class Phim {
	private String maPhim;
	private LoaiPhim loaiphim;
	private String tenPhim;
	private	int thoiLuong;
	private LocalDate ngayPhatHanh;
	private HinhAnh hinhAnh;
	
	
	
	
	
	
	public Phim() {
		super();
	}
	
	
	public HinhAnh getHinhAnh() {
		return hinhAnh;
	}


	public void setHinhAnh(HinhAnh hinhAnh) {
		this.hinhAnh = hinhAnh;
	}


	public Phim(String maPhim) {
		super();
		this.maPhim = maPhim;
	}


	public Phim(String maPhim, LoaiPhim loaiphim, String tenPhim, int thoiLuong, LocalDate ngayPhatHanh,
			HinhAnh hinhAnh) {
		super();
		this.maPhim = maPhim;
		this.loaiphim = loaiphim;
		this.tenPhim = tenPhim;
		this.thoiLuong = thoiLuong;
		this.ngayPhatHanh = ngayPhatHanh;
		this.hinhAnh = hinhAnh;
	}


	public String getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}
	public LoaiPhim getLoaiphim() {
		return loaiphim;
	}
	public void setLoaiphim(LoaiPhim loaiphim) {
		this.loaiphim = loaiphim;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public LocalDate getNgayPhatHanh() {
		return ngayPhatHanh;
	}
	public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}
	
	
}
