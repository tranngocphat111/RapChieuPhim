package Gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HoaDon_GUI extends JFrame{
	public HoaDon_GUI() {
		setTitle("Hóa đơn");
		setSize(535,574);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		panel.setBounds(0, 0, 1010, 574);
		panel.setBackground(new Color(217, 217, 217));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel hoa_don = new JPanel();
		hoa_don.setBorder(new EmptyBorder(8, 8, 8, 8));
		hoa_don.setLocation(20, 10);
		hoa_don.setBackground(new Color(255, 169, 89));
		hoa_don.setSize(484, 472);
		panel.add(hoa_don);
		hoa_don.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBorder(new LineBorder(new Color(0, 0, 0)));
		header.setBackground(new Color(255, 244, 244));
		header.setBounds(111, 44, 274, 182);
		header.setAlignmentX(Component.RIGHT_ALIGNMENT);
		hoa_don.add(header);
		header.setLayout(null);
		
		JLabel filmPicture = new JLabel("");
		filmPicture.setBounds(0, 0, 274, 182);
		header.add(filmPicture);
		filmPicture.setIcon(new ImageIcon(HoaDon_GUI.class.getResource("/images/hoa-don-header.jpg")));
		
		JPanel PhimInfo = new JPanel();
		PhimInfo.setBackground(new Color(255, 224, 224));
		PhimInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		PhimInfo.setBounds(40, 262, 274, 93);
		hoa_don.add(PhimInfo);
		PhimInfo.setLayout(null);
		
		JLabel labelPhongChieu = new JLabel("Tên phòng chiếu:");
		labelPhongChieu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelPhongChieu.setBounds(20, 10, 87, 13);
		PhimInfo.add(labelPhongChieu);
		
		JLabel labelTenPhim = new JLabel("Tên phim:");
		labelTenPhim.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelTenPhim.setBounds(20, 30, 87, 13);
		PhimInfo.add(labelTenPhim);
		
		JLabel labelThoiGian = new JLabel("Thời gian:");
		labelThoiGian.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelThoiGian.setBounds(20, 50, 72, 13);
		PhimInfo.add(labelThoiGian);
		
		JLabel txtPhong = new JLabel("Phòng 3");
		txtPhong.setEnabled(false);
		txtPhong.setBounds(154, 10, 78, 13);
		PhimInfo.add(txtPhong);
		
		JLabel txtPhim = new JLabel("Lật Mặt 7");
		txtPhim.setEnabled(false);
		txtPhim.setBounds(154, 30, 87, 13);
		PhimInfo.add(txtPhim);
		
		JLabel txtThoiGian = new JLabel("14:00 - 16:30");
		txtThoiGian.setForeground(new Color(255, 0, 0));
		txtThoiGian.setBounds(154, 50, 87, 13);
		PhimInfo.add(txtThoiGian);
		
		JLabel txtNgayChieu = new JLabel("03/27/2024");
		txtNgayChieu.setEnabled(false);
		txtNgayChieu.setBounds(154, 65, 87, 13);
		PhimInfo.add(txtNgayChieu);
		
		JPanel VeInfo = new JPanel();
		VeInfo.setBackground(new Color(255, 224, 224));
		VeInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		VeInfo.setBounds(314, 262, 129, 93);
		hoa_don.add(VeInfo);
		VeInfo.setLayout(null);
		
		JLabel labelTienVe = new JLabel("Tiền vé:");
		labelTienVe.setBounds(10, 10, 51, 13);
		VeInfo.add(labelTienVe);
		
		JLabel labelSoGhe = new JLabel("Số ghế:");
		labelSoGhe.setBounds(10, 30, 51, 13);
		VeInfo.add(labelSoGhe);
		
		JLabel txtTienVe = new JLabel(" 65.000đ");
		txtTienVe.setEnabled(false);
		txtTienVe.setBounds(58, 10, 61, 13);
		VeInfo.add(txtTienVe);
		
		JLabel txtSoGhe = new JLabel("G4");
		txtSoGhe.setEnabled(false);
		txtSoGhe.setBounds(58, 30, 61, 13);
		VeInfo.add(txtSoGhe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 224, 224));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(40, 365, 402, 69);
		hoa_don.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelGiamTru = new JLabel("Giảm trừ:");
		labelGiamTru.setBounds(51, 10, 65, 13);
		panel_1.add(labelGiamTru);
		
		JLabel lableTongTien = new JLabel("Tổng tiền:");
		lableTongTien.setBounds(51, 34, 65, 13);
		panel_1.add(lableTongTien);
		
		JLabel txtGiamTru = new JLabel("10%");
		txtGiamTru.setEnabled(false);
		txtGiamTru.setBounds(151, 10, 45, 13);
		panel_1.add(txtGiamTru);
		
		JLabel txtTongTien = new JLabel("60.000đ");
		txtTongTien.setEnabled(false);
		txtTongTien.setBounds(151, 34, 45, 13);
		panel_1.add(txtTongTien);
		
		JButton btnNewButton = new JButton("In hóa đơn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(377, 500, 105, 21);
		panel.add(btnNewButton);
		setVisible(true);
	}
	public static void main(String[] args) {
		new HoaDon_GUI();
	}
}
