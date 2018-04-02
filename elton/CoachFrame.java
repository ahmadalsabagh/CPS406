/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elton
 */
import java.awt.*;  
import java.awt.event.*;  
public class CoachFrame extends javax.swing.JFrame  {

    /**
     * Creates new form CoachFrame
     */
    public CoachFrame() {
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

        logoutBtn = new javax.swing.JButton();
        logoutBtn.addActionListener(new LogoutAction());
        msgBtn = new javax.swing.JButton();
        msgBtn.addActionListener(new MsgAction());
        viewScheduleBtn = new javax.swing.JButton();
        viewScheduleBtn.addActionListener(new ScheduleAction());
        msgTreasurerBtn = new javax.swing.JButton();
        msgTreasurerBtn.addActionListener(new MsgTreasurerAction());
        practiceFreqBtn = new javax.swing.JButton();
        practiceFreqBtn.addActionListener(new PracticeFreqAction());
        sessionFreqBtn = new javax.swing.JButton();
        sessionFreqBtn.addActionListener(new SessionFreqAction());
        viewMemberBtn = new javax.swing.JButton();
        viewMemberBtn.addActionListener(new ViewMemberAction());
        welcomeLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutBtn.setText("Logout");
       

        msgBtn.setText("Message Members");

        viewScheduleBtn.setText("View Schedule");
        viewScheduleBtn.setActionCommand("viewScheduleBtn");

        msgTreasurerBtn.setText("Message Treasurer");

        practiceFreqBtn.setText("Practice Attendance");

        sessionFreqBtn.setText("Session Attendance");

        viewMemberBtn.setText("View Members");

        welcomeLbl.setText("Welcome Back Coach,");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(viewScheduleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addComponent(msgTreasurerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(msgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(practiceFreqBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(sessionFreqBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcomeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(practiceFreqBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sessionFreqBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(viewScheduleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msgTreasurerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(viewMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 131, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(CoachFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoachFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoachFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoachFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoachFrame().setVisible(true);
            }
        });
     
}
    
 private class LogoutAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
      //What happens when u press logout
          System.out.println("Logout Button Pressed");
          
    }
 }
  private class MsgAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
      //What happens when u press Message Memebers
          System.out.println("Message Button Pressed");
          
    }
 }
  private class ScheduleAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
      //What happens when u press View Schedule
          System.out.println("Schedule Button Pressed");
          
    }
 }
  private class MsgTreasurerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
      //What happens when u press Message Treasurere
          System.out.println("Message Treasurer Button Pressed");
          
    }
 }
  private class PracticeFreqAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
      //What happens when u press Practice Attendance
          System.out.println("Practice Attendance Button Pressed");
          
    }
 }
  private class SessionFreqAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
      //What happens when u press Session Attendance
          System.out.println("Session Attendance Button Pressed");
          
    }
 }
  private class ViewMemberAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
      //What happens when u press ViewMembers
          System.out.println("View Members Button Pressed");
          
    }
 }






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton msgBtn;
    private javax.swing.JButton msgTreasurerBtn;
    private javax.swing.JButton practiceFreqBtn;
    private javax.swing.JButton sessionFreqBtn;
    private javax.swing.JButton viewMemberBtn;
    private javax.swing.JButton viewScheduleBtn;
    private javax.swing.JLabel welcomeLbl;
    // End of variables declaration//GEN-END:variables
}
