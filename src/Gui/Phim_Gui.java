/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import ConnectDB.ConnectDB;
import Dao.ChiTietXuatChieu_Dao;
import Dao.HinhAnh_Dao;
import Dao.Phim_Dao;
import Entity.ChiTietXuatChieu;
import Entity.HinhAnh;
import Entity.KhachHang;
import Entity.Phim;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyga
 */
public class Phim_Gui extends javax.swing.JFrame implements MouseListener,ActionListener {
	private Phim_Dao phim_dao = new Phim_Dao();
	private ArrayList<Phim> listPhim = new ArrayList<Phim>();
	private ArrayList<HinhAnh> listHinh = new ArrayList<HinhAnh>();
	private HinhAnh_Dao hinhAnh_Dao = new HinhAnh_Dao();
	private ArrayList<JPanel> listChonPhim = new ArrayList<JPanel>();
	private ArrayList<ChiTietXuatChieu> listCTXC = new ArrayList<ChiTietXuatChieu>();
	private ChiTietXuatChieu_Dao ctxc_dao = new ChiTietXuatChieu_Dao();
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
		try {
			listPhim = phim_dao.printAll();
			listHinh = hinhAnh_Dao.printAll();
			listCTXC = ctxc_dao.printAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		initComponents();
		XuatChieuMacDinh_Gui xc = new XuatChieuMacDinh_Gui();
		xc.setVisible(true);
		dtXuatChieu.removeAll();
		dtXuatChieu.add(xc);
		
		

		DocDuLieuLenFrame();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	
	public void DocDuLieuLenFrame() {
		int i = 1;
		for(Phim p : listPhim) {
			JPanel pPhim = new JPanel();
			pPhim.setBackground(new java.awt.Color(255, 255, 255));
			pPhim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
			pPhim.setPreferredSize(new java.awt.Dimension(213, 293));
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
			
			
			pPhim.setName("" + i++);
			pPhim.addMouseListener(this);
//			System.out.println(pPhim.getName());
			
			
			
			pListPhim.add(pPhim);
			listChonPhim.add(pPhim);
		}
		
		listChonPhim.forEach((element) -> {
			element.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
					for(ChiTietXuatChieu ct : listCTXC) {
						if(ct.getPhim().getMaPhim().equals(element.getName())) {
							
							XuatChieu_Gui xc;
							try {
								xc = new XuatChieu_Gui(ct);
								dtXuatChieu.removeAll();
								xc.setVisible(true);
								dtXuatChieu.add(xc);
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
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
				
			
		
		
		
	
       
    }

	
	
	public int getRowListPhim(int n) {
		
		return n / 2 + n %2;
		
	}
	
	public int demSLXC(ChiTietXuatChieu CTXT) throws SQLException {
    	int dem = 0;
    	listCTXC = ctxc_dao.printAll();
    	 for(ChiTietXuatChieu ct : listCTXC) {
         	if(ct.getPhim().getMaPhim().equals(CTXT.getPhim().getMaPhim())) {
         		dem++;
         		
         	}
         }
    	 return dem;
    }
	
	
	
	
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 * @throws SQLException 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        scroll = new javax.swing.JPanel();
        pListPhim = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 169, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 56));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DANH SÁCH PHIM");

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5418737-200 (1).png"))); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btn_backActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

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
            .addGap(0, 550, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtXuatChieu)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtXuatChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(25);
        scroll.setMaximumSize(new java.awt.Dimension(528, 616));

        pListPhim.setLayout(new java.awt.GridLayout(getRowListPhim(listChonPhim.size()), 2, 80, 20));

        javax.swing.GroupLayout scrollLayout = new javax.swing.GroupLayout(scroll);
        scroll.setLayout(scrollLayout);
        scrollLayout.setHorizontalGroup(
            scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pListPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(592, Short.MAX_VALUE))
        );
        scrollLayout.setVerticalGroup(
            scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pListPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(scroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pXuatChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pXuatChieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
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
    private javax.swing.JDesktopPane dtXuatChieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pListPhim;
    private javax.swing.JPanel pXuatChieu;
    private javax.swing.JPanel scroll;
    // End of variables declaration//GEN-END:variables
    
   
	@Override
	public void mouseClicked(MouseEvent e) {

//		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource().equals()) {
//			
//		}
	}
}
