/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ConnectDB.ConnectDB;
import Entity.Ghe;
import Entity.KhachHang;
import Dao.ChiTietGhe_Dao;
import Dao.Ghe_Dao;
import Dao.KhachHang_Dao;
import Entity.ChiTietGhe;
import Entity.ChiTietXuatChieu;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Admin
 */
public class ChonGhe_Gui extends javax.swing.JFrame implements ActionListener, DocumentListener {
	private static int SoLuongGheDaChon = 0;
	private static double TongTienVe = 0;

	private ArrayList<ChiTietGhe> listCTGhe = new ArrayList<ChiTietGhe>();
	private ArrayList<ChiTietGhe> listCTGheTheoPhong = new ArrayList<ChiTietGhe>();
	private ChiTietGhe_Dao ctGhe_dao = new ChiTietGhe_Dao();

	private ArrayList<Ghe> listGhe = new ArrayList<Ghe>();
	private Ghe_Dao ghe_dao = new Ghe_Dao();

	private ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
	private KhachHang_Dao khachHang_dao = new KhachHang_Dao();

	private ArrayList<JButton> listButton = new ArrayList<JButton>();

	/**
	 * Creates new form ChonGhe
	 * 
	 * @throws SQLException
	 */

	public ChonGhe_Gui(ChiTietXuatChieu CTXC) throws SQLException {
		ConnectDB.Connect();
		initComponents(CTXC);

		try {
			listGhe = ghe_dao.printAll();
			listCTGhe = ctGhe_dao.printAll();
			listKH = khachHang_dao.printAll();
//			 DocDuLieuCTGheLenFrame();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		docDuLieuGheTheoPhongXClenFrame(CTXC);
		DocDuLieuCTGheLenFrame();

		listButton.forEach((element) -> {

			element.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				int click = 0;

				@Override
				public void mousePressed(MouseEvent e) {
					if (click % 2 == 0) {
						element.setBackground(new java.awt.Color(223, 13, 13));
						SoLuongGheDaChon++;
						for (Ghe ghe : listGhe) {
							if (ghe.getMaGhe().equals(element.getName())) {
								TongTienVe = TongTienVe + ghe.getDonGia();
							}
						}

					}

					else {

						if (element.getName().charAt(0) == 'A' || element.getName().charAt(0) == 'B') {
							element.setBackground(new java.awt.Color(192, 119, 180));

						} else if (element.getName().charAt(0) == 'G' || element.getName().charAt(0) == 'H') {
							element.setBackground(new java.awt.Color(255, 51, 153));
						} else {
							element.setBackground(new java.awt.Color(255, 169, 89));
						}

						SoLuongGheDaChon--;
						for (Ghe ghe : listGhe) {
							if (ghe.getMaGhe().equals(element.getName())) {
								TongTienVe = TongTienVe - ghe.getDonGia();
							}
						}

					}

					click++;
					TxtTongTienVe.setText(Double.toString(TongTienVe));
					TxtSoLuong.setText(Integer.toString(SoLuongGheDaChon));
					TxtDiemCongThem.setText(Integer.toString(10 * SoLuongGheDaChon));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		});

		setLocationRelativeTo(null);
	}

	public void DocDuLieuCTGheLenFrame() {
		for (Ghe ghe : listGhe) {
			for (ChiTietGhe ct : listCTGheTheoPhong) {

				if (ghe.getMaGhe().equals(ct.getGhe().getMaGhe())) {
					for (JButton btn : listButton) {
						if (ghe.getMaGhe().equals(btn.getName())) {
							btn.setEnabled(false);
							btn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
							btn.setText("X");

						}

					}
				}
			}
		}
	}

	public void docDuLieuGheTheoPhongXClenFrame(ChiTietXuatChieu CTXC) {
		for (ChiTietGhe ctg : listCTGhe) {
			if (CTXC.getMaCTXC().equals(ctg.getCTXC().getMaCTXC())) {
				listCTGheTheoPhong.add(ctg);

			}
		}
	}
	
	
	public void TinhGiamGia(int diem) {
		if(diem > 0) {
			TxtSoTienGiam.addItem(0);
		}
		
		if(diem >= 100) {
			TxtSoTienGiam.addItem(100);
		}
		
		if(diem >= 200) {
			TxtSoTienGiam.addItem(200);
		}
		
		if(diem >= 500) {
			TxtSoTienGiam.addItem(500);
		}
		
		if(diem >= 1000) {
			TxtSoTienGiam.addItem(1000);
		}
		
		if(diem >= 2000) {
			TxtSoTienGiam.addItem(2000);
		}
		
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents(ChiTietXuatChieu CTXC) {

		jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

		Ghe = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		A1 = new javax.swing.JButton();
		A2 = new javax.swing.JButton();
		A3 = new javax.swing.JButton();
		A4 = new javax.swing.JButton();
		A5 = new javax.swing.JButton();
		A6 = new javax.swing.JButton();
		A7 = new javax.swing.JButton();
		A8 = new javax.swing.JButton();
		A10 = new javax.swing.JButton();
		A11 = new javax.swing.JButton();
		A12 = new javax.swing.JButton();
		A9 = new javax.swing.JButton();
		A13 = new javax.swing.JButton();
		B6 = new javax.swing.JButton();
		B7 = new javax.swing.JButton();
		B8 = new javax.swing.JButton();
		B10 = new javax.swing.JButton();
		B11 = new javax.swing.JButton();
		B12 = new javax.swing.JButton();
		B1 = new javax.swing.JButton();
		B9 = new javax.swing.JButton();
		B2 = new javax.swing.JButton();
		B3 = new javax.swing.JButton();
		B13 = new javax.swing.JButton();
		B4 = new javax.swing.JButton();
		B5 = new javax.swing.JButton();
		C1 = new javax.swing.JButton();
		C2 = new javax.swing.JButton();
		C3 = new javax.swing.JButton();
		C4 = new javax.swing.JButton();
		D1 = new javax.swing.JButton();
		D2 = new javax.swing.JButton();
		D3 = new javax.swing.JButton();
		D4 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		C5 = new javax.swing.JButton();
		C6 = new javax.swing.JButton();
		C7 = new javax.swing.JButton();
		C8 = new javax.swing.JButton();
		D5 = new javax.swing.JButton();
		D6 = new javax.swing.JButton();
		D7 = new javax.swing.JButton();
		D8 = new javax.swing.JButton();
		D9 = new javax.swing.JButton();
		C9 = new javax.swing.JButton();
		C10 = new javax.swing.JButton();
		C11 = new javax.swing.JButton();
		C12 = new javax.swing.JButton();
		C13 = new javax.swing.JButton();
		D10 = new javax.swing.JButton();
		D11 = new javax.swing.JButton();
		D12 = new javax.swing.JButton();
		D13 = new javax.swing.JButton();
		E1 = new javax.swing.JButton();
		E2 = new javax.swing.JButton();
		E3 = new javax.swing.JButton();
		E4 = new javax.swing.JButton();
		E5 = new javax.swing.JButton();
		E6 = new javax.swing.JButton();
		E7 = new javax.swing.JButton();
		E8 = new javax.swing.JButton();
		E9 = new javax.swing.JButton();
		E10 = new javax.swing.JButton();
		E11 = new javax.swing.JButton();
		E12 = new javax.swing.JButton();
		E13 = new javax.swing.JButton();
		F1 = new javax.swing.JButton();
		F2 = new javax.swing.JButton();
		F3 = new javax.swing.JButton();
		F4 = new javax.swing.JButton();
		F5 = new javax.swing.JButton();
		F6 = new javax.swing.JButton();
		F7 = new javax.swing.JButton();
		F8 = new javax.swing.JButton();
		F9 = new javax.swing.JButton();
		F10 = new javax.swing.JButton();
		F11 = new javax.swing.JButton();
		F12 = new javax.swing.JButton();
		F13 = new javax.swing.JButton();
		G1G2 = new javax.swing.JButton();
		G3G4 = new javax.swing.JButton();
		G5G6 = new javax.swing.JButton();
		G7G8 = new javax.swing.JButton();
		G9G10 = new javax.swing.JButton();
		G11G12 = new javax.swing.JButton();
		H1H2 = new javax.swing.JButton();
		H3H4 = new javax.swing.JButton();
		H5H6 = new javax.swing.JButton();
		H7H8 = new javax.swing.JButton();
		H9H10 = new javax.swing.JButton();
		H11H12 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel13 = new javax.swing.JLabel();
		jButton3 = new javax.swing.JButton();
		jLabel14 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jButton5 = new javax.swing.JButton();
		jLabel17 = new javax.swing.JLabel();
		jButton6 = new javax.swing.JButton();
		jPanel8 = new javax.swing.JPanel();
		jLabel18 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		TxtSoLuong = new javax.swing.JTextField();
		jButton8 = new javax.swing.JButton();
		jLabel19 = new javax.swing.JLabel();
		jButton9 = new javax.swing.JButton();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jButton7 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		check_KHThanhVien = new javax.swing.JCheckBox();
		TxtSDT = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		TxtTenKH = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		TxtDiemTichLuy = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		TxtDiemCongThem = new javax.swing.JTextField();
		jPanel7 = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		TxtTongTienVe = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		TxtSoTienGiam = new JComboBox<Integer>();
		TxtTongTien = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		btn_Back = new javax.swing.JButton();

		jCheckBoxMenuItem1.setSelected(true);
		jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		Ghe.setPreferredSize(new java.awt.Dimension(1020, 679));

		jPanel2.setBackground(new java.awt.Color(255, 193, 234));
		jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		jPanel2.setPreferredSize(new java.awt.Dimension(740, 60));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(206, 21, 154));
		jLabel1.setText("Màn Chiếu");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(295, 295, 295).addComponent(jLabel1)
						.addContainerGap(348, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
								.addContainerGap()));

		A1.setName("A1");
		A2.setName("A2");
		A3.setName("A3");
		A4.setName("A4");
		A5.setName("A5");
		A6.setName("A6");
		A7.setName("A7");
		A8.setName("A8");
		A9.setName("A9");
		A10.setName("A10");
		A11.setName("A11");
		A12.setName("A12");
		A13.setName("A13");

		B1.setName("B1");
		B2.setName("B2");
		B3.setName("B3");
		B4.setName("B4");
		B5.setName("B5");
		B6.setName("B6");
		B7.setName("B7");
		B8.setName("B8");
		B9.setName("B9");
		B10.setName("B10");
		B11.setName("B11");
		B12.setName("B12");
		B13.setName("B13");

		C1.setName("C1");
		C2.setName("C2");
		C3.setName("C3");
		C4.setName("C4");
		C5.setName("C5");
		C6.setName("C6");
		C7.setName("C7");
		C8.setName("C8");
		C9.setName("C9");
		C10.setName("C10");
		C11.setName("C11");
		C12.setName("C12");
		C13.setName("C13");

		D1.setName("D1");
		D2.setName("D2");
		D3.setName("D3");
		D4.setName("D4");
		D5.setName("D5");
		D6.setName("D6");
		D7.setName("D7");
		D8.setName("D8");
		D9.setName("D9");
		D10.setName("D10");
		D11.setName("D11");
		D12.setName("D12");
		D13.setName("D13");

		E1.setName("E1");
		E2.setName("E2");
		E3.setName("E3");
		E4.setName("E4");
		E5.setName("E5");
		E6.setName("E6");
		E7.setName("E7");
		E8.setName("E8");
		E9.setName("E9");
		E10.setName("E10");
		E11.setName("E11");
		E12.setName("E12");
		E13.setName("E13");

		F1.setName("F1");
		F2.setName("F2");
		F3.setName("F3");
		F4.setName("F4");
		F5.setName("F5");
		F6.setName("F6");
		F7.setName("F7");
		F8.setName("F8");
		F9.setName("F9");
		F10.setName("F10");
		F11.setName("F11");
		F12.setName("F12");
		F13.setName("F13");

		G1G2.setName("G1G2");
		G3G4.setName("G3G4");
		G5G6.setName("G5G6");
		G7G8.setName("G7G8");
		G9G10.setName("G9G10");
		G11G12.setName("G11G12");
		H1H2.setName("H1H2");
		H3H4.setName("H3H4");
		H5H6.setName("H5H6");
		H7H8.setName("H7H8");
		H9H10.setName("H9H10");
		H11H12.setName("H11H12");

		listButton.add(A1);
		listButton.add(A2);
		listButton.add(A3);
		listButton.add(A4);
		listButton.add(A5);
		listButton.add(A6);
		listButton.add(A7);
		listButton.add(A8);
		listButton.add(A9);
		listButton.add(A10);
		listButton.add(A11);
		listButton.add(A12);
		listButton.add(A13);

		listButton.add(B1);
		listButton.add(B2);
		listButton.add(B3);
		listButton.add(B4);
		listButton.add(B5);
		listButton.add(B6);
		listButton.add(B7);
		listButton.add(B8);
		listButton.add(B9);
		listButton.add(B10);
		listButton.add(B11);
		listButton.add(B12);
		listButton.add(B13);

		listButton.add(C1);
		listButton.add(C2);
		listButton.add(C3);
		listButton.add(C4);
		listButton.add(C5);
		listButton.add(C6);
		listButton.add(C7);
		listButton.add(C8);
		listButton.add(C9);
		listButton.add(C10);
		listButton.add(C11);
		listButton.add(C12);
		listButton.add(C13);

		listButton.add(D1);
		listButton.add(D2);
		listButton.add(D3);
		listButton.add(D4);
		listButton.add(D5);
		listButton.add(D6);
		listButton.add(D7);
		listButton.add(D8);
		listButton.add(D9);
		listButton.add(D10);
		listButton.add(D11);
		listButton.add(D12);
		listButton.add(D13);

		listButton.add(E1);
		listButton.add(E2);
		listButton.add(E3);
		listButton.add(E4);
		listButton.add(E5);
		listButton.add(E6);
		listButton.add(E7);
		listButton.add(E8);
		listButton.add(E9);
		listButton.add(E10);
		listButton.add(E11);
		listButton.add(E12);
		listButton.add(E13);

		listButton.add(F1);
		listButton.add(F2);
		listButton.add(F3);
		listButton.add(F4);
		listButton.add(F5);
		listButton.add(F6);
		listButton.add(F7);
		listButton.add(F8);
		listButton.add(F9);
		listButton.add(F10);
		listButton.add(F11);
		listButton.add(F12);
		listButton.add(F13);

		listButton.add(G1G2);
		listButton.add(G3G4);
		listButton.add(G5G6);
		listButton.add(G7G8);
		listButton.add(G9G10);
		listButton.add(G11G12);

		listButton.add(H1H2);
		listButton.add(H3H4);
		listButton.add(H5H6);
		listButton.add(H7H8);
		listButton.add(H9H10);
		listButton.add(H11H12);

		TxtDiemCongThem.setEnabled(false);
		TxtDiemTichLuy.setEnabled(false);

		A1.setBackground(new java.awt.Color(192, 119, 180));
		A1.setText("A1");
		A1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A1ActionPerformed(evt);
			}
		});

		A2.setBackground(new java.awt.Color(192, 119, 180));
		A2.setText("A2");
		A2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A2ActionPerformed(evt);
			}
		});

		A3.setBackground(new java.awt.Color(192, 119, 180));
		A3.setText("A3");
		A3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A3ActionPerformed(evt);
			}
		});

		A4.setBackground(new java.awt.Color(192, 119, 180));
		A4.setText("A4");
		A4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A4ActionPerformed(evt);
			}
		});

		A5.setBackground(new java.awt.Color(192, 119, 180));
		A5.setText("A5");
		A5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A5ActionPerformed(evt);
			}
		});

		A6.setBackground(new java.awt.Color(192, 119, 180));
		A6.setText("A6");
		A6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A6ActionPerformed(evt);
			}
		});

		A7.setBackground(new java.awt.Color(192, 119, 180));
		A7.setText("A7");
		A7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A7ActionPerformed(evt);
			}
		});

		A8.setBackground(new java.awt.Color(192, 119, 180));
		A8.setText("A8");
		A8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A8ActionPerformed(evt);
			}
		});

		A10.setBackground(new java.awt.Color(192, 119, 180));
		A10.setText("A10");
		A10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A10ActionPerformed(evt);
			}
		});

		A11.setBackground(new java.awt.Color(192, 119, 180));
		A11.setText("A11");
		A11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A11ActionPerformed(evt);
			}
		});

		A12.setBackground(new java.awt.Color(192, 119, 180));
		A12.setText("A12");
		A12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A12ActionPerformed(evt);
			}
		});

		A9.setBackground(new java.awt.Color(192, 119, 180));
		A9.setText("A9");
		A9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A9ActionPerformed(evt);
			}
		});

		A13.setBackground(new java.awt.Color(192, 119, 180));
		A13.setText("A13");
		A13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				A13ActionPerformed(evt);
			}
		});

		B6.setBackground(new java.awt.Color(192, 119, 180));
		B6.setText("B6");
		B6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B6ActionPerformed(evt);
			}
		});

		B7.setBackground(new java.awt.Color(192, 119, 180));
		B7.setText("B7");
		B7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B7ActionPerformed(evt);
			}
		});

		B8.setBackground(new java.awt.Color(192, 119, 180));
		B8.setText("B8");
		B8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B8ActionPerformed(evt);
			}
		});

		B10.setBackground(new java.awt.Color(192, 119, 180));
		B10.setText("B10");
		B10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B10ActionPerformed(evt);
			}
		});

		B11.setBackground(new java.awt.Color(192, 119, 180));
		B11.setText("B11");
		B11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B11ActionPerformed(evt);
			}
		});

		B12.setBackground(new java.awt.Color(192, 119, 180));
		B12.setText("B12");
		B12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B12ActionPerformed(evt);
			}
		});

		B1.setBackground(new java.awt.Color(192, 119, 180));
		B1.setText("B1");
		B1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B1ActionPerformed(evt);
			}
		});

		B9.setBackground(new java.awt.Color(192, 119, 180));
		B9.setText("B9");
		B9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B9ActionPerformed(evt);
			}
		});

		B2.setBackground(new java.awt.Color(192, 119, 180));
		B2.setText("B2");
		B2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B2ActionPerformed(evt);
			}
		});

		B3.setBackground(new java.awt.Color(192, 119, 180));
		B3.setText("B3");
		B3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B3ActionPerformed(evt);
			}
		});

		B13.setBackground(new java.awt.Color(192, 119, 180));
		B13.setText("B13");
		B13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B13ActionPerformed(evt);
			}
		});

		B4.setBackground(new java.awt.Color(192, 119, 180));
		B4.setText("B4");
		B4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B4ActionPerformed(evt);
			}
		});

		B5.setBackground(new java.awt.Color(192, 119, 180));
		B5.setText("B5");
		B5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				B5ActionPerformed(evt);
			}
		});

		C1.setBackground(new java.awt.Color(255, 169, 89));
		C1.setText("C1");
		C1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C1ActionPerformed(evt);
			}
		});

		C2.setBackground(new java.awt.Color(255, 169, 89));
		C2.setText("C2");
		C2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C2ActionPerformed(evt);
			}
		});

		C3.setBackground(new java.awt.Color(255, 169, 89));
		C3.setText("C3");
		C3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C3ActionPerformed(evt);
			}
		});

		C4.setBackground(new java.awt.Color(255, 169, 89));
		C4.setText("C4");
		C4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C4ActionPerformed(evt);
			}
		});

		D1.setBackground(new java.awt.Color(255, 169, 89));
		D1.setText("D1");
		D1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D1ActionPerformed(evt);
			}
		});

		D2.setBackground(new java.awt.Color(255, 169, 89));
		D2.setText("D2");
		D2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D2ActionPerformed(evt);
			}
		});

		D3.setBackground(new java.awt.Color(255, 169, 89));
		D3.setText("D3");
		D3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D3ActionPerformed(evt);
			}
		});

		D4.setBackground(new java.awt.Color(255, 169, 89));
		D4.setText("D4");
		D4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D4ActionPerformed(evt);
			}
		});

		jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 1, true));
		jPanel3.setPreferredSize(new java.awt.Dimension(264, 75));

		C5.setBackground(new java.awt.Color(255, 169, 89));
		C5.setText("C5");
		C5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C5ActionPerformed(evt);
			}
		});

		C6.setBackground(new java.awt.Color(255, 169, 89));
		C6.setText("C6");
		C6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C6ActionPerformed(evt);
			}
		});

		C7.setBackground(new java.awt.Color(255, 169, 89));
		C7.setText("C7");
		C7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C7ActionPerformed(evt);
			}
		});

		C8.setBackground(new java.awt.Color(255, 169, 89));
		C8.setText("C8");
		C8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C8ActionPerformed(evt);
			}
		});

		D5.setBackground(new java.awt.Color(255, 169, 89));
		D5.setText("D5");
		D5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D5ActionPerformed(evt);
			}
		});

		D6.setBackground(new java.awt.Color(255, 169, 89));
		D6.setText("D6");
		D6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D6ActionPerformed(evt);
			}
		});

		D7.setBackground(new java.awt.Color(255, 169, 89));
		D7.setText("D7");
		D7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D7ActionPerformed(evt);
			}
		});

		D8.setBackground(new java.awt.Color(255, 169, 89));
		D8.setText("D8");
		D8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D8ActionPerformed(evt);
			}
		});

		D9.setBackground(new java.awt.Color(255, 169, 89));
		D9.setText("D9");
		D9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D9ActionPerformed(evt);
			}
		});

		C9.setBackground(new java.awt.Color(255, 169, 89));
		C9.setText("C9");
		C9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C9ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout
						.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel3Layout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10).addComponent(C9, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10).addComponent(D9, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)))));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(9, 9, 9)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(C5).addComponent(C6).addComponent(C7).addComponent(C8).addComponent(C9))
						.addGap(17, 17, 17)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(D5).addComponent(D6).addComponent(D7).addComponent(D8).addComponent(D9))
						.addContainerGap(20, Short.MAX_VALUE)));

		C10.setBackground(new java.awt.Color(255, 169, 89));
		C10.setText("C10");
		C10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C10ActionPerformed(evt);
			}
		});

		C11.setBackground(new java.awt.Color(255, 169, 89));
		C11.setText("C11");
		C11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C11ActionPerformed(evt);
			}
		});

		C12.setBackground(new java.awt.Color(255, 169, 89));
		C12.setText("C12");
		C12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C12ActionPerformed(evt);
			}
		});

		C13.setBackground(new java.awt.Color(255, 169, 89));
		C13.setText("C13");
		C13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				C13ActionPerformed(evt);
			}
		});

		D10.setBackground(new java.awt.Color(255, 169, 89));
		D10.setText("D10");
		D10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D10ActionPerformed(evt);
			}
		});

		D11.setBackground(new java.awt.Color(255, 169, 89));
		D11.setText("D11");
		D11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D11ActionPerformed(evt);
			}
		});

		D12.setBackground(new java.awt.Color(255, 169, 89));
		D12.setText("D12");
		D12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D12ActionPerformed(evt);
			}
		});

		D13.setBackground(new java.awt.Color(255, 169, 89));
		D13.setText("D13");
		D13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				D13ActionPerformed(evt);
			}
		});

		E1.setBackground(new java.awt.Color(255, 169, 89));
		E1.setText("E1");
		E1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E1ActionPerformed(evt);
			}
		});

		E2.setBackground(new java.awt.Color(255, 169, 89));
		E2.setText("E2");
		E2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E2ActionPerformed(evt);
			}
		});

		E3.setBackground(new java.awt.Color(255, 169, 89));
		E3.setText("E3");
		E3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E3ActionPerformed(evt);
			}
		});

		E4.setBackground(new java.awt.Color(255, 169, 89));
		E4.setText("E4");
		E4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E4ActionPerformed(evt);
			}
		});

		E5.setBackground(new java.awt.Color(255, 169, 89));
		E5.setText("E5");
		E5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E5ActionPerformed(evt);
			}
		});

		E6.setBackground(new java.awt.Color(255, 169, 89));
		E6.setText("E6");
		E6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E6ActionPerformed(evt);
			}
		});

		E7.setBackground(new java.awt.Color(255, 169, 89));
		E7.setText("E7");
		E7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E7ActionPerformed(evt);
			}
		});

		E8.setBackground(new java.awt.Color(255, 169, 89));
		E8.setText("E8");
		E8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E8ActionPerformed(evt);
			}
		});

		E9.setBackground(new java.awt.Color(255, 169, 89));
		E9.setText("E9");
		E9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E9ActionPerformed(evt);
			}
		});

		E10.setBackground(new java.awt.Color(255, 169, 89));
		E10.setText("E10");
		E10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E10ActionPerformed(evt);
			}
		});

		E11.setBackground(new java.awt.Color(255, 169, 89));
		E11.setText("E11");
		E11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E11ActionPerformed(evt);
			}
		});

		E12.setBackground(new java.awt.Color(255, 169, 89));
		E12.setText("E12");
		E12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E12ActionPerformed(evt);
			}
		});

		E13.setBackground(new java.awt.Color(255, 169, 89));
		E13.setText("E13");
		E13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				E13ActionPerformed(evt);
			}
		});

		F1.setBackground(new java.awt.Color(255, 169, 89));
		F1.setText("F1");
		F1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F1ActionPerformed(evt);
			}
		});

		F2.setBackground(new java.awt.Color(255, 169, 89));
		F2.setText("F2");
		F2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F2ActionPerformed(evt);
			}
		});

		F3.setBackground(new java.awt.Color(255, 169, 89));
		F3.setText("F3");
		F3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F3ActionPerformed(evt);
			}
		});

		F4.setBackground(new java.awt.Color(255, 169, 89));
		F4.setText("F4");
		F4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F4ActionPerformed(evt);
			}
		});

		F5.setBackground(new java.awt.Color(255, 169, 89));
		F5.setText("F5");
		F5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F5ActionPerformed(evt);
			}
		});

		F6.setBackground(new java.awt.Color(255, 169, 89));
		F6.setText("F6");
		F6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F6ActionPerformed(evt);
			}
		});

		F7.setBackground(new java.awt.Color(255, 169, 89));
		F7.setText("F7");
		F7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F7ActionPerformed(evt);
			}
		});

		F8.setBackground(new java.awt.Color(255, 169, 89));
		F8.setText("F8");
		F8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F8ActionPerformed(evt);
			}
		});

		F9.setBackground(new java.awt.Color(255, 169, 89));
		F9.setText("F9");
		F9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F9ActionPerformed(evt);
			}
		});

		F10.setBackground(new java.awt.Color(255, 169, 89));
		F10.setText("F10");
		F10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F10ActionPerformed(evt);
			}
		});

		F11.setBackground(new java.awt.Color(255, 169, 89));
		F11.setText("F11");
		F11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F11ActionPerformed(evt);
			}
		});

		F12.setBackground(new java.awt.Color(255, 169, 89));
		F12.setText("F12");
		F12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F12ActionPerformed(evt);
			}
		});

		F13.setBackground(new java.awt.Color(255, 169, 89));
		F13.setText("F13");
		F13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				F13ActionPerformed(evt);
			}
		});

		G1G2.setBackground(new java.awt.Color(255, 51, 153));
		G1G2.setText("G1  |  G2");
		G1G2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				G1G2ActionPerformed(evt);
			}
		});

		G3G4.setBackground(new java.awt.Color(255, 51, 153));
		G3G4.setText("G3  |  G4");
		G3G4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				G3G4ActionPerformed(evt);
			}
		});

		G5G6.setBackground(new java.awt.Color(255, 51, 153));
		G5G6.setText("G5  |  G6");
		G5G6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				G5G6ActionPerformed(evt);
			}
		});

		G7G8.setBackground(new java.awt.Color(255, 51, 153));
		G7G8.setText("G7  |  G8");
		G7G8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				G7G8ActionPerformed(evt);
			}
		});

		G9G10.setBackground(new java.awt.Color(255, 51, 153));
		G9G10.setText("G9  |  G10");
		G9G10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				G9G10ActionPerformed(evt);
			}
		});

		G11G12.setBackground(new java.awt.Color(255, 51, 153));
		G11G12.setText("G11  |  G12");
		G11G12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				G11G12ActionPerformed(evt);
			}
		});

		H1H2.setBackground(new java.awt.Color(255, 51, 153));
		H1H2.setText("H1  |  H2");
		H1H2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				H1H2ActionPerformed(evt);
			}
		});

		H3H4.setBackground(new java.awt.Color(255, 51, 153));
		H3H4.setText("H3  |  H4");
		H3H4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				H3H4ActionPerformed(evt);
			}
		});

		H5H6.setBackground(new java.awt.Color(255, 51, 153));
		H5H6.setText("H5  |  H6");
		H5H6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				H5H6ActionPerformed(evt);
			}
		});

		H7H8.setBackground(new java.awt.Color(255, 51, 153));
		H7H8.setText("H7  | H8");
		H7H8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				H7H8ActionPerformed(evt);
			}
		});

		H9H10.setBackground(new java.awt.Color(255, 51, 153));
		H9H10.setText("H9  |  H10");
		H9H10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				H9H10ActionPerformed(evt);
			}
		});

		H11H12.setBackground(new java.awt.Color(255, 51, 153));
		H11H12.setText("H11  |  H12");
		H11H12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				H11H12ActionPerformed(evt);
			}
		});

		jButton2.setBackground(new java.awt.Color(255, 169, 89));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel13.setText("Ghế Vip");

		jButton3.setBackground(new java.awt.Color(255, 51, 153));
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel14.setText("Ghế Đôi");

		jButton4.setBackground(new java.awt.Color(192, 119, 180));
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jLabel15.setText("Ghế Thường");

		jLabel16.setText("Ghế bạn chọn");

		jButton5.setBackground(new java.awt.Color(223, 13, 13));
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jLabel17.setText("Ghế đã đặt");

		jButton6.setBackground(new java.awt.Color(204, 204, 204));
		jButton6.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
		jButton6.setForeground(new java.awt.Color(102, 102, 102));
		jButton6.setText("X");
		jButton6.setEnabled(false);
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		TxtDiemCongThem.setText("0");

		jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

		jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource(CTXC.getPhim().getHinhAnh().getUrl()))); // NOI18N

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addComponent(jLabel18).addGap(0, 0, Short.MAX_VALUE)));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addComponent(jLabel18).addGap(0, 0, Short.MAX_VALUE)));

		javax.swing.GroupLayout GheLayout = new javax.swing.GroupLayout(Ghe);
		Ghe.setLayout(GheLayout);
		GheLayout.setHorizontalGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(GheLayout.createSequentialGroup().addContainerGap().addGroup(GheLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(GheLayout.createSequentialGroup().addGroup(GheLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(GheLayout.createSequentialGroup()
										.addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(GheLayout.createSequentialGroup()
										.addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addGroup(GheLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
										.addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(GheLayout.createSequentialGroup()
												.addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(12, 12, 12)
												.addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(A9,
														javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(GheLayout.createSequentialGroup()
												.addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(B9,
														javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(GheLayout.createSequentialGroup()
												.addComponent(B10, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(B11, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(B12, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(B13, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(GheLayout.createSequentialGroup()
												.addComponent(A10, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(A11, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(A12, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(A13, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(GheLayout.createSequentialGroup().addGroup(GheLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										GheLayout.createSequentialGroup()
												.addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(GheLayout.createSequentialGroup()
										.addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 298,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(GheLayout.createSequentialGroup()
												.addComponent(C10, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(C11, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(C12, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(C13, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(GheLayout.createSequentialGroup()
												.addComponent(D10, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(D11, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(D12, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(D13, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 766,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(GheLayout.createSequentialGroup()
								.addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(E8, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(E9, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(14, 14, 14)
								.addComponent(E10, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(12, 12, 12)
								.addComponent(E11, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(E12, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(E13,
										javax.swing.GroupLayout.PREFERRED_SIZE, 52,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(GheLayout.createSequentialGroup().addGroup(GheLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(GheLayout.createSequentialGroup().addGroup(GheLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(GheLayout.createSequentialGroup()
												.addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(GheLayout.createSequentialGroup().addGap(31, 31, 31)
												.addComponent(G1G2, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(G3G4, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(G5G6,
														javax.swing.GroupLayout.PREFERRED_SIZE, 85,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(F9, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(14, 14, 14)
										.addComponent(F10, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(GheLayout.createSequentialGroup().addGap(12, 12, 12)
														.addComponent(F11, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(F12, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(GheLayout.createSequentialGroup().addGap(37, 37, 37)
														.addComponent(G11G12))))
								.addGroup(GheLayout.createSequentialGroup().addGap(31, 31, 31).addGroup(GheLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(GheLayout.createSequentialGroup().addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(GheLayout.createSequentialGroup().addGap(321, 321, 321)
														.addComponent(H7H8, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(118, 118, 118))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GheLayout
														.createSequentialGroup()
														.addComponent(H1H2, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(H3H4, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(H5H6, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(H9H10)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(H11H12))
										.addGroup(GheLayout.createSequentialGroup().addGap(324, 324, 324)
												.addComponent(G7G8, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(32, 32, 32).addComponent(G9G10)
												.addGap(0, 0, Short.MAX_VALUE)))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(F13,
										javax.swing.GroupLayout.PREFERRED_SIZE, 52,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(57, 57, 57)
						.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(GheLayout.createSequentialGroup().addGroup(GheLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)
										.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)
										.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)
										.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)
										.addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 33,
												Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(GheLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(GheLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel17,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				91,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(jLabel16,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				91,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addComponent(jLabel14,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 91,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel13,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 91,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 91,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(36, Short.MAX_VALUE)));
		GheLayout.setVerticalGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(GheLayout.createSequentialGroup().addGap(55, 55, 55).addGroup(GheLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addGroup(GheLayout.createSequentialGroup()
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(38, 38, 38)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(A1).addComponent(A2).addComponent(A3).addComponent(A4)
										.addComponent(A5).addComponent(A6).addComponent(A7).addComponent(A8)
										.addComponent(A9).addComponent(A10).addComponent(A11).addComponent(A12)
										.addComponent(A13))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(B1).addComponent(B2).addComponent(B3).addComponent(B4)
										.addComponent(B5).addComponent(B6).addComponent(B7).addComponent(B8)
										.addComponent(B9).addComponent(B10).addComponent(B11).addComponent(B12)
										.addComponent(B13))
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(GheLayout.createSequentialGroup().addGap(18, 18, 18)
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(GheLayout.createSequentialGroup()
																.addGroup(GheLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(C1).addComponent(C2)
																		.addComponent(C3).addComponent(C4))
																.addGap(18, 18, 18)
																.addGroup(GheLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(D1,
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addGroup(GheLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(D2).addComponent(D3)
																				.addComponent(D4))))
														.addGroup(GheLayout.createSequentialGroup()
																.addGroup(GheLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(C10).addComponent(C11)
																		.addComponent(C12).addComponent(C13))
																.addGap(18, 18, 18)
																.addGroup(GheLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(D10).addComponent(D11)
																		.addComponent(D12).addComponent(D13)))))
										.addGroup(GheLayout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(E1, javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(E5, javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(E9, javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(GheLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(E10).addComponent(E11).addComponent(E12)
																.addComponent(E13)))
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(E6).addComponent(E7).addComponent(E8)))
										.addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(E2).addComponent(E3).addComponent(E4)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(F1, javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(F5, javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(F9, javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(GheLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(F11).addComponent(F12).addComponent(F13)
																.addComponent(F10)))
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(F6).addComponent(F7).addComponent(F8)))
										.addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(F2).addComponent(F3).addComponent(F4)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(GheLayout.createSequentialGroup().addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(G11G12, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(G1G2, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(G3G4, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(G5G6, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(18, 18, 18)
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(H9H10, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(GheLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(H1H2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(H3H4,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(H5H6,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(H7H8,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(H11H12,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(G9G10, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(G7G8, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(GheLayout.createSequentialGroup()
								.addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(GheLayout.createSequentialGroup().addGroup(GheLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(GheLayout.createSequentialGroup().addGap(35, 35, 35)
														.addGroup(GheLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel13,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(GheLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE,
																23, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
																23, javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(GheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(36, Short.MAX_VALUE)));

		jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		jPanel4.setPreferredSize(new java.awt.Dimension(341, 224));

		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel2.setText("Ghế:");

		jLabel3.setText("Số lượng:");

		TxtSoLuong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TxtSoLuongActionPerformed(evt);
			}
		});

		jButton8.setBackground(new java.awt.Color(255, 169, 89));
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		jCheckBoxMenuItem1.addActionListener(this);
		jLabel19.setText("65.000 VND");

		jButton9.setBackground(new java.awt.Color(255, 51, 153));
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		jLabel20.setText("80.000 VND");

		jLabel21.setText("150.000 VND");

		jButton7.setBackground(new java.awt.Color(192, 119, 180));
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton10.setBackground(new java.awt.Color(192, 119, 180));
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		jButton11.setBackground(new java.awt.Color(255, 51, 153));
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});

		jButton12.setBackground(new java.awt.Color(255, 169, 89));
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2))
						.addGroup(jPanel4Layout.createSequentialGroup().addGap(36, 36, 36)
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
														Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE,
																91, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE,
																91, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE,
																91, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(23, 23, 23)
												.addGroup(jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE,
																0, Short.MAX_VALUE)
														.addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE,
																0, Short.MAX_VALUE)
														.addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE,
																0, Short.MAX_VALUE)))
										.addGroup(jPanel4Layout.createSequentialGroup()
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(TxtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(55, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
						.addGap(0, 11, Short.MAX_VALUE)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel4Layout.createSequentialGroup().addGap(35, 35, 35).addComponent(
												jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 27,
														Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE,
																24, Short.MAX_VALUE))
												.addGap(11, 11, 11)))
										.addGroup(jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 27,
														Short.MAX_VALUE))
										.addGap(21, 21, 21))
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)))
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(TxtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addGap(24, 24, 24)));

		jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		jPanel5.setPreferredSize(new java.awt.Dimension(341, 224));

		jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel5.setText("Thành viên:");

		check_KHThanhVien.setText("Khách hàng thành viên");
		check_KHThanhVien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				check_KHThanhVienActionPerformed(evt);
			}
		});

		TxtSDT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TxtSDTActionPerformed(evt);
			}
		});

		jLabel6.setText("Số Điện Thoại:");

		jLabel7.setText("Tên Khách hàng:");

		TxtTenKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TxtTenKHActionPerformed(evt);
			}
		});

		jLabel8.setText("Điểm tích lũy:");

		TxtDiemTichLuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TxtDiemTichLuyActionPerformed(evt);
			}
		});

		jLabel9.setText("Điểm cộng thêm:");

		TxtDiemCongThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TxtDiemCongThemActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel5Layout
				.createSequentialGroup().addContainerGap()
				.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(TxtDiemCongThem,
										GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(TxtDiemTichLuy,
										GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addComponent(jLabel5)
						.addComponent(check_KHThanhVien, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(TxtTenKH, GroupLayout.PREFERRED_SIZE, 170,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(TxtSDT, GroupLayout.PREFERRED_SIZE, 170,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(55, Short.MAX_VALUE)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel5Layout
				.createSequentialGroup().addContainerGap().addComponent(jLabel5)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(check_KHThanhVien)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel6).addComponent(
						TxtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel7).addComponent(
						TxtTenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(jPanel5Layout
						.createParallelGroup(Alignment.BASELINE).addComponent(jLabel8).addComponent(TxtDiemTichLuy,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel9).addComponent(
						TxtDiemCongThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addContainerGap(56, Short.MAX_VALUE)));
		jPanel5.setLayout(jPanel5Layout);

		jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		jPanel7.setPreferredSize(new java.awt.Dimension(341, 224));

		jLabel10.setText("Tổng tiền vé:");

		TxtTongTienVe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TxtTongTienVeActionPerformed(evt);
			}
		});

		jLabel11.setText("Số tiền giảm:");

		TxtSoTienGiam.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TxtSoTienGiamActionPerformed(evt);
			}
		});

		TxtTongTien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TxtTongTienActionPerformed(evt);
			}
		});

		jLabel12.setText("Tổng tiền:");
		
		TxtSoTienGiam.addItem(0);
		jButton1.setText("Tiếp tục");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(jButton1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
								.addGap(16, 16, 16)
								.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel7Layout.createSequentialGroup()
												.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(TxtTongTienVe, javax.swing.GroupLayout.PREFERRED_SIZE,
														170, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel7Layout.createSequentialGroup()
												.addGroup(jPanel7Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE,
																100, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE,
																100, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel7Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(TxtTongTien,
																javax.swing.GroupLayout.PREFERRED_SIZE, 170,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(TxtSoTienGiam,
																javax.swing.GroupLayout.PREFERRED_SIZE, 170,
																javax.swing.GroupLayout.PREFERRED_SIZE))))))
						.addContainerGap(94, Short.MAX_VALUE)));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup().addGap(27, 27, 27)
						.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel10)
								.addComponent(TxtTongTienVe, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel11)
								.addComponent(TxtSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(TxtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel12))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(jButton1).addGap(20, 20, 20)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
				.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE).addComponent(jPanel7,
						javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207,
						Short.MAX_VALUE));

		btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5418737-200 (1).png"))); // NOI18N
		btn_Back.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_BackActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0).addComponent(Ghe, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(Ghe, javax.swing.GroupLayout.PREFERRED_SIZE, 487,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		TxtDiemCongThem.setVisible(false);
		TxtDiemTichLuy.setVisible(false);
		jLabel8.setVisible(false);
		jLabel9.setVisible(false);
		TxtSoLuong.setEnabled(false);
		TxtSDT.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				KhachHang x = new KhachHang();
				KhachHang y = x;
				System.out.println(x.getMaKhachHang());
				for(int i = 0; i < listKH.size(); i++) {
					if (TxtSDT.getText().trim().equals(listKH.get(i).getMaKhachHang().trim())) {
						x = listKH.get(i);
					}
				}
				System.out.println(x.getTenKhachHang());
				TxtDiemTichLuy.setText(Integer.toString(x.getDiemTichLuy()));
				TxtTenKH.setText(x.getTenKhachHang());
				
				TxtTenKH.setEnabled(false);
				TinhGiamGia(x.getDiemTichLuy());
				
				if(x.equals(y)) {
					TxtTenKH.setEnabled(true);
					TxtTenKH.setText("");
					TxtDiemTichLuy.setText("");
					TxtSoTienGiam.removeAllItems();
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
		
				KhachHang x = new KhachHang();
				KhachHang y = x;
				System.out.println(x.getMaKhachHang());
				for(int i = 0; i < listKH.size(); i++) {
					if (TxtSDT.getText().trim().equals(listKH.get(i).getMaKhachHang().trim())) {
						x = listKH.get(i);
					}
				}
				System.out.println(x.getTenKhachHang());
				TxtDiemTichLuy.setText(Integer.toString(x.getDiemTichLuy()));
				TxtTenKH.setText(x.getTenKhachHang());
				
				TxtTenKH.setEnabled(false);
				TinhGiamGia(x.getDiemTichLuy());
				
				if(x.equals(y)) {
					TxtTenKH.setEnabled(true);
					TxtTenKH.setText("");
					TxtDiemTichLuy.setText("");
					TxtSoTienGiam.removeAllItems();
				}
					

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
		}
		});

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void TxtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtSoLuongActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TxtSoLuongActionPerformed

	int i = 0;

	private void check_KHThanhVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_check_KHThanhVienActionPerformed
		// TODO add your handling code here:
		if (check_KHThanhVien.isSelected()) {
			TxtDiemCongThem.setVisible(true);
			TxtDiemTichLuy.setVisible(true);
			jLabel8.setVisible(true);
			jLabel9.setVisible(true);
		} else {
			jLabel8.setVisible(false);
			jLabel9.setVisible(false);
			TxtDiemCongThem.setVisible(false);
			TxtDiemTichLuy.setVisible(false);
		}

	}// GEN-LAST:event_check_KHThanhVienActionPerformed

	private void TxtSDTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtSDTActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TxtSDTActionPerformed

	private void TxtTenKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtTenKHActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TxtTenKHActionPerformed

	private void TxtDiemTichLuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtDiemTichLuyActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TxtDiemTichLuyActionPerformed

	private void TxtDiemCongThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtDiemCongThemActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TxtDiemCongThemActionPerformed

	private void TxtTongTienVeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtTongTienVeActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TxtTongTienVeActionPerformed

	private void TxtSoTienGiamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtSoTienGiamActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TxtSoTienGiamActionPerformed

	private void TxtTongTienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtTongTienActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TxtTongTienActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton6ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton5ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton2ActionPerformed

	private void H11H12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_H11H12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_H11H12ActionPerformed

	private void H9H10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_H9H10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_H9H10ActionPerformed

	private void H7H8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_H7H8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_H7H8ActionPerformed

	private void H5H6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_H5H6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_H5H6ActionPerformed

	private void H3H4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_H3H4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_H3H4ActionPerformed

	private void H1H2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_H1H2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_H1H2ActionPerformed

	private void G11G12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_G11G12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_G11G12ActionPerformed

	private void G9G10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_G9G10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_G9G10ActionPerformed

	private void G7G8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_G7G8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_G7G8ActionPerformed

	private void G5G6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_G5G6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_G5G6ActionPerformed

	private void G3G4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_G3G4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_G3G4ActionPerformed

	private void G1G2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_G1G2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_G1G2ActionPerformed

	private void F13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F13ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F13ActionPerformed

	private void F12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F12ActionPerformed

	private void F11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F11ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F11ActionPerformed

	private void F10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F10ActionPerformed

	private void F9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F9ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F9ActionPerformed

	private void F8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F8ActionPerformed

	private void F7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F7ActionPerformed

	private void F6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F6ActionPerformed

	private void F5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F5ActionPerformed

	private void F4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F4ActionPerformed

	private void F3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F3ActionPerformed

	private void F2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F2ActionPerformed

	private void F1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_F1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_F1ActionPerformed

	private void E13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E13ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E13ActionPerformed

	private void E12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E12ActionPerformed

	private void E11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E11ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E11ActionPerformed

	private void E10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E10ActionPerformed

	private void E9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E9ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E9ActionPerformed

	private void E8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E8ActionPerformed

	private void E7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E7ActionPerformed

	private void E6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E6ActionPerformed

	private void E5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E5ActionPerformed

	private void E4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E4ActionPerformed

	private void E3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E3ActionPerformed

	private void E2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E2ActionPerformed

	private void E1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_E1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_E1ActionPerformed

	private void D13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D13ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D13ActionPerformed

	private void D12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D12ActionPerformed

	private void D11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D11ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D11ActionPerformed

	private void D10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D10ActionPerformed

	private void C13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C13ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C13ActionPerformed

	private void C12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C12ActionPerformed

	private void C11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C11ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C11ActionPerformed

	private void C10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C10ActionPerformed

	private void C9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C9ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C9ActionPerformed

	private void D9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D9ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D9ActionPerformed

	private void D8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D8ActionPerformed

	private void D7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D7ActionPerformed

	private void D6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D6ActionPerformed

	private void D5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D5ActionPerformed

	private void C8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C8ActionPerformed

	private void C7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C7ActionPerformed

	private void C6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C6ActionPerformed

	private void C5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C5ActionPerformed

	private void D4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D4ActionPerformed

	private void D3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D3ActionPerformed

	private void D2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D2ActionPerformed

	private void D1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_D1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_D1ActionPerformed

	private void C4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C4ActionPerformed

	private void C3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C3ActionPerformed

	private void C2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C2ActionPerformed

	private void C1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_C1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_C1ActionPerformed

	private void B5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B5ActionPerformed

	private void B4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B4ActionPerformed

	private void B13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B13ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B13ActionPerformed

	private void B3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B3ActionPerformed

	private void B2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B2ActionPerformed

	private void B9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B9ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B9ActionPerformed

	private void B1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B1ActionPerformed

	private void B12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B12ActionPerformed

	private void B11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B11ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B11ActionPerformed

	private void B10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B10ActionPerformed

	private void B8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B8ActionPerformed

	private void B7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B7ActionPerformed

	private void B6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_B6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_B6ActionPerformed

	private void A13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A13ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A13ActionPerformed

	private void A9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A9ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A9ActionPerformed

	private void A12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A12ActionPerformed

	private void A11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A11ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A11ActionPerformed

	private void A10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A10ActionPerformed

	private void A8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A8ActionPerformed

	private void A7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A7ActionPerformed

	private void A6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A6ActionPerformed

	private void A5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A5ActionPerformed

	private void A4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A4ActionPerformed

	private void A3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A3ActionPerformed

	private void A2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_A2ActionPerformed

	int a1 = 0;

	private void A1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_A1ActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_A1ActionPerformed

	private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_BackActionPerformed
		// TODO add your handling code here:
		new Phim_Gui().setVisible(true);
		;
		setVisible(false);
	}// GEN-LAST:event_btn_BackActionPerformed

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton7ActionPerformed

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton8ActionPerformed

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton9ActionPerformed

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton10ActionPerformed

	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton11ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton11ActionPerformed

	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton12ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton12ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ChonGhe_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ChonGhe_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ChonGhe_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ChonGhe_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ChonGhe_Gui(new ChiTietXuatChieu(null)).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton A1;
	private javax.swing.JButton A10;
	private javax.swing.JButton A11;
	private javax.swing.JButton A12;
	private javax.swing.JButton A13;
	private javax.swing.JButton A2;
	private javax.swing.JButton A3;
	private javax.swing.JButton A4;
	private javax.swing.JButton A5;
	private javax.swing.JButton A6;
	private javax.swing.JButton A7;
	private javax.swing.JButton A8;
	private javax.swing.JButton A9;
	private javax.swing.JButton B1;
	private javax.swing.JButton B10;
	private javax.swing.JButton B11;
	private javax.swing.JButton B12;
	private javax.swing.JButton B13;
	private javax.swing.JButton B2;
	private javax.swing.JButton B3;
	private javax.swing.JButton B4;
	private javax.swing.JButton B5;
	private javax.swing.JButton B6;
	private javax.swing.JButton B7;
	private javax.swing.JButton B8;
	private javax.swing.JButton B9;
	private javax.swing.JButton C1;
	private javax.swing.JButton C10;
	private javax.swing.JButton C11;
	private javax.swing.JButton C12;
	private javax.swing.JButton C13;
	private javax.swing.JButton C2;
	private javax.swing.JButton C3;
	private javax.swing.JButton C4;
	private javax.swing.JButton C5;
	private javax.swing.JButton C6;
	private javax.swing.JButton C7;
	private javax.swing.JButton C8;
	private javax.swing.JButton C9;
	private javax.swing.JButton D1;
	private javax.swing.JButton D10;
	private javax.swing.JButton D11;
	private javax.swing.JButton D12;
	private javax.swing.JButton D13;
	private javax.swing.JButton D2;
	private javax.swing.JButton D3;
	private javax.swing.JButton D4;
	private javax.swing.JButton D5;
	private javax.swing.JButton D6;
	private javax.swing.JButton D7;
	private javax.swing.JButton D8;
	private javax.swing.JButton D9;
	private javax.swing.JButton E1;
	private javax.swing.JButton E10;
	private javax.swing.JButton E11;
	private javax.swing.JButton E12;
	private javax.swing.JButton E13;
	private javax.swing.JButton E2;
	private javax.swing.JButton E3;
	private javax.swing.JButton E4;
	private javax.swing.JButton E5;
	private javax.swing.JButton E6;
	private javax.swing.JButton E7;
	private javax.swing.JButton E8;
	private javax.swing.JButton E9;
	private javax.swing.JButton F1;
	private javax.swing.JButton F10;
	private javax.swing.JButton F11;
	private javax.swing.JButton F12;
	private javax.swing.JButton F13;
	private javax.swing.JButton F2;
	private javax.swing.JButton F3;
	private javax.swing.JButton F4;
	private javax.swing.JButton F5;
	private javax.swing.JButton F6;
	private javax.swing.JButton F7;
	private javax.swing.JButton F8;
	private javax.swing.JButton F9;
	private javax.swing.JButton G11G12;
	private javax.swing.JButton G1G2;
	private javax.swing.JButton G3G4;
	private javax.swing.JButton G5G6;
	private javax.swing.JButton G7G8;
	private javax.swing.JButton G9G10;
	private javax.swing.JPanel Ghe;
	private javax.swing.JButton H11H12;
	private javax.swing.JButton H1H2;
	private javax.swing.JButton H3H4;
	private javax.swing.JButton H5H6;
	private javax.swing.JButton H7H8;
	private javax.swing.JButton H9H10;
	private javax.swing.JTextField TxtDiemCongThem;
	private javax.swing.JTextField TxtDiemTichLuy;
	private javax.swing.JTextField TxtSDT;
	private javax.swing.JTextField TxtSoLuong;
	private javax.swing.JComboBox<Integer> TxtSoTienGiam;
	private javax.swing.JTextField TxtTenKH;
	private javax.swing.JTextField TxtTongTien;
	private javax.swing.JTextField TxtTongTienVe;
	private javax.swing.JButton btn_Back;
	private javax.swing.JCheckBox check_KHThanhVien;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;

	// End of variables declaration//GEN-END:variables
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (jCheckBoxMenuItem1.isSelected()) {
			TxtDiemCongThem.setVisible(true);
			TxtDiemTichLuy.setVisible(true);
		} else {
			TxtDiemCongThem.setVisible(false);
			TxtDiemTichLuy.setVisible(false);
		}

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

}
