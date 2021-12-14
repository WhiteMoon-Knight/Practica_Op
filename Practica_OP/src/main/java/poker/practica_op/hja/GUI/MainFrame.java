/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poker.practica_op.hja.GUI;

/**
 *
 * @author jjcar
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        jPanel1 = new javax.swing.JPanel();
        P1_Panel = new javax.swing.JPanel();
        P1_card2 = new javax.swing.JLabel();
        P1_card1 = new javax.swing.JLabel();
        P1_equity = new javax.swing.JLabel();
        BoardPanel = new javax.swing.JPanel();
        Flop1 = new javax.swing.JLabel();
        Flop2 = new javax.swing.JLabel();
        Flop3 = new javax.swing.JLabel();
        Turn = new javax.swing.JLabel();
        River = new javax.swing.JLabel();
        Flop_ActionButton = new javax.swing.JToggleButton();
        Turn_ActionButton = new javax.swing.JToggleButton();
        River_ActionButton = new javax.swing.JToggleButton();
        P1_Panel1 = new javax.swing.JPanel();
        P1_card3 = new javax.swing.JLabel();
        P1_card4 = new javax.swing.JLabel();
        P1_equity1 = new javax.swing.JLabel();
        rangeGrid1 = new poker.practica_op.hja.GUI.RangeGrid();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        P1_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        P1_card2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        P1_card2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        P1_card1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        P1_card1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        P1_equity.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        P1_equity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        P1_equity.setText("---- %");

        javax.swing.GroupLayout P1_PanelLayout = new javax.swing.GroupLayout(P1_Panel);
        P1_Panel.setLayout(P1_PanelLayout);
        P1_PanelLayout.setHorizontalGroup(
            P1_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P1_PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(P1_card1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(P1_card2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(P1_equity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        P1_PanelLayout.setVerticalGroup(
            P1_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P1_PanelLayout.createSequentialGroup()
                .addGroup(P1_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1_card1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(P1_card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P1_equity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        BoardPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Board", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        Flop1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Flop1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Flop2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Flop2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Flop3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Flop3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Turn.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Turn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        River.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        River.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Flop_ActionButton.setBackground(new java.awt.Color(255, 255, 255));
        Flop_ActionButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Flop_ActionButton.setText("Flop");
        Flop_ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Flop_ActionButtonActionPerformed(evt);
            }
        });

        Turn_ActionButton.setBackground(new java.awt.Color(255, 255, 255));
        Turn_ActionButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Turn_ActionButton.setText("Turn");
        Turn_ActionButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Turn_ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Turn_ActionButtonActionPerformed(evt);
            }
        });

        River_ActionButton.setBackground(new java.awt.Color(255, 255, 255));
        River_ActionButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        River_ActionButton.setText("River");
        River_ActionButton.setBorder(null);
        River_ActionButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        River_ActionButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        River_ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                River_ActionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BoardPanelLayout = new javax.swing.GroupLayout(BoardPanel);
        BoardPanel.setLayout(BoardPanelLayout);
        BoardPanelLayout.setHorizontalGroup(
            BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Flop_ActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BoardPanelLayout.createSequentialGroup()
                        .addComponent(Flop1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Flop2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Flop3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Turn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Turn_ActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(River_ActionButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(River, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        BoardPanelLayout.setVerticalGroup(
            BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BoardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(River, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(Turn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Flop3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Flop2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Flop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Flop_ActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(Turn_ActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(River_ActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        P1_Panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        P1_card3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        P1_card3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        P1_card4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        P1_card4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        P1_equity1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        P1_equity1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        P1_equity1.setText("---- %");

        javax.swing.GroupLayout P1_Panel1Layout = new javax.swing.GroupLayout(P1_Panel1);
        P1_Panel1.setLayout(P1_Panel1Layout);
        P1_Panel1Layout.setHorizontalGroup(
            P1_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P1_Panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(P1_card4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(P1_card3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(P1_equity1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        P1_Panel1Layout.setVerticalGroup(
            P1_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P1_Panel1Layout.createSequentialGroup()
                .addGroup(P1_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1_card4, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(P1_card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P1_equity1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P1_Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(BoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(P1_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BoardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(P1_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P1_Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rangeGrid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(rangeGrid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Flop_ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Flop_ActionButtonActionPerformed
        // TODO add your handling code here:
        if(Flop_ActionButton.isSelected()){
            //setFlop();
        }else{
            //clearBoard();
        }
    }//GEN-LAST:event_Flop_ActionButtonActionPerformed

    private void Turn_ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Turn_ActionButtonActionPerformed
        // TODO add your handling code here:
        if(Turn_ActionButton.isSelected()){
            //setTurn();
        }else{
            //clearTurn();
        }
    }//GEN-LAST:event_Turn_ActionButtonActionPerformed

    private void River_ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_River_ActionButtonActionPerformed
        // TODO add your handling code here:
        if(River_ActionButton.isSelected()){
            //setRiver();
        }else{
            //clearRiver();
        }
    }//GEN-LAST:event_River_ActionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BoardPanel;
    private javax.swing.JLabel Flop1;
    private javax.swing.JLabel Flop2;
    private javax.swing.JLabel Flop3;
    private javax.swing.JToggleButton Flop_ActionButton;
    private javax.swing.JPanel P1_Panel;
    private javax.swing.JPanel P1_Panel1;
    private static javax.swing.JLabel P1_card1;
    private static javax.swing.JLabel P1_card2;
    private static javax.swing.JLabel P1_card3;
    private static javax.swing.JLabel P1_card4;
    private javax.swing.JLabel P1_equity;
    private javax.swing.JLabel P1_equity1;
    private javax.swing.JLabel River;
    private javax.swing.JToggleButton River_ActionButton;
    private javax.swing.JLabel Turn;
    private javax.swing.JToggleButton Turn_ActionButton;
    private javax.swing.JPanel jPanel1;
    private poker.practica_op.hja.GUI.RangeGrid rangeGrid1;
    // End of variables declaration//GEN-END:variables
}
