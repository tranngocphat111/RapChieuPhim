package Entity;

import java.sql.Time;

public class XuatChieu {
	private String maXuatChieu;
	private Time ThoiGianBatDau;
	
	
	public XuatChieu(String maXuatChieu) {
		super();
		this.maXuatChieu = maXuatChieu;
		
	}


	public XuatChieu(String maXuatChieu, Time thoiGianBatDau) {
		super();
		this.maXuatChieu = maXuatChieu;
		ThoiGianBatDau = thoiGianBatDau;
	}


	public String getMaXuatChieu() {
		return maXuatChieu;
	}


	public void setMaXuatChieu(String maXuatChieu) {
		this.maXuatChieu = maXuatChieu;
	}


	public Time getThoiGianBatDau() {
		return ThoiGianBatDau;
	}


	public void setThoiGianBatDau(Time thoiGianBatDau) {
		ThoiGianBatDau = thoiGianBatDau;
	}
	
	
}
