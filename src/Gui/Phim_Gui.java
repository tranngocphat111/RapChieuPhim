/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import ConnectDB.ConnectDB;
import Dao.HinhAnh_Dao;
import Dao.Phim_Dao;
import Entity.HinhAnh;
import Entity.Phim;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyga
 */
public class Phim_Gui extends javax.swing.JFrame {

	private Phim_Dao phim_dao = new Phim_Dao();
	private ArrayList<Phim> listPhim = new ArrayList<Phim>();
	private ArrayList<HinhAnh> listHinh = new ArrayList<HinhAnh>();
	private HinhAnh_Dao hinhAnh_Dao = new HinhAnh_Dao();
	private ArrayList<JPanel> listPane = new ArrayList<JPanel>();
	/**
	 * Creates new form Ophir
	 */
	
	
	public Phim_Gui() {
		try {
			ConnectDB.Connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
		XuatChieuRong_Gui xc = new XuatChieuRong_Gui();
		xc.setVisible(true);
		dtXuatChieu.removeAll();
		dtXuatChieu.add(xc);
		
		try {
			listPhim = phim_dao.printAll();
			listHinh = hinhAnh_Dao.printAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DocDuLieuLenFrame();

		HienListPhimDauTien();
		setLocationRelativeTo(null);
	}

	public void DocDuLieuLenFrame() {
		
		int soLuongPhim = listPhim.size();
		for(int i = 1; i <= getSoNut(listPhim.size()); i++) {
			pListPhim.removeAll();
			int k = (i - 1) * 4;
			for(int j = k; j < 4*i;j++) {
				if(soLuongPhim < 1) {
					return;
				}
				JPanel pPhim = new JPanel();
				pPhim.setBackground(new java.awt.Color(255, 255, 255));
				pPhim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
				pPhim.setPreferredSize(new java.awt.Dimension(213, 293));
//				pPhim.addMouseListener(new java.awt.event.MouseAdapter() {
//	                public void mouseClicked(java.awt.event.MouseEvent evt) {
//	                    pPhimMouseClicked(evt);
//	                }
//				});
				Phim p = listPhim.get(j);
				JLabel img_phim = new JLabel();
				img_phim.setIcon(new javax.swing.ImageIcon(getClass().getResource(p.getHinhAnh().getUrl()))); // NOI18N

				JLabel txt_tenphim = new JLabel();
				txt_tenphim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
				txt_tenphim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				txt_tenphim.setText(p.getTenPhim());

				javax.swing.GroupLayout pPhimLayout = new javax.swing.GroupLayout(pPhim);
				pPhim.setLayout(pPhimLayout);
				pPhimLayout.setHorizontalGroup(pPhimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(img_phim, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(txt_tenphim, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
				pPhimLayout.setVerticalGroup(pPhimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pPhimLayout.createSequentialGroup().addGap(1, 1, 1)
								.addComponent(img_phim, javax.swing.GroupLayout.PREFERRED_SIZE, 253,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txt_tenphim, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addContainerGap()));
				
				
				
				soLuongPhim--;
				
				
				pListPhim.add(pPhim);
				
				
			}
			
			listPane.add(pListPhim);
			pListPhim.setVisible(false);
		}

		
	}

	public int getSoNut(int n) {
		if( n % 4 == 0) {
			return n / 4;
		}
		return n / 4 + 1;
		
	}
	
	public void HienListPhimDauTien() {
		listPane.get(0).setVisible(true);
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        pXuatChieu = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        dtXuatChieu = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        btn_num_1 = new javax.swing.JButton();
        btn_num_2 = new javax.swing.JButton();
        btn_num_3 = new javax.swing.JButton();
        pListPhim = new JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 169, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 56));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DANH SÁCH PHIM");

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5418737-200 (1).png"))); // NOI18N
//        btn_back.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btn_backActionPerformed(evt);
//            }
//        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(364, 364, 364)
                .addComponent(jLabel1)
                .addContainerGap(362, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pXuatChieu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel7.setBackground(new java.awt.Color(255, 169, 89));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel7.setPreferredSize(new java.awt.Dimension(382, 56));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Suất Chiếu");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(120, 120, 120))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        dtXuatChieu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout dtXuatChieuLayout = new javax.swing.GroupLayout(dtXuatChieu);
        dtXuatChieu.setLayout(dtXuatChieuLayout);
        dtXuatChieuLayout.setHorizontalGroup(
            dtXuatChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dtXuatChieuLayout.setVerticalGroup(
            dtXuatChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtXuatChieu)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtXuatChieu)
        );

        javax.swing.GroupLayout pXuatChieuLayout = new javax.swing.GroupLayout(pXuatChieu);
        pXuatChieu.setLayout(pXuatChieuLayout);
        pXuatChieuLayout.setHorizontalGroup(
            pXuatChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pXuatChieuLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pXuatChieuLayout.setVerticalGroup(
            pXuatChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pXuatChieuLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        btn_num_1.setText("1");
        btn_num_1.setBorder(null);
        btn_num_1.setPreferredSize(new java.awt.Dimension(25, 25));
        btn_num_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_num_1ActionPerformed(evt);
            }
        });

        btn_num_2.setText("2");
        btn_num_2.setBorder(null);
        btn_num_2.setPreferredSize(new java.awt.Dimension(25, 25));
        btn_num_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_num_2ActionPerformed(evt);
            }
        });

        btn_num_3.setText("3");
        btn_num_3.setBorder(null);
        btn_num_3.setPreferredSize(new java.awt.Dimension(25, 25));
        btn_num_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_num_3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_num_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_num_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_num_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_num_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_num_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_num_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pListPhim.setPreferredSize(new java.awt.Dimension(504, 616));
        pListPhim.setLayout(new java.awt.GridLayout(2, 2, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(pListPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pXuatChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pXuatChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pListPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btn_num_1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_num_1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btn_num_1ActionPerformed

	private void btn_num_2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_num_2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btn_num_2ActionPerformed

	private void btn_num_3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_num_3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btn_num_3ActionPerformed

	private void btn_backActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {// GEN-FIRST:event_btn_backActionPerformed
		// TODO add your handling code here:
		new Login_Gui().setVisible(true);
		setVisible(false);
	}// GEN-LAST:event_btn_backActionPerformed

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
			java.util.logging.Logger.getLogger(Phim_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Phim_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Phim_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Phim_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Phim_Gui().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_num_1;
    private javax.swing.JButton btn_num_2;
    private javax.swing.JButton btn_num_3;
    private javax.swing.JDesktopPane dtXuatChieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel pListPhim;
    private javax.swing.JPanel pXuatChieu;
    // End of variables declaration//GEN-END:variables
}
