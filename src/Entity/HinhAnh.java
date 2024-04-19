package Entity;

public class HinhAnh {
	private String MaAnh;
	private String url;
	public HinhAnh(String maAnh, String url) {
		super();
		MaAnh = maAnh;
		this.url = url;
	}
	public HinhAnh(String maAnh) {
		super();
		MaAnh = maAnh;
	}
	public String getMaAnh() {
		return MaAnh;
	}
	public void setMaAnh(String maAnh) {
		MaAnh = maAnh;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
