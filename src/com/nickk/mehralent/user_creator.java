/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nickk.mehralent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author nick
 */
public class user_creator extends javax.swing.JFrame {

    /**
     * Creates new form user_creator
     */
    public user_creator() {
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
        jLabel2 = new javax.swing.JLabel();
        uidtf = new javax.swing.JTextField();
        pwdtf = new javax.swing.JPasswordField();
        btn = new javax.swing.JButton();
        pbar = new javax.swing.JProgressBar();
        stats = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create User");
        setResizable(false);

        jLabel1.setText("Enter User Name To Be Created:");

        jLabel2.setText("Choose your password :");

        pwdtf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                pwdtfCaretUpdate(evt);
            }
        });

        btn.setText("CREATE USER");
        btn.setEnabled(false);
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        stats.setText("Password Strength");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uidtf)
                    .addComponent(pwdtf))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(pbar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uidtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stats)
                .addGap(32, 32, 32)
                .addComponent(btn)
                .addGap(22, 22, 22))
        );

        setSize(new java.awt.Dimension(472, 352));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pwdtfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_pwdtfCaretUpdate
        // TODO add your handling code here:
        String cnt;
        cnt = new String (pwdtf.getPassword());
        if (cnt.length()==0){
            pbar.setForeground(Color.black);
            stats.setForeground(Color.black);
            pbar.setValue(0);
            stats.setText("Password Strength");
        }
        else if (cnt.length() <=3 ){
            pbar.setForeground(Color.red);
            pbar.setValue(20);
            stats.setForeground(Color.red);
            stats.setText("Weak Password");
            btn.setEnabled(false);
        }
        else if (cnt.length() <=5 ){
            pbar.setValue(60);
            stats.setForeground(Color.yellow);
            stats.setText("Medium Password");
            btn.setEnabled(true);
        }
        else if (cnt.length() <=900 ){
            pbar.setValue(100);
            stats.setForeground(Color.green);
            stats.setText("Strong Password");
            btn.setEnabled(true);
            btn.setEnabled(true);
        }
        
    }//GEN-LAST:event_pwdtfCaretUpdate

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
        MainClass mc = new MainClass();
        String u,p; String globpass;
        u = uidtf.getText();
        p = new String(pwdtf.getPassword());
        globpass = null;
        // Let's Encrypt
        String passwordToHash = p;
                String realpass;
             try{
                 MessageDigest md = MessageDigest.getInstance("MD5");
                 md.update(passwordToHash.getBytes());
                 byte[] bytes = md.digest();
                 StringBuilder sb = new StringBuilder();
                 for (int i = 0; i<bytes.length;i++){
                 sb.append(Integer.toString((bytes [i] & 0xff) + 0x100,16).substring(1));
                 }
                 realpass = sb.toString();
                 globpass = realpass; //Defined the Globpass to match Generated Pass
             }
             catch (NoSuchAlgorithmException e){
                 String ee = e.getMessage();
                 JOptionPane.showMessageDialog(this,ee);
             }
        try{
            Class.forName(mc.cl);
            Connection con = DriverManager.getConnection(mc.url,mc.user,mc.pwd);
            Statement stmt = con.createStatement();
            String q,q1,q3,q4;
            q = "truncate login_records;";
            q1 = "insert into login_records values('"+u+"','"+globpass+"');";
            q3 = "truncate integrity_records;";
            q4 = "insert into integrity_records values('"+401+"')";
            stmt.executeUpdate(q);
            stmt.executeUpdate(q1);
            stmt.executeUpdate(q3);
            stmt.executeUpdate(q4);
            JOptionPane.showMessageDialog(this,"User "+u+" has been created"+"\n"+"Your Password is "+p);
            con.close();
            dispose();
            new main_login().setVisible(true);
        }
        catch (ClassNotFoundException | SQLException e){
            String ee = e.getMessage();
            JOptionPane.showMessageDialog(this,ee);
        }
    }//GEN-LAST:event_btnActionPerformed

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
            java.util.logging.Logger.getLogger(user_creator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_creator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_creator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_creator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_creator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar pbar;
    private javax.swing.JPasswordField pwdtf;
    private javax.swing.JLabel stats;
    private javax.swing.JTextField uidtf;
    // End of variables declaration//GEN-END:variables
}
