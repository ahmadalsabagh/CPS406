/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import sun.rmi.runtime.Log;

import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
/**
 *
 * @author elton
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Login() {
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

        userTxt = new javax.swing.JTextField();
        memberRb = new javax.swing.JRadioButton();
        coachRb = new javax.swing.JRadioButton();
        logBtn = new javax.swing.JButton();
         
        treasurerRb = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTxt.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        userTxt.setText("Name");
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });

        memberRb.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        memberRb.setText("Member");
        memberRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberRbActionPerformed(evt);
            }
        });

        coachRb.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        coachRb.setSelected(true);
        coachRb.setText("Coach");
        coachRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachRbActionPerformed(evt);
            }
        });

        logBtn.setText("LOGIN");
        logBtn.addActionListener(new LoginAction());

        treasurerRb.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        treasurerRb.setText("Treasurer");
        treasurerRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treasurerRbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(memberRb)
                        .addGap(33, 33, 33)
                        .addComponent(coachRb)
                        .addGap(39, 39, 39)
                        .addComponent(treasurerRb))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(logBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberRb)
                    .addComponent(coachRb)
                    .addComponent(treasurerRb))
                .addGap(51, 51, 51)
                .addComponent(logBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        ButtonGroup group = new ButtonGroup();
        group.add(memberRb);
        group.add(treasurerRb);
        group.add(coachRb);
        treasurerRb.getAccessibleContext().setAccessibleName("btn3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void memberRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberRbActionPerformed

    private void treasurerRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treasurerRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_treasurerRbActionPerformed

    private void coachRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachRbActionPerformed

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed

    private void logBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("Hello");
    }//GEN-LAST:event_logBtnActionPerformed

    private MembershipManagement membershipManagement;

    private void setup()
    {
        membershipManagement = new MembershipManagement();
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new Login().setVisible(true);
            }
        });

        Login login = new Login();
        login.setup();
    }
  private class LoginAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
      //What happens when u press login
          if(memberRb.isSelected())
          {
              if (membershipManagement.checkUserLogin(userTxt.getText()))
              {
                  //redirect to next page passing in the membershipManagement and user type/name
                  System.out.println("User logged in");
              }
          } 
          if(treasurerRb.isSelected())
          {
              if (membershipManagement.checkTreasurerLogin(userTxt.getText()))
              {
                  //redirect to next page passing in the membershipManagement and user type/name
                  System.out.println("User logged in");
              }
          }
          if(coachRb.isSelected())
          {
              if (membershipManagement.checkCoachLogin(userTxt.getText()))
              {
                  //redirect to next page passing in the membershipManagement and user type/name
                  System.out.println("User logged in");
              }
          }
          
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton coachRb;
    private javax.swing.JButton logBtn;
    private javax.swing.JRadioButton memberRb;
    private javax.swing.JRadioButton treasurerRb;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
