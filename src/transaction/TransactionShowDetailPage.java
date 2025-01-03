package transaction;

import gardeniastoremanagementsystem.BuiltSystem;
import gardeniastoremanagementsystem.GardeniaStoreManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TransactionShowDetailPage extends javax.swing.JFrame {

    int trans_id;
    int total_recap;
    
    Connection connection;
    public TransactionShowDetailPage(int trans_id, int total_recap) {
        connection = BuiltSystem.CreateConnection(connection);
        this.trans_id = trans_id;
        this.total_recap = total_recap; 
        initComponents();
        StartingComponent();
        
        RefreshData();
    }
    
    private void StartingComponent() {
        this.setLocation(300,120);
        this.setSize(900,320);
        this.setResizable(false);

        
        TransactionsDetail transD = new TransactionsDetail(trans_id, total_recap);
        JTableHeader header = tableDetail.getTableHeader();
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Font verdanaFont = new Font("Verdana", Font.PLAIN, 14); // Font, style, size
        header.setFont(verdanaFont);
        header.setBackground(new Color(34, 23, 122));
        header.setForeground(Color.WHITE);   
        
        Transactions transactions = new Transactions();
        String nameMember = null;
        
        
        int size = transD.ids_trans.size();
        
        memberName.setText("Member name : " + transD.member_names.get(0));
        totalAllDetail.setText("Total : Rp. " + total_recap);
    }
    
    private void RefreshData() {
        BuiltSystem.debugLog("Running RefreshData()");
        
        DefaultTableModel tableModel = (DefaultTableModel)tableDetail.getModel();
        TransactionsDetail transD = new TransactionsDetail(trans_id,total_recap);
        String id_trans, product_name, quantity, product_price, total_detail, member_name, id_products;
        int size = transD.ids_trans.size();
        int total_row = tableModel.getRowCount();
        Transactions trans = new Transactions();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {

            id_trans = transD.ids_trans.get(i);
            id_products= transD.ids_products.get(i);
            product_name = transD.product_names.get(i);
            quantity = transD.quantities.get(i);
            product_price = transD.product_prices.get(i);
            total_detail = transD.total_details.get(i);
            member_name = transD.member_names.get(i);
            String rowData[] = {id_trans, product_name, quantity, "Rp. " +  product_price, "Rp. "+ total_detail, member_name};
            
            tableModel.addRow(rowData);
        }   
        BuiltSystem.debugLog("RefreshData() Completed");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        detailClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetail = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        totalAllDetail = new javax.swing.JLabel();
        memberName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 282));

        detailClose.setBackground(new java.awt.Color(96, 94, 161));
        detailClose.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        detailClose.setForeground(new java.awt.Color(255, 255, 255));
        detailClose.setText("close");
        detailClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        detailClose.setFocusCycleRoot(true);
        detailClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                detailCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                detailCloseMouseExited(evt);
            }
        });
        detailClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailCloseActionPerformed(evt);
            }
        });

        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Transaction_id", "Product", "Quantity", "Price /pcs", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDetail);
        if (tableDetail.getColumnModel().getColumnCount() > 0) {
            tableDetail.getColumnModel().getColumn(0).setResizable(false);
            tableDetail.getColumnModel().getColumn(1).setResizable(false);
            tableDetail.getColumnModel().getColumn(2).setResizable(false);
            tableDetail.getColumnModel().getColumn(3).setResizable(false);
            tableDetail.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        totalAllDetail.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        totalAllDetail.setForeground(new java.awt.Color(255, 255, 255));
        totalAllDetail.setText("Total : 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalAllDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(totalAllDetail)
                .addContainerGap())
        );

        memberName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        memberName.setText("Member :  ' '");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detailClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(memberName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void detailCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailCloseMouseExited
        detailClose.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_detailCloseMouseExited

    private void detailCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailCloseMouseEntered
        detailClose.setBackground(new Color(204, 43, 82));
    }//GEN-LAST:event_detailCloseMouseEntered

    private void detailCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_detailCloseMouseClicked

    private void detailCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detailClose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel memberName;
    private javax.swing.JTable tableDetail;
    private javax.swing.JLabel totalAllDetail;
    // End of variables declaration//GEN-END:variables
}
