/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import service.UsrService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Aealen
 */
public class RegUI extends javax.swing.JFrame {
    private UsrService usrService;

    /**
     * Creates new form RegUI
     */
    public RegUI() {
        usrService=new UsrService();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("学生活动管理系统丨注册");
        this.setSize(600,450);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegLabel = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        pwd1 = new javax.swing.JLabel();
        pwd2 = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        pwdInput1 = new javax.swing.JTextField();
        pwdInput2 = new javax.swing.JTextField();
        RegBt = new javax.swing.JButton();
        retBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        RegLabel.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        RegLabel.setText("注     册");

        id.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        id.setText("账号:");

        pwd1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        pwd1.setText("第一次输入密码:");

        pwd2.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        pwd2.setText("第二次确认密码:");

        idInput.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N

        pwdInput1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        pwdInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdInput1ActionPerformed(evt);
            }
        });

        pwdInput2.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N

        RegBt.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        RegBt.setText("注册");
        RegBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                RegBtActionPerformed(evt);
            }
        });

        retBt.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        retBt.setText("返回");
        retBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(RegLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(retBt)
                            .addComponent(pwd1)
                            .addComponent(id)
                            .addComponent(pwd2))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idInput)
                            .addComponent(pwdInput1)
                            .addComponent(pwdInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(RegBt)
                                .addGap(46, 46, 46)))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(RegLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwd1)
                    .addComponent(pwdInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwd2)
                    .addComponent(pwdInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegBt)
                    .addComponent(retBt))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pwdInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdInput1ActionPerformed
        // TODO add your handling code here:3w
    }//GEN-LAST:event_pwdInput1ActionPerformed

    private void retBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retBtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginUI().setVisible(true);
    }//GEN-LAST:event_retBtActionPerformed

    /**
     * 注册
     * @param evt
     */
    private void RegBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegBtActionPerformed
        // TODO add your handling code here:
        if (!usrService.UsrIsExist(idInput.getText())){//不存在这个人
            if (pwdInput1.getText().equals(pwdInput2.getText())){
                //两次密码一致
                if (usrService.addUsr(idInput.getText(),pwdInput1.getText())){
                    JOptionPane.showMessageDialog(null,"注册成功!!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"注册失败,未知错误!!");
                }
            }else{
                //两次密码不一致
                JOptionPane.showMessageDialog(null,"两次密码不一致,请检查!!");
            }
        }else {//已有此人!!
            JOptionPane.showMessageDialog(null,"已有此人,请重新输入ID!!!!");
            idInput.requestFocus();
            idInput.setSelectionStart(0);
            idInput.setSelectionEnd(idInput.getText().length());
        }

    }//GEN-LAST:event_RegBtActionPerformed

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
            java.util.logging.Logger.getLogger(RegUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegBt;
    private javax.swing.JLabel RegLabel;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel pwd1;
    private javax.swing.JLabel pwd2;
    private javax.swing.JTextField pwdInput1;
    private javax.swing.JTextField pwdInput2;
    private javax.swing.JButton retBt;
    // End of variables declaration//GEN-END:variables
}
