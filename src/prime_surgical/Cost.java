/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime_surgical;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mahmudul Hasan
 */
public class Cost extends javax.swing.JFrame {

    /**
     * Creates new form Cost
     */
    public Cost() {
        initComponents();
        Bank.setVisible(false);
        new dbConnection().getDataFromCombo(comBankName, "SELECT `bank_account_name` FROM `bank accounts`");
        showCostData();
    }
    String costType, details, paidBy, date, payment, bankName, bankAccount;
    int bill;
    double amount;

    void getData() {
        if (comCostType.getSelectedItem().toString().equals("Sales Cost")) {
            costType = "Sales Cost";
        } else if (comCostType.getSelectedItem().toString().equals("Purchase Cost")) {
            costType = "Purchase Cost";
        } else if (comCostType.getSelectedItem().toString().equals("Others Cost")) {
            costType = "Others Cost";
        }
        try {
            bill = Integer.parseInt(txtBill.getText());
        } catch (Exception e) {
        }
        details = txtDetails.getText();
        try {
            amount = Integer.parseInt(txtAmount.getText());
        } catch (Exception e) {
        }
        paidBy = txtPaidBy.getText();
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        date = sm.format(jDateChooser1.getDate());
        if (rbBank.isSelected()) {
            payment = "Bank";
        } else if (rbCash.isSelected()) {
            payment = "Cash";
        }
        bankName = comBankName.getSelectedItem().toString();
        bankAccount = jComboBox2.getSelectedItem().toString();
    }

    void addCost() {
        if (rbBank.isSelected()) {
            getData();
            new dbConnection().addDataWithNoMessege("INSERT INTO `bank data`(`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) VALUES('" + date + "','" + bankName + "','" + bankAccount + "','" + details + "','" + "Withdraw" + "','" + amount + "')");
            new dbConnection().addData("INSERT INTO `cost data`(`cost_date`,`cost_type`,`cost_bill`,`cost_details`,`cost_paid_by`,`cost_amount`) VALUES('" + date + "','" + costType + "','" + bill + "','" + details + "','" + paidBy + "','" + amount + "')", this);
            showCostData();
        } else if (rbCash.isSelected()) {
            getData();
            new dbConnection().addDataWithNoMessege("INSERT INTO `cash data`(`cash_date`,`cash_details`,`cash_status`,`cash_amount`) VALUES('" + date + "','" + details + "','" + "Debit" + "','" + amount + "')");
            new dbConnection().addData("INSERT INTO `cost data`(`cost_date`,`cost_type`,`cost_bill`,`cost_details`,`cost_paid_by`,`cost_amount`) VALUES('" + date + "','" + costType + "','" + bill + "','" + details + "','" + paidBy + "','" + amount + "')", this);
            showCostData();
        }
    }

