/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nickk.mehralent;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author nick
 */
public class product_activation extends javax.swing.JFrame {

    /**
     * Creates new form product_activation
     */
    public product_activation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        code = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activation Wizard");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 25));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTER YOUR ACTIVATION CODE BELOW :-");

        code.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        code.setForeground(new java.awt.Color(13, 255, 0));
        code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                codeCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(code))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(410, 273));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_codeCaretUpdate
        // TODO add your handling code here:
        MainClass mc = new MainClass();
        String p = new String (code.getPassword());
        if (p.equals("Activate_Software")){
            try{
                Class.forName(mc.cl);
                Connection con = DriverManager.getConnection(mc.url,mc.user,mc.pwd);
                Statement stmt = con.createStatement();
                String q;
                String q2;
                q ="truncate integrity_records;";
                q2 = "insert into integrity_records values('"+403+"');";
                stmt.executeUpdate(q);
                stmt.executeUpdate(q2);
                con.close();
                int c = JOptionPane.showConfirmDialog(this,"Thanks for activating, Reconfigure Users?","Confirm!",JOptionPane.YES_NO_OPTION);
                if (c == JOptionPane.YES_OPTION){
                dispose();
                new user_creator().setVisible(true);
                }
                else {
                    dispose();
                    new main_login().setVisible(true);
                }
            }
            catch (ClassNotFoundException | SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
    }//GEN-LAST:event_codeCaretUpdate

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
            java.util.logging.Logger.getLogger(product_activation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product_activation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product_activation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product_activation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product_activation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField code;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}