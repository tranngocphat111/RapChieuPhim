package Entity;
public class ChiTietXuatChieu {
	private String maCTXC;
	private XuatChieu xuatChieu;
	private Phim phim;
	private Phong phong;
	private int SoLuongGheDat;
	private int SoLuongGheTrong;
	
	
	public ChiTietXuatChieu(String maCTXC) {
		super();
		this.maCTXC = maCTXC;
	}


	public ChiTietXuatChieu(String maCTXC, XuatChieu xuatChieu, Phim phim, Phong phong, int soLuongGheDat,
			int soLuongGheTrong) {
		super();
		this.maCTXC = maCTXC;
		this.xuatChieu = xuatChieu;
		this.phim = phim;
		this.phong = phong;
		SoLuongGheDat = soLuongGheDat;
		SoLuongGheTrong = soLuongGheTrong;
	}
	
	


	public ChiTietXuatChieu(String maCTXC, XuatChieu xuatChieu, Phim phim, Phong phong) {
		super();
		this.maCTXC = maCTXC;
		this.xuatChieu = xuatChieu;
		this.phim = phim;
		this.phong = phong;
	}


	public String getMaCTXC() {
		return maCTXC;
	}


	public void setMaCTXC(String maCTXC) {
		this.maCTXC = maCTXC;
	}


	public XuatChieu getXuatChieu() {
		return xuatChieu;
	}


	public void setXuatChieu(XuatChieu xuatChieu) {
		this.xuatChieu = xuatChieu;
	}


	public Phim getPhim() {
		return phim;
	}


	public void setPhim(Phim phim) {
		this.phim = phim;
	}


	public Phong getPhong() {
		return phong;
	}


	public void setPhong(Phong phong) {
		this.phong = phong;
	}


	public int getSoLuongGheDat() {
		return SoLuongGheDat;
	}


	public void setSoLuongGheDat(int soLuongGheDat) {
		SoLuongGheDat = soLuongGheDat;
	}


	public int getSoLuongGheTrong() {
		return SoLuongGheTrong;
	}


	public void setSoLuongGheTrong(int soLuongGheTrong) {
		SoLuongGheTrong = soLuongGheTrong;
	}

	
	
	



}
