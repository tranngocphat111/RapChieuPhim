package Entity;

public class Phong {
	private String maPhong;
	private int soPhong;
	private String trangThai;
	private int soluongGheDat;
	private int soLuongGheTrong;
	private int soLuongGhe;
	
	
	
	public Phong() {
		super();
	}


	public Phong(String maPhong, int soPhong, String trangThai, int soluongGheDat, int soLuongGheTrong,
			int soLuongGhe) {
		super();
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.trangThai = trangThai;
		this.soluongGheDat = soluongGheDat;
		this.soLuongGheTrong = soLuongGheTrong;
		this.soLuongGhe = soLuongGhe;
	}


	public String getMaPhong() {
		return maPhong;
	}


	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}


	public int getSoPhong() {
		return soPhong;
	}


	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}


	public String getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	public int getSoluongGheDat() {
		return soluongGheDat;
	}


	public void setSoluongGheDat(int soluongGheDat) {
		this.soluongGheDat = soluongGheDat;
	}


	public int getSoLuongGheTrong() {
		return soLuongGheTrong;
	}


	public void setSoLuongGheTrong(int soLuongGheTrong) {
		this.soLuongGheTrong = soLuongGheTrong;
	}


	public int getSoLuongGhe() {
		return soLuongGhe;
	}


	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}
	
	
	
	
}
