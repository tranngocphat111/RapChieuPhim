/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Dao.ChiTietXuatChieu_Dao;
import Entity.ChiTietXuatChieu;

/**
 *
 * @author skyga
 */
public class XuatChieu_Gui extends javax.swing.JInternalFrame {
    /**
     * Creates new form NewJFrame
     */
	private ArrayList<ChiTietXuatChieu> listCTXC = new ArrayList<ChiTietXuatChieu>();
	private ChiTietXuatChieu_Dao ctxc_dao = new ChiTietXuatChieu_Dao();
	private JLabel jLabel1;
	private JButton btn_suatchieu1;
	private ArrayList<JPanel> listPaneXC = new ArrayList<JPanel>();
	
    public XuatChieu_Gui() throws SQLException {
    	
        initComponents(new ChiTietXuatChieu("123"));
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
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
    
    public XuatChieu_Gui(ChiTietXuatChieu CTXT) throws SQLException {
    	listCTXC = ctxc_dao.printAll();
    	initComponents(CTXT);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        for(ChiTietXuatChieu ct : listCTXC) {
        	if(ct.getPhim().getMaPhim().equals(CTXT.getPhim().getMaPhim())) {
        		DocDuLieuLenFrame(ct);
        	}
        }
        
        listPaneXC.forEach((element) -> {
			element.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					System.out.println(element.getName());
					for(ChiTietXuatChieu ct : listCTXC) {
						if(ct.getMaCTXC().equals(element.getName())) {
							try {
								new ChonGhe_Gui(ct);
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
				
        
				
        
        
        
        ui.setNorthPane(null);
    }
    
    
    
    
    public void DocDuLieuLenFrame(ChiTietXuatChieu CTXT) {
    	JPanel pXC2 = new JPanel();
    	jLabel1 = new JLabel();
    	btn_suatchieu1 = new JButton();
    	String soCho = Integer.toString(CTXT.getSoLuongGheDat()) + "/" + Integer.toString(CTXT.getPhong().getSoLuongGhe()) + " Ghế";
    	jLabel1.setText(soCho);
    	btn_suatchieu1.setText(CTXT.getXuatChieu().getThoiGianBatDau().toString()) ;
    	javax.swing.GroupLayout pXC2Layout = new javax.swing.GroupLayout(pXC2);
        pXC2.setLayout(pXC2Layout);
        pXC2Layout.setHorizontalGroup(
            pXC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pXC2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pXC2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_suatchieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pXC2Layout.setVerticalGroup(
            pXC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pXC2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_suatchieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        
        pXC2.setName(CTXT.getMaCTXC());
        System.out.println(pXC2.getName());
        listPaneXC.add(pXC2);
        pListXC.add(pXC2);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    
	public int getRowListXC(int n) {
		
		return n / 2 + n %2;
		
	}
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(ChiTietXuatChieu CTXC) throws SQLException {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pScroll = new javax.swing.JPanel();
        pListXC = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(384, 574));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setPreferredSize(new java.awt.Dimension(384, 538));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pScroll.setPreferredSize(new java.awt.Dimension(370, 548));

        pListXC.setLayout(new java.awt.GridLayout(getRowListXC(demSLXC(CTXC)), 2, 40, 20));

        javax.swing.GroupLayout pScrollLayout = new javax.swing.GroupLayout(pScroll);
        pScroll.setLayout(pScrollLayout);
        pScrollLayout.setHorizontalGroup(
            pScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pScrollLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pListXC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pScrollLayout.setVerticalGroup(
            pScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pScrollLayout.createSequentialGroup()
                .addComponent(pListXC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 528, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pScroll);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XuatChieu_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XuatChieu_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XuatChieu_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XuatChieu_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new XuatChieu_Gui().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pListXC;
    private javax.swing.JPanel pScroll;
    // End of variables declaration//GEN-END:variables
}
