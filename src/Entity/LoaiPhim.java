package Entity;

public class LoaiPhim {
	private String maPhim;
	private String tenPhim;
	
	public LoaiPhim(String maPhim) {
		super();
		this.maPhim = maPhim;
	}

	public LoaiPhim(String maPhim, String tenPhim) {
		super();
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
	}

	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	
	
}
