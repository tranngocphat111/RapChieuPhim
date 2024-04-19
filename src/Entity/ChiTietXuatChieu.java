package Entity;
public class ChiTietXuatChieu {
	private String maCTXC;
	private XuatChieu xuatChieu;
	private Phim phim;
	private Phong phong;
	
	
	public ChiTietXuatChieu(String maCTXC) {
		super();
		this.maCTXC = maCTXC;
	}


	


	public Phong getPhong() {
		return phong;
	}





	public void setPhong(Phong phong) {
		this.phong = phong;
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
	
	
	
	
}
