package Entity;

public class Ghe {
	private String maGhe;
	private LoaiGhe loaiGhe;
	private double donGia;
	public Ghe(String maGhe, LoaiGhe loaiGhe, double donGia) {
		super();
		this.maGhe = maGhe;
		this.loaiGhe = loaiGhe;
		this.donGia = donGia;
	}
	public Ghe() {
		super();
	}
	public String getMaGhe() {
		return maGhe;
	}
	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}
	public LoaiGhe getLoaiGhe() {
		return loaiGhe;
	}
	public void setLoaiGhe(LoaiGhe loaiGhe) {
		this.loaiGhe = loaiGhe;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	
	
}