    int checkBlankDate() {
        int check = 0;
        if (comCostType.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select Cost Type!");
            comCostType.requestFocus();
        } else if (txtBill.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter bill number!");
            txtBill.requestFocus();
        } else if (txtDetails.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Details!");
            txtDetails.requestFocus();
        } else if (txtAmount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter amount!");
            txtAmount.requestFocus();
        } else if (txtPaidBy.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Paid by!");
            txtPaidBy.requestFocus();
        } else if (((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Date!");
            jDateChooser1.requestFocus();
        } else if (!rbCash.isSelected() && !rbBank.isSelected()) {
            JOptionPane.showMessageDialog(this, "Select payment method!");
        } else {
            check = 1;
        }

        return check;
    }

    void showCostData() {
        new dbConnection().showCostData("select * FROM `cost data`", jTable1);
        String total = new dbConnection().singledata("select SUM(`cost_amount`) FROM `cost data`");
        jLabel1.setText(total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtBill = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        txtDetails = new javax.swing.JTextField();
        txtPaidBy = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comCostType = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        Bank = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        comBankName = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        rbBank = new javax.swing.JRadioButton();
        rbCash = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(123, 120, 201));
        jPanel3.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 0, 20, 100);

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Costs");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 0, 160, 100);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel10);
        jLabel10.setBounds(1320, 0, 50, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 1370, 100);

        jPanel4.setBackground(new java.awt.Color(105, 162, 206));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel4.setLayout(null);

        txtBill.setBackground(new java.awt.Color(60, 80, 104));
        txtBill.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtBill.setForeground(new java.awt.Color(255, 255, 255));
        txtBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBillKeyPressed(evt);
            }
        });
        jPanel4.add(txtBill);
        txtBill.setBounds(220, 100, 150, 50);

        txtAmount.setBackground(new java.awt.Color(60, 80, 104));
        txtAmount.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtAmount.setForeground(new java.awt.Color(255, 255, 255));
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountKeyPressed(evt);
            }
        });
        jPanel4.add(txtAmount);
        txtAmount.setBounds(220, 200, 340, 50);

        txtDetails.setBackground(new java.awt.Color(60, 80, 104));
        txtDetails.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtDetails.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txtDetails);
        txtDetails.setBounds(220, 150, 340, 50);

        txtPaidBy.setBackground(new java.awt.Color(60, 80, 104));
        txtPaidBy.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtPaidBy.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txtPaidBy);
        txtPaidBy.setBounds(220, 250, 340, 50);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Cost Type:");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(90, 50, 130, 50);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Details:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(90, 150, 130, 50);

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Date:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(90, 300, 130, 50);

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Paid by:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(90, 250, 130, 50);

        comCostType.setBackground(new java.awt.Color(60, 80, 104));
        comCostType.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        comCostType.setForeground(new java.awt.Color(255, 255, 255));
        comCostType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Sales Cost", "Purchase Cost", "Others Cost" }));
        jPanel4.add(comCostType);
        comCostType.setBounds(220, 50, 340, 50);
        jPanel4.add(jDateChooser1);
        jDateChooser1.setBounds(220, 300, 340, 50);

        Bank.setBackground(new java.awt.Color(0, 153, 153));
        Bank.setBorder(new javax.swing.border.MatteBorder(null));
        Bank.setLayout(null);

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Bank Name:");
        Bank.add(jLabel22);
        jLabel22.setBounds(40, 12, 150, 40);

        comBankName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comBankName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comBankName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comBankNamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        Bank.add(comBankName);
        comBankName.setBounds(190, 12, 250, 40);

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Account Number:");
        Bank.add(jLabel19);
        jLabel19.setBounds(40, 62, 150, 40);

        jComboBox2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        Bank.add(jComboBox2);
        jComboBox2.setBounds(190, 60, 250, 40);

        jPanel4.add(Bank);
        Bank.setBounds(90, 400, 450, 110);

        buttonGroup1.add(rbBank);
        rbBank.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        rbBank.setForeground(new java.awt.Color(0, 0, 0));
        rbBank.setText("Bank");
        rbBank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbBankMouseClicked(evt);
            }
        });
        rbBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBankActionPerformed(evt);
            }
        });
        jPanel4.add(rbBank);
        rbBank.setBounds(220, 360, 120, 30);

        buttonGroup1.add(rbCash);
        rbCash.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        rbCash.setForeground(new java.awt.Color(0, 0, 0));
        rbCash.setText("Cash");
        rbCash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCashMouseClicked(evt);
            }
        });
        jPanel4.add(rbCash);
        rbCash.setBounds(90, 360, 110, 30);

        jButton2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(120, 520, 200, 50);

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Bill no:");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(90, 100, 130, 50);

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Amount:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(90, 200, 130, 50);

        jButton1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(320, 520, 200, 50);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 100, 570, 670);

        jPanel5.setBackground(new java.awt.Color(60, 80, 104));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        jTable1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sl no.", "Date", "Cost Type", "Bill no.", "Detalis", "Paid by", "Amount"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(0, 50, 790, 520);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("0.00");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(630, 570, 130, 50);

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total:");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(560, 570, 70, 50);

        jButton4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton4.setText("Show by month");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);
        jButton4.setBounds(450, 0, 160, 50);

        jButton3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton3.setText("Show by date");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);
        jButton3.setBounds(610, 0, 180, 50);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(570, 100, 790, 670);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbBankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbBankMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_rbBankMouseClicked

    private void rbBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBankActionPerformed
        // TODO add your handling code here:
        if (rbBank.isSelected()) {
            Bank.setVisible(true);
        }
    }//GEN-LAST:event_rbBankActionPerformed

    private void rbCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCashMouseClicked
        // TODO add your handling code here:
        if (rbCash.isSelected()) {
            Bank.setVisible(false);
        }
    }//GEN-LAST:event_rbCashMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (checkBlankDate() == 1) {
            addCost();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new dbConnection().getDataFromCombo(comBankName, "SELECT `bank_account_name` FROM `bank accounts` order by DATE(`cost_date`)");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new dbConnection().getDataFromCombo(comBankName, "SELECT `bank_account_name` FROM `bank accounts` order by MONTH(`cost_date`)");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void comBankNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comBankNamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String bankName = comBankName.getSelectedItem().toString();
        new dbConnection().getDataFromCombo(jComboBox2, "SELECT `bank_account_number` FROM `bank accounts` WHERE `bank_account_name`='" + bankName + "'");
    }//GEN-LAST:event_comBankNamePopupMenuWillBecomeInvisible

    private void txtBillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillKeyPressed
        // TODO add your handling code here:
        try {
            bill = Integer.parseInt(txtBill.getText());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtBillKeyPressed

    private void txtAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyPressed
        // TODO add your handling code here:
        try {
            amount = Integer.parseInt(txtAmount.getText());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtAmountKeyPressed

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
            java.util.logging.Logger.getLogger(Cost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bank;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comBankName;
    private javax.swing.JComboBox<String> comCostType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbBank;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBill;
    private javax.swing.JTextField txtDetails;
    private javax.swing.JTextField txtPaidBy;
    // End of variables declaration//GEN-END:variables
}
