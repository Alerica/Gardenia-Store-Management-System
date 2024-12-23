package suppliers;

import gardeniastoremanagementsystem.BuiltSystem;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SupplierShowPage extends javax.swing.JFrame {

    Connection connection;
    public SupplierShowPage() {
        connection = BuiltSystem.CreateConnection(connection);
        initComponents();
        StartingComponent();

        RefreshData();
        
    }
    
    private void StartingComponent() {
        this.setLocation(300,120);
        this.setSize(900,320);
        this.setResizable(false);

        JTableHeader header = tableDetail.getTableHeader();
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Font verdanaFont = new Font("Verdana", Font.PLAIN, 14); // Font, style, size
        header.setFont(verdanaFont);
        header.setBackground(new Color(34, 23, 122));
        header.setForeground(Color.WHITE); 
    }
    
    public void RefreshData() {
        BuiltSystem.debugLog("Running RefreshData()");
        
        DefaultTableModel tableModel = (DefaultTableModel)tableDetail.getModel();
        Suppliers suppliers = new Suppliers();
        String supplier_id, supplier_name, supplier_phone;
        int size = suppliers.supplier_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {

            supplier_id = suppliers.supplier_ids.get(i);
            supplier_name = suppliers.supplier_names.get(i);
            supplier_phone = suppliers.supplier_phones.get(i);
            String rowData[] = {supplier_id, supplier_name, supplier_phone};
            
            tableModel.addRow(rowData);
        }   
    
        BuiltSystem.debugLog("RefreshData() Completed");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        detailCloseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetail = new javax.swing.JTable();
        insertSupplierButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 282));

        detailCloseButton.setBackground(new java.awt.Color(96, 94, 161));
        detailCloseButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        detailCloseButton.setForeground(new java.awt.Color(255, 255, 255));
        detailCloseButton.setText("close");
        detailCloseButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        detailCloseButton.setFocusCycleRoot(true);
        detailCloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailCloseButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                detailCloseButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                detailCloseButtonMouseExited(evt);
            }
        });
        detailCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailCloseButtonActionPerformed(evt);
            }
        });

        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Supplier_id", "Name", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDetail);
        if (tableDetail.getColumnModel().getColumnCount() > 0) {
            tableDetail.getColumnModel().getColumn(0).setResizable(false);
            tableDetail.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableDetail.getColumnModel().getColumn(1).setResizable(false);
            tableDetail.getColumnModel().getColumn(1).setPreferredWidth(300);
            tableDetail.getColumnModel().getColumn(2).setResizable(false);
            tableDetail.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        insertSupplierButton.setBackground(new java.awt.Color(96, 94, 161));
        insertSupplierButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        insertSupplierButton.setForeground(new java.awt.Color(255, 255, 255));
        insertSupplierButton.setText("New");
        insertSupplierButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        insertSupplierButton.setFocusCycleRoot(true);
        insertSupplierButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertSupplierButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                insertSupplierButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                insertSupplierButtonMouseExited(evt);
            }
        });
        insertSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSupplierButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(insertSupplierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertSupplierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detailCloseButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailCloseButtonMouseExited
        detailCloseButton.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_detailCloseButtonMouseExited

    private void detailCloseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailCloseButtonMouseEntered
        detailCloseButton.setBackground(new Color(204, 43, 82));
    }//GEN-LAST:event_detailCloseButtonMouseEntered

    private void detailCloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailCloseButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_detailCloseButtonMouseClicked

    private void detailCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailCloseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailCloseButtonActionPerformed

    private void insertSupplierButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertSupplierButtonMouseClicked
        SupplierRegistration supplierRegistration =  new SupplierRegistration();
        supplierRegistration.setName("SupplierRegistration");
        BuiltSystem.OpenWindow(supplierRegistration, "SupplierRegistration");
    }//GEN-LAST:event_insertSupplierButtonMouseClicked

    private void insertSupplierButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertSupplierButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_insertSupplierButtonMouseEntered

    private void insertSupplierButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertSupplierButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_insertSupplierButtonMouseExited

    private void insertSupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertSupplierButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertSupplierButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detailCloseButton;
    private javax.swing.JButton insertSupplierButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDetail;
    // End of variables declaration//GEN-END:variables


}
