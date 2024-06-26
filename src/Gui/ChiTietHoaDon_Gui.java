/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Entity.VePhim;

/**
 *
 * @author skyga
 */
public class ChiTietHoaDon_Gui extends javax.swing.JFrame {

    private JPanel jPanel5;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel label_phong;
	private JLabel label_maghe;
	private JLabel jLabel4;
	private JLabel jLabel6;
	private JLabel label_loaighe;
	private JLabel label_dongia;
	private JLabel jLabel9;
	private JLabel label_suatchieu;
	private JLabel jLabel10;
	private JLabel lable_ngaytao;
	/**
     * Creates new form ChiTietHoaDon
     */
    public ChiTietHoaDon_Gui(ArrayList<VePhim> listVe) {
        initComponents(listVe);
        DocDuLieuVePhimLenFrame(listVe);
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
public int getRowListVe(int n) {
		
		if(n % 3 == 0){
		    return n / 3;
		}
		else {
		    return n / 3 + 1;
		}
		
	}
    
    public void  DocDuLieuVePhimLenFrame(ArrayList<VePhim> listVe) {
    	DecimalFormat df = new DecimalFormat("#,##0.00");
    	for(VePhim ve : listVe) {
    		
    		jPanel5 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            label_phong = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            label_maghe = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            label_loaighe = new javax.swing.JLabel();
            label_dongia = new javax.swing.JLabel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            label_suatchieu = new javax.swing.JLabel();
            lable_ngaytao = new javax.swing.JLabel();
    		jPanel5.setBackground(new java.awt.Color(255, 169, 89));
            jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            jPanel5.setPreferredSize(new java.awt.Dimension(190, 234));

            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            
            jLabel1.setText(ve.getPhim().getTenPhim());
            jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

            jLabel2.setText("Phòng: ");

            label_phong.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
            label_phong.setText(Integer.toString( ve.getPhong().getSoPhong()));

            jLabel4.setText("Mã ghế: ");

            label_maghe.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
            label_maghe.setText(ve.getGhe().getMaGhe());

            jLabel6.setText("Loại ghế: ");

            label_loaighe.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
            label_loaighe.setText(ve.getGhe().getLoaiGhe().getTenLoaiGhe());

            label_dongia.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
            label_dongia.setText(df.format(ve.getDonGia()) + " VND");

            jLabel9.setText("Đơn giá:");

            jLabel10.setText("Suất chiếu:");

            label_suatchieu.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
            label_suatchieu.setText(ve.getXuatChieu().getThoiGianBatDau().toString());

            lable_ngaytao.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
            lable_ngaytao.setText(LocalDate.now().toString());

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(label_maghe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_phong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_suatchieu, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addComponent(label_dongia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_loaighe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lable_ngaytao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel1)
                    .addGap(21, 21, 21)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(label_phong))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(label_maghe))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(label_loaighe))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(label_dongia))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(label_suatchieu))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                    .addComponent(lable_ngaytao)
                    .addContainerGap())
            );

            pListHoaDon.add(jPanel5);
    	}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(ArrayList<VePhim> listVe) {

        jScrollPane1 = new javax.swing.JScrollPane();
        scroll = new javax.swing.JPanel();
        pListHoaDon = new javax.swing.JPanel();
        btn_Xong = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        scroll.setMaximumSize(new java.awt.Dimension(528, 616));

        pListHoaDon.setLayout(new java.awt.GridLayout(getRowListVe(listVe.size()), 3, 50, 50));

        javax.swing.GroupLayout scrollLayout = new javax.swing.GroupLayout(scroll);
        scroll.setLayout(scrollLayout);
        scrollLayout.setHorizontalGroup(
            scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(pListHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        scrollLayout.setVerticalGroup(
            scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pListHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(scroll);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(25);
        btn_Xong.setText("XONG");
        btn_Xong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Phim_Gui(listVe.get(0).getNhanVien().getMaNV()).setVisible(true);
                setVisible(false);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(601, 601, 601)
                .addComponent(btn_Xong, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Xong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(ChiTietHoaDon_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChiTietHoaDon_Gui().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Xong;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pListHoaDon;
    private javax.swing.JPanel scroll;
    // End of variables declaration//GEN-END:variables
}
