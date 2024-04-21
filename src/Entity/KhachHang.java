package Entity;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private int DiemTichLuy;
	

	public KhachHang() {
		// TODO Auto-generated constructor stub
		
	}
	public KhachHang(String maKhachHang) {
		
		super();
		this.maKhachHang = maKhachHang;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public int getDiemTichLuy() {
		return DiemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		DiemTichLuy = diemTichLuy;
	}
	public KhachHang(String maKhachHang, String tenKhachHang, int diemTichLuy) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		DiemTichLuy = diemTichLuy;
	}
	
	

	
}
