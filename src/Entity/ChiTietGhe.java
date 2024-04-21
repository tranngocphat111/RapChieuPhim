package Entity;

public class ChiTietGhe {
	private String maCTGhe;
	private ChiTietXuatChieu CTXC;
	private Ghe ghe;
	
	
	
	public ChiTietGhe(String maCTGhe) {
		super();
		this.maCTGhe = maCTGhe;
	}



	public ChiTietGhe(String maCTGhe, ChiTietXuatChieu cTXC, Ghe ghe) {
		super();
		this.maCTGhe = maCTGhe;
		CTXC = cTXC;
		this.ghe = ghe;
	}



	public String getMaCTGhe() {
		return maCTGhe;
	}



	public void setMaCTGhe(String maCTGhe) {
		this.maCTGhe = maCTGhe;
	}



	public ChiTietXuatChieu getCTXC() {
		return CTXC;
	}



	public void setCTXC(ChiTietXuatChieu cTXC) {
		CTXC = cTXC;
	}



	public Ghe getGhe() {
		return ghe;
	}



	public void setGhe(Ghe ghe) {
		this.ghe = ghe;
	}
	
	
	
	
	
}
