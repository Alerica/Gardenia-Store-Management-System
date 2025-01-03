package products;

import javax.swing.JOptionPane;
import products.*;
import suppliers.Suppliers;

public class ProductRegistration extends javax.swing.JFrame {
    
    public ProductRegistration() {
        initComponents();
        StartingComponent();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        StockField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        finalConfirmation = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        PriceField = new javax.swing.JTextField();
        CategoryBox = new javax.swing.JComboBox<>();
        warning = new javax.swing.JLabel();
        SupplierList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(420, 610));

        jPanel1.setBackground(new java.awt.Color(96, 94, 161));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Registration");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("___________________________________________");

        nameField.setBackground(new java.awt.Color(255, 255, 255));
        nameField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        nameField.setText("Product Name");
        nameField.setBorder(null);
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        StockField.setBackground(new java.awt.Color(255, 255, 255));
        StockField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        StockField.setText("Stock");
        StockField.setBorder(null);
        StockField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockFieldActionPerformed(evt);
            }
        });
        StockField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                StockFieldKeyPressed(evt);
            }
        });

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

        PriceField.setBackground(new java.awt.Color(255, 255, 255));
        PriceField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceField.setText("Price");
        PriceField.setBorder(null);
        PriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceFieldActionPerformed(evt);
            }
        });

        CategoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bahan pokok", "minuman", "alat", "pewarna makanan", "kue", "kue kering", "dekorasi", "kemasan", "bahan tambahan", "kue basah", "Roti" }));
        CategoryBox.setSelectedItem(CategoryBox);
        CategoryBox.setToolTipText("");
        CategoryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryBoxActionPerformed(evt);
            }
        });

        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("Tidak Boleh Ada Kolom yang Kosong !!!");

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
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StockField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(warning))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CategoryBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SupplierList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(StockField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CategoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SupplierList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
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
        
        Suppliers suppliers = new Suppliers();
        int suppliersCount = suppliers.supplier_ids.size();
        String name = "";
        for(int i = 0; i < suppliersCount; i++){
            name = suppliers.supplier_names.get(i);
            this.SupplierList.addItem(name);
        }
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        String name = nameField.getText();
        String category_name = (String) CategoryBox.getSelectedItem();
        String suppName = (String) SupplierList.getSelectedItem();
        
        String stock = StockField.getText();
        String price = PriceField.getText();
        
        if(Integer.parseInt(stock) <= 0 || Integer.parseInt(price) <= 0) {
            return;
        }
        
        boolean confirmation = finalConfirmation.isSelected();
        Products products = new Products();
        if(confirmation && !name.trim().isEmpty() && !category_name.trim().isEmpty() && !stock.trim().isEmpty() && !price.trim().isEmpty() && Integer.parseInt(stock)>=0 && Integer.parseInt(price) >= 0) {
            
            for(int i = 0; i < products.product_ids.size(); i++){
                String namex = products.product_names.get(i);
                if(namex.equalsIgnoreCase(name)){
                    //Double data update confirmation
                    new ProductDoubleDataUpdateConfirmation(name, products.product_ids.get(i), stock, price);
                    this.dispose();
                }
            }
            products.InsertProduct(name, suppName, category_name, stock, price);
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

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void StockFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockFieldActionPerformed
        // TODO add your handling code here:
        String input = StockField.getText();

        // Validasi apakah teks hanya angka
        if (!input.matches("\\d+")) { // Regex untuk memeriksa angka
            // Tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(this, "Hanya boleh angka!", "Input Invalid", JOptionPane.ERROR_MESSAGE);

            // Kosongkan teks di StockField
            StockField.setText("");
        } else {
            // Jika valid, lakukan operasi lainnya
            System.out.println("Input valid: " + input);
        }
    }//GEN-LAST:event_StockFieldActionPerformed

    private void CategoryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryBoxActionPerformed

    private void PriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceFieldActionPerformed

    private void StockFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StockFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_StockFieldKeyPressed

    private void finalConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalConfirmationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalConfirmationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void Start() {
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
            java.util.logging.Logger.getLogger(ProductRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CategoryBox;
    private javax.swing.JTextField PriceField;
    private javax.swing.JTextField StockField;
    private javax.swing.JComboBox<String> SupplierList;
    private javax.swing.JCheckBox finalConfirmation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
