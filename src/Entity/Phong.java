package Entity;

public class Phong {
	private String maPhong;
	private int soPhong;
	private int soLuongGhe;
	
	
	
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}



	public Phong(String maPhong, int soPhong, int soLuongGhe) {
		super();
		this.maPhong = maPhong;
		this.soPhong = soPhong;
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



	public int getSoLuongGhe() {
		return soLuongGhe;
	}



	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}


	
	
	
	
}
