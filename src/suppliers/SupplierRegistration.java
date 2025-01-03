package suppliers;

public class SupplierRegistration extends javax.swing.JFrame {
    
    public SupplierRegistration() {
        initComponents();
        StartingComponent();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        finalConfirmation = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        warning = new javax.swing.JLabel();
        supplierField = new javax.swing.JTextField();
        supplierPhoneField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(96, 94, 161));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier Registration");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("___________________________________________");

        jButton1.setBackground(new java.awt.Color(168, 205, 137));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CONFIRM");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        finalConfirmation.setBackground(new java.awt.Color(96, 94, 161));
        finalConfirmation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        finalConfirmation.setForeground(new java.awt.Color(255, 255, 255));
        finalConfirmation.setText("I have make sure everything is right");
        finalConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalConfirmationActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(177, 240, 247));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCEL");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });

        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("Tidak Boleh Ada Kolom yang Kosong !!!");

        supplierField.setBackground(new java.awt.Color(255, 255, 255));
        supplierField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        supplierField.setText("Supplier Name");
        supplierField.setBorder(null);
        supplierField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierFieldActionPerformed(evt);
            }
        });

        supplierPhoneField.setBackground(new java.awt.Color(255, 255, 255));
        supplierPhoneField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        supplierPhoneField.setText("Supplier Phone Number");
        supplierPhoneField.setBorder(null);
        supplierPhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierPhoneFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finalConfirmation)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(warning))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(supplierPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supplierPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234)
                .addComponent(warning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(finalConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartingComponent() {
        this.setLocation(320,150);
        this.setSize(420, 610);
        this.setResizable(false);
        this.warning.setVisible(false);
    }
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Suppliers suppliers = new Suppliers();
        String name = supplierField.getText();
        String phone = supplierPhoneField.getText();
        int id = 0;
        boolean doubleData = false;
        
        if(Integer.parseInt(phone) <= 0) {
            this.warning.setText("Phone number must be number");
            this.warning.setVisible(true);
            return;
        }
        for(int i = 0; i < suppliers.supplier_ids.size(); i++){
            String phonex = suppliers.supplier_phones.get(i);
            if(phonex.equalsIgnoreCase(phone)){
                //Double data update confirmation
                this.warning.setText("Supplier dengan nama"+ suppliers.supplier_names.get(i) +" sudah ada");
                this.warning.setVisible(true);
                doubleData = true;
                id = i + 1;
            }
            id = Integer.parseInt(suppliers.supplier_ids.get(i)) + 1;
        }
        boolean confirmation = finalConfirmation.isSelected();
        if(confirmation && !name.trim().isEmpty() && Integer.parseInt(phone)>=0 && !doubleData) {
           
            suppliers.InsertData(String.valueOf(id), supplierField.getText(), supplierPhoneField.getText());
            this.dispose();
        }
        else{
            this.warning.setVisible(true);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void finalConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalConfirmationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalConfirmationActionPerformed

    private void supplierFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierFieldActionPerformed

    private void supplierPhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierPhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierPhoneFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox finalConfirmation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField supplierField;
    private javax.swing.JTextField supplierPhoneField;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
