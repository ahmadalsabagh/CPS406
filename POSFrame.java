import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import Login.LoginAction;

public class POSFrame extends javax.swing.JFrame {

    /**
     * Creates new form POSFrame
     */
	
    public POSFrame() {
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
        oneClassBtn = new javax.swing.JButton();
        twoClassBtn = new javax.swing.JButton();
        outstandingBtn = new javax.swing.JButton();
        balanceLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutBtn.setText("Logout");

        oneClassBtn.setText("Schedule One Class");
        oneClassBtn.addActionListener(new launchPOSOne());

        twoClassBtn.setText("Schedule Two Classes");
        twoClassBtn.addActionListener(new launchPOSTwo());

        outstandingBtn.setText("Pay Outstanding");
        outstandingBtn.addActionListener(new launchPOSZero());

        balanceLbl.setText("Balance: $XX.XX"); //TODO change balance to actual member balance
        balanceLbl.setToolTipText("");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(balanceLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(128, 128, 128)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(outstandingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(twoClassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(oneClassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(balanceLbl)
                       
                        ))
                .addGap(64, 64, 64)
                .addComponent(oneClassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(twoClassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(outstandingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(POSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POSFrame().setVisible(true);
            }
        });
    }
    
    private class launchPOSOne implements ActionListener {
        public void actionPerformed(ActionEvent e) {
       
          CardInfoFrame card = new CardInfoFrame();
          card.setVisible(true);
          
        	
          System.out.println("POS launched for one class");
          
    }
    
}
    private class launchPOSTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	CardInfoFrame card = new CardInfoFrame();
            card.setVisible(true);
       
          System.out.println("POS launched for two classes");
          
    }
  }
    
    private class launchPOSZero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	CardInfoFrame card = new CardInfoFrame();
            card.setVisible(true);
       
          System.out.println("POS launched to settle balance");
          
    }
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton oneClassBtn;
    private javax.swing.JButton twoClassBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton outstandingBtn;
    private javax.swing.JLabel balanceLbl;
    
    // End of variables declaration//GEN-END:variables
}
