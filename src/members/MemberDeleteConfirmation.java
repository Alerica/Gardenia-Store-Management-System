package members;

import java.awt.Color;

public class MemberDeleteConfirmation extends javax.swing.JFrame {

    String deletedItem;
    public MemberDeleteConfirmation(String deletedName, String deletedID) {
        initComponents();
        StartingComponent();
        
        this.deletedItem = deletedID;
        
        if(deletedName.strip().equalsIgnoreCase("guest")) {
            System.out.println("Attempting delete guest");
            deleteLabel.setText("You`re not allowed to delete guest!");
            yesButton.setVisible(false);
        } else {
            deleteLabel.setText("Are you sure want to delete \"" + deletedName +"  \" ?");
        }
    }
    
    public MemberDeleteConfirmation() {
        initComponents();
        StartingComponent();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        deleteLabel = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(34, 23, 122));

        jButton1.setBackground(new java.awt.Color(96, 94, 161));
        jButton1.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("NO");
        jButton1.setBorder(null);
        jButton1.setFocusCycleRoot(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });

        deleteLabel.setForeground(new java.awt.Color(255, 255, 255));
        deleteLabel.setText("Are you sure want to delete \" \" ?");

        yesButton.setBackground(new java.awt.Color(96, 94, 161));
        yesButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        yesButton.setForeground(new java.awt.Color(255, 255, 255));
        yesButton.setText("YES");
        yesButton.setBorder(null);
        yesButton.setFocusCycleRoot(true);
        yesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                yesButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartingComponent() {
        this.setLocation(300,150);
        this.setSize(450,200);
        this.setResizable(false);
    }
    private void yesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseClicked
        Members member = new Members();
        member.DeleteData(deletedItem);
        this.dispose();
    }//GEN-LAST:event_yesButtonMouseClicked

    private void yesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseEntered
        yesButton.setBackground(new Color(204, 43, 82));
    }//GEN-LAST:event_yesButtonMouseEntered

    private void yesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseExited
        
        yesButton.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_yesButtonMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(new Color(204, 43, 82));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
         jButton1.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_jButton1MouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
