import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 k*/

/**
 *
 * @author elton
 */
public class MemberFrame extends javax.swing.JFrame {

    /**
     * Creates new form MemberFrame
     */
  private MembershipManagement membership;
  private String memberName;
    public MemberFrame(MembershipManagement membership, String memberName,Boolean True) {
      this.membership = membership;
      this.memberName = memberName;
        initComponents();
    }
    public MemberFrame(MembershipManagement membership, String memberName)
    {
      
       /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberFrame(membership,memberName,true).setVisible(true);
            }
        });
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
        viewScheduleBtn = new javax.swing.JButton();
        viewScheduleBtn.addActionListener(new ScheduleAction());
        FeeBtn = new javax.swing.JButton();
        MsgCoachBtn = new javax.swing.JButton();
        MsgCoachBtn.addActionListener(new MsgCoachAction());
        welcomeLbl = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutBtn.setText("Logout");

        viewScheduleBtn.setText("View Schedule");

        FeeBtn.setText("Pay Fees");
        FeeBtn.addActionListener(new payFees());

        MsgCoachBtn.setText("Message Coach");

        welcomeLbl.setText("Welcome Back");
        welcomeLbl.setToolTipText("");

        userLbl.setText("UserName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(welcomeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLbl)
                .addGap(128, 128, 128)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MsgCoachBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(FeeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewScheduleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(welcomeLbl)
                        .addComponent(userLbl)))
                .addGap(64, 64, 64)
                .addComponent(viewScheduleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(FeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(MsgCoachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
    }
    
    private class payFees implements ActionListener {
        public void actionPerformed(ActionEvent e) {
         
          CardInfoFrame cardInfoFrame = new CardInfoFrame(membership, memberName);
          dispose();
         
        }
    }
    private class LogoutAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
         membership.saveSessionData(membership.sessions);
          membership.saveCoachData(membership.coaches);
          membership.saveMessageSystem();
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new Login().setVisible(true);
            }
        });
        dispose();
         
        }
    }
     private class MsgCoachAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        MessageFrame messageFrame = new MessageFrame(membership,memberName);
        dispose();
        }
    }
       private class ScheduleAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          String[][] memberNames;
       for(int i = 0;i<membership.sessions.size();i++)
       {
         memberNames = membership.sessions.get(i).getMemberNames();
         for(int j = 0;j<memberNames.length;j++)
         {
          if(memberNames[j][0].equals(memberName))
               {
                
          FeedBackFrame feedBackFrame;
      
         if(i==0)
         {
         feedBackFrame = new FeedBackFrame("Practices on Thursdays,Sessions on Fridays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
          if(i==1)
         {
         feedBackFrame = new FeedBackFrame("Practices on Thursdays,Sessions on Sundays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
           if(i==2)
         {
         feedBackFrame = new FeedBackFrame("Practices on Friday,Sessions on Thursdays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
            if(i==3)
         {
         feedBackFrame = new FeedBackFrame("Practices on Thursdays,Sessions on Fridays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
             if(i==4)
         {
         feedBackFrame = new FeedBackFrame("Practices on Monday,Sessions on Tuesday");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
              if(i==5)
         {
         feedBackFrame = new FeedBackFrame("Practices on Wednesday,Sessions on Thursday");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
               if(i==6)
         {
         feedBackFrame = new FeedBackFrame("Practices on Sundays,Sessions on Saturdays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
                if(i==7)
         {
         feedBackFrame = new FeedBackFrame("Practices on Tuesdays,Sessions on Mondays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
                 if(i==8)
         {
         feedBackFrame = new FeedBackFrame("Practices on Saturdays,Sessions on Wednesdays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
                  if(i==9)
         {
         feedBackFrame = new FeedBackFrame("Practices on Thursdays,Sessions on Wednedays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
                   if(i==10)
         {
         feedBackFrame = new FeedBackFrame("Practices on Thursdays,Sessions on Mondays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
                    if(i==11)
         {
         feedBackFrame = new FeedBackFrame("Practices on Tuesdays,Sessions on Fridays");
         feedBackFrame.setVisible(true);
         feedBackFrame.setLocationRelativeTo(null);
         
         }
          
    
               }
           
         }  
       }  
        
      
        
        }
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FeeBtn;
    private javax.swing.JButton MsgCoachBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel userLbl;
    private javax.swing.JButton viewScheduleBtn;
    private javax.swing.JLabel welcomeLbl;
    // End of variables declaration//GEN-END:variables
}
