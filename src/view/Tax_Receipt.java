/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TaxPayerDAO;
import controller.TaxPayerDAO;
import model.TaxDeclare;
import model.TaxPayer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaik
 */
public class Tax_Receipt extends javax.swing.JFrame {

    /**
     * Creates new form Tax_Receipt
     */
    private String name;
    private int tax_code;
    private String address;
    private String currency = "";
    private String bank;
    private String bankCode;
    private Timestamp date;
    private int user_id;
    private Float total;
    private String tax_period;
    private String word_money;

    public Tax_Receipt(String name, int tax_code, String address, String bank, String bankCode, Timestamp date, int user_id, Float total, String tax_period, String word_money) {
        this.name = name;
        this.tax_code = tax_code;
        this.address = address;
        this.bank = bank;
        this.bankCode = bankCode;
        this.date = date;
        this.user_id = user_id;
        this.total = total;
        this.tax_period = tax_period;
        this.word_money = word_money;
        initComponents();
        tableModel = (DefaultTableModel) jTable1.getModel();
        fillTaxReceipt();
    }

    public Tax_Receipt() {
        initComponents();
    }

    TaxPayerDAO taxPayerDAO = new TaxPayerDAO();
    DefaultTableModel tableModel;

    private void fillTaxReceipt() {

        lbname.setText(name);
        lbaddress.setText(address);
        lbbank.setText(bank);
        lbbankCode.setText(bankCode);
        lbtaxcode.setText(String.valueOf(tax_code));
        lblword_money.setText(word_money);

        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{1, null, tax_period, null, null, total});

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbaddress = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbtaxcode = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbbank = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbbankCode = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lblword_money = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Không ghi vào ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setText("khu vực này");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 70));

        jLabel3.setText("Mẫu số C1 - 02/NS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        jLabel4.setText("(Ban hành kèm theo Thông tư số 84/2016/TT-BTC của Bộ Tài chính)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 32, -1, -1));

        jLabel5.setText("Mã hiệu: ...........");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 54, -1, -1));

        jLabel6.setText("Số:  ...........");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 76, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("GIẤY NỘP TIỀN VÀO NGÂN SÁCH NHÀ NƯỚC");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 92, -1, -1));

        jLabel10.setText("Loại tiền:     ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 173, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("VND");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 173, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("USD");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 173, -1, -1));

        jCheckBox1.setText("Tiền mặt");
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 122, -1, -1));

        buttonGroup2.add(jCheckBox2);
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Chuyển khoản");
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 122, -1, -1));

        jLabel12.setText("khác: ....");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 173, -1, -1));

        jLabel13.setText("Người nộp thay:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 356, -1, -1));

        jLabel14.setText("Người nộp thuế: ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 276, -1, 20));

        jLabel15.setText("Địa chỉ:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 378, -1, -1));

        jLabel16.setText("Quận/Huyện:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 334, -1, -1));

        jLabel17.setText("Tỉnh, TP: Hà Nội");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 324, -1, -1));

        jLabel18.setText("Địa chỉ:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 302, -1, -1));

        jLabel19.setText("Số giấy nộp tiền: ");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 238, -1, -1));

        jTextField1.setEditable(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 228, 130, -1));

        jLabel20.setText("Mã số thuế:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 280, -1, -1));

        lbname.setText("name");
        jPanel1.add(lbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 180, 30));

        lbaddress.setText("address");
        jPanel1.add(lbaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 60, 20));

        jLabel23.setText("Thanh Xuân");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 334, -1, -1));
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(lbtaxcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel27.setText("Đề nghị NH/ KBNN: ");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));
        jPanel1.add(lbbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 410, -1, -1));

        jLabel29.setText("trích TK số: ");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 410, -1, -1));
        jPanel1.add(lbbankCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel31.setText("Nộp theo văn bản của cơ có thẩm quyền:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 432, -1, -1));

        jCheckBox3.setText("Kiểm toán nhà nước");
        jPanel1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 454, -1, -1));

        jCheckBox4.setText("Thanh tra Chính phủ");
        jPanel1.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 495, -1, -1));

        jCheckBox5.setText("Thanh tra tài chính");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 454, -1, -1));

        jCheckBox6.setText("Cơ quan có thẩm quyền khác");
        jPanel1.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 495, -1, -1));

        jLabel8.setText("Cơ quan quản lý thu: Chi cục Thuế Quận Thanh Xuân");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 526, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Số tờ khai/Số quyế định", "Kỳ thuế/ Ngày quyết định", "Nội dung csc khoản nộp NSNN", "Ghi chú", "Số tiền VND"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 548, 945, 70));

        jLabel9.setText("Ngày..... Tháng......Năm......");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 680, -1, -1));

        jLabel11.setText("ĐỐI TƯỢNG NỘP TIỀN");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 660, -1, -1));
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 714, -1, -1));

        jLabel33.setText("NGÂN HÀNG (KBNN)");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 680, -1, -1));

        jLabel34.setText("Kế toán trưởng");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 740, -1, -1));

        jLabel35.setText("Kế toán");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 740, -1, -1));

        jLabel36.setText("Thủ trưởng");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 740, -1, -1));

        jLabel37.setText("Kế toán trưởng");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 700, -1, -1));

        jLabel38.setText("Người nộp tiền");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, -1, -1));

        jLabel39.setText("Ngày..... Tháng......Năm......");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 700, -1, -1));

        jButton1.setText("Sửa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 790, 80, -1));

        jButton2.setText("Kí và nộp");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 790, -1, -1));

        jButton3.setText("In GNT");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 790, 80, -1));

        jLabel21.setText("Sô tiền bằng chữ: ");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, -1));
        jPanel1.add(lblword_money, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, -1, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TaxPayer_UI i = new TaxPayer_UI(3, "Hà", 9765556, "HN", null, null);
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jRadioButton1.isSelected()) {
            currency += "VND";
        }
        if (jRadioButton2.isSelected()) {
            currency += "USD";
        }
        TaxPayerDAO dAO = new TaxPayerDAO();
        dAO.insertDB(bank, bankCode, currency, date, tax_code, user_id);
        int n = JOptionPane.showConfirmDialog(
                this,
                "Kí thành công. Bạn có muốn quay về trang chủ",
                "Alert",
                JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            MainScreen mainScreen = new MainScreen(user_id, tax_code, name);
            mainScreen.setVisible(true);
            this.dispose();
        }

//          System.out.println(date);
//        System.out.println(currency);

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Tax_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tax_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tax_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tax_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tax_Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbaddress;
    private javax.swing.JLabel lbbank;
    private javax.swing.JLabel lbbankCode;
    private javax.swing.JLabel lblword_money;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbtaxcode;
    // End of variables declaration//GEN-END:variables
}
