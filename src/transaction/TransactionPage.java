package transaction;

//import members.*;
import gardeniastoremanagementsystem.BuiltSystem;
import gardeniastoremanagementsystem.GardeniaStoreManagementSystem;
import dashboard.MainPage;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import login.LoginPage;
import members.MemberPage;
import products.ProductPage;


public class TransactionPage extends javax.swing.JFrame {

    Connection connection;
    int trans_id;    
    int total_recap;
    
    public TransactionPage() {
        connection = BuiltSystem.CreateConnection(connection);
        initComponents();
        StartingComponent();
        RefreshData();
    }
    
    private void StartingComponent() {
        this.setVisible(true);
        this.setLocation(50,50);
        this.setSize(1300,512);
        this.setResizable(false);
        
        JTableHeader header = tableTrans.getTableHeader();
        
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Font verdanaFont = new Font("Verdana", Font.PLAIN, 14); // Font, style, size
        header.setFont(verdanaFont);
        header.setBackground(new Color(34, 23, 122));
        header.setForeground(Color.WHITE);   
        
        Transactions transactions = new Transactions();
        totalMember.setText("Total Transaction : " + transactions.ids_trans.size());
    }
    
    private void RefreshData() {
        BuiltSystem.debugLog("Running RefreshData()");
        
        DefaultTableModel tableModel = (DefaultTableModel)tableTrans.getModel();
        Transactions transactions = new Transactions();
        String id_trans, member_id, transaction_total, date_transaction;
        int size = transactions.ids_trans.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            id_trans = transactions.ids_trans.get(i);
            member_id = transactions.member_ids.get(i);
            transaction_total= transactions.transaction_totals.get(i);
            date_transaction = transactions.transaction_dates.get(i);
            String rowData[] = {id_trans, member_id, "Rp. " + transaction_total, date_transaction};
            tableModel.addRow(rowData);
        }   
        
        BuiltSystem.debugLog("RefreshData() Completed");
    }
    
        private void SearchData(){
        BuiltSystem.debugLog("Running SearchData()");
        DefaultTableModel tableModel = (DefaultTableModel)tableTrans.getModel();
        Transactions transactions = new Transactions();
        totalMember.setText("Total Transaksi : " + transactions.ids_trans.size());
        String id_trans, member_id, transaction_total, date_transaction;
        int size = transactions.ids_trans.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            String input = TransInputField.getText().toLowerCase();
            id_trans = String.valueOf(transactions.ids_trans.get(i));
            member_id = String.valueOf(transactions.member_ids.get(i));
            transaction_total= transactions.transaction_totals.get(i);
            date_transaction = transactions.transaction_dates.get(i);
            
            if(input.startsWith("@")) {
                if(id_trans.equalsIgnoreCase(input.substring(1, input.length()))) {
                    String rowData[] = {id_trans, member_id, "Rp. " + transaction_total, date_transaction};
                    tableModel.addRow(rowData);
                    break;
                }
            }
            if (id_trans.equals(input)||date_transaction.contains(input)) {
                String rowData[]={id_trans, member_id, "Rp. " + transaction_total, date_transaction};
                tableModel.addRow(rowData);
            }         
        }   
        BuiltSystem.debugLog("SearchData() Completed");
    }
    
    
    private void DeleteData() {
        BuiltSystem.debugLog("Running DeleteData()");
        DefaultTableModel tableModel = (DefaultTableModel)tableTrans.getModel();
        Transactions transactions = new Transactions();
        boolean valid = false;
        int size = transactions.ids_trans.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            String input;
            if(TransInputField.getText().startsWith("@")) {
                input = TransInputField.getText().toLowerCase().substring(1);
            } else {
                input = TransInputField.getText().toLowerCase();
            }
            
            String id = String.valueOf(transactions.ids_trans.get(i));
            if (id.equals(input)) {
                valid = true;
                TransactionDeleteConfirmation transactionDeleteConfirmation = new TransactionDeleteConfirmation(transactions.ids_trans.get(i));
                transactionDeleteConfirmation.setName("TransactionDeleteConfirmation");
                BuiltSystem.OpenWindow(transactionDeleteConfirmation, "TransactionDeleteConfirmation");
                id = String.valueOf(transactions.ids_trans.get(i));
                DeleteProductByTransID(input);
                BuiltSystem.debugLog("Delete from d.product success");
            }         
        }   
        
        if(!valid) {
            deleteWarning.setText("Delete must use Transaction ID!!");
        }
        BuiltSystem.debugLog("DeleteData() Completed");
    }
    
    private void DeleteDataByTable() {
        BuiltSystem.debugLog("Running DeleteDataByTable()");
        
        TransactionDeleteConfirmation transactionDeleteConfirmation = new TransactionDeleteConfirmation(String.valueOf(trans_id));
        transactionDeleteConfirmation.setName("TransactionDeleteConfirmation");
        BuiltSystem.OpenWindow(transactionDeleteConfirmation, "TransactionDeleteConfirmation");
        
        DeleteProductByTransID(String.valueOf(trans_id));
        BuiltSystem.debugLog("Delete from d.product success");
        BuiltSystem.debugLog("DeleteData() Completed");
    }
    
    private void DeleteProductByTransID(String input){
        Transactions trans = new Transactions();
        
        ReturnStockProduct(input);
        for (int i = 0; i < trans.Dids_trans.size(); i++) {
            if(trans.Dids_trans.get(i).equals(input)){
                BuiltSystem.debugLog("Product ID "+ trans.Dids_products.get(i) + " deleted from detail transactions");
                trans.Dids_trans.remove(i);
                trans.Dids_products.remove(i);
                trans.Dquantities.remove(i);
                trans.Dtotal_details.remove(i);
            }
        }   
    }
    
    private void ReturnStockProduct(String input){
        Transactions trans = new Transactions();
        connection = BuiltSystem.CreateConnection(connection);
        String product_last_update = BuiltSystem.getCurrentDateFormattedProduct();
        try{
          Statement stmt = connection.createStatement();
          
          List<String> updateProductIDList= new ArrayList();
          for (int i = 0; i <trans.Dids_trans.size(); i++) {
            if(trans.Dids_trans.get(i).equals(input)){
                String productID= trans.Dids_products.get(i);
                if(!updateProductIDList.equals(productID)){
                    updateProductIDList.add(productID);
                }
            }
          }
          
          for(String pID : updateProductIDList){
                String query = "UPDATE products p\n"
                        + "\n"
                        + "SET p.product_stock = p.product_stock + \n"
                        + "    (SELECT SUM(d.quantity)\n"
                        + "    FROM detailtransactions d\n"
                        + "    WHERE d.transaction_id = '" + input + "' AND \n"
                        + "    d.product_id = p.product_id),\n"
                        + "    p.product_last_update = '" + product_last_update + "'\n"
                        + "    \n"
                        + "WHERE p.product_id = '" + pID + "'\n"
                        + ";";
                stmt.execute(query);
                BuiltSystem.debugLog("Stock trans ID " + input + " with product_id "+ pID +" returned");
          }
        }catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        transactionButton = new javax.swing.JButton();
        memberButton = new javax.swing.JButton();
        productButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalMember = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTrans = new javax.swing.JTable();
        TransInputField = new javax.swing.JTextField();
        deleteButtonTrans = new javax.swing.JButton();
        deleteWarning = new javax.swing.JLabel();
        showButtonTrans = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 512));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(34, 23, 122));

        homeButton.setBackground(new java.awt.Color(34, 23, 122));
        homeButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setText("Home                ");
        homeButton.setAlignmentY(0.0F);
        homeButton.setBorder(null);
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
        });
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        transactionButton.setBackground(new java.awt.Color(34, 23, 122));
        transactionButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        transactionButton.setForeground(new java.awt.Color(255, 255, 255));
        transactionButton.setText("Transaction    ");
        transactionButton.setAlignmentY(0.0F);
        transactionButton.setBorder(null);
        transactionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transactionButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transactionButtonMouseExited(evt);
            }
        });

        memberButton.setBackground(new java.awt.Color(34, 23, 122));
        memberButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        memberButton.setForeground(new java.awt.Color(255, 255, 255));
        memberButton.setText("Member           ");
        memberButton.setAlignmentY(0.0F);
        memberButton.setBorder(null);
        memberButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                memberButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                memberButtonMouseExited(evt);
            }
        });
        memberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberButtonActionPerformed(evt);
            }
        });

        productButton.setBackground(new java.awt.Color(34, 23, 122));
        productButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        productButton.setForeground(new java.awt.Color(255, 255, 255));
        productButton.setText("Product           ");
        productButton.setAlignmentY(0.0F);
        productButton.setBorder(null);
        productButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productButtonMouseExited(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(34, 23, 122));
        exitButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("Exit                  ");
        exitButton.setAlignmentY(0.0F);
        exitButton.setBorder(null);
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gardenia");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(96, 94, 161));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gardenia / Transaction");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Transactions");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Store Management System");

        totalMember.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        totalMember.setText("Total Transaction : 1");

        tableTrans.setBackground(new java.awt.Color(96, 94, 161));
        tableTrans.setForeground(new java.awt.Color(255, 255, 255));
        tableTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Member ID", "Total", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTrans.setGridColor(new java.awt.Color(96, 94, 161));
        tableTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTransMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTrans);
        if (tableTrans.getColumnModel().getColumnCount() > 0) {
            tableTrans.getColumnModel().getColumn(0).setResizable(false);
            tableTrans.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableTrans.getColumnModel().getColumn(1).setResizable(false);
            tableTrans.getColumnModel().getColumn(1).setPreferredWidth(10);
            tableTrans.getColumnModel().getColumn(2).setResizable(false);
            tableTrans.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableTrans.getColumnModel().getColumn(3).setResizable(false);
        }

        TransInputField.setText("Search... use @ to find ID");
        TransInputField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TransInputFieldMouseEntered(evt);
            }
        });
        TransInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransInputFieldActionPerformed(evt);
            }
        });
        TransInputField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TransInputFieldPropertyChange(evt);
            }
        });
        TransInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TransInputFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TransInputFieldKeyTyped(evt);
            }
        });

        deleteButtonTrans.setBackground(new java.awt.Color(96, 94, 161));
        deleteButtonTrans.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        deleteButtonTrans.setForeground(new java.awt.Color(255, 255, 255));
        deleteButtonTrans.setText("Delete");
        deleteButtonTrans.setBorder(null);
        deleteButtonTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonTransMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonTransMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonTransMouseExited(evt);
            }
        });
        deleteButtonTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonTransActionPerformed(evt);
            }
        });

        deleteWarning.setForeground(new java.awt.Color(255, 0, 51));

        showButtonTrans.setBackground(new java.awt.Color(96, 94, 161));
        showButtonTrans.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        showButtonTrans.setForeground(new java.awt.Color(255, 255, 255));
        showButtonTrans.setText("Show");
        showButtonTrans.setBorder(null);
        showButtonTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showButtonTransMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showButtonTransMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showButtonTransMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteButtonTrans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TransInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(showButtonTrans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(deleteWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(totalMember, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalMember)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(deleteWarning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TransInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showButtonTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButtonTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("______________________________________");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                        .addComponent(memberButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transactionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transactionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        homeButton.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_homeButtonMouseEntered

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        BuiltSystem.debugLog("Home Button Clicked");
        BuiltSystem.CloseWindow(new MainPage().getName());   
    }//GEN-LAST:event_homeButtonMouseClicked

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        homeButton.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_homeButtonMouseExited

    private void memberButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberButtonMouseClicked
        BuiltSystem.debugLog("Member Button Clicked");
        BuiltSystem.CloseWindow(new MemberPage().getName());   
    }//GEN-LAST:event_memberButtonMouseClicked

    private void memberButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberButtonMouseEntered
        memberButton.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_memberButtonMouseEntered

    private void memberButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberButtonMouseExited
        memberButton.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_memberButtonMouseExited

    private void transactionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMouseClicked
        BuiltSystem.debugLog("Transaction Button Clicked");
        BuiltSystem.CloseWindow(new TransactionPage().getName());   
    }//GEN-LAST:event_transactionButtonMouseClicked

    private void transactionButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMouseEntered
        transactionButton.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_transactionButtonMouseEntered

    private void transactionButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMouseExited
        transactionButton.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_transactionButtonMouseExited

    private void productButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseClicked
        BuiltSystem.debugLog("Product Button Clicked");
        BuiltSystem.CloseWindow(new ProductPage().getName());   
    }//GEN-LAST:event_productButtonMouseClicked

    private void productButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseEntered
        productButton.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_productButtonMouseEntered

    private void productButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseExited
       productButton.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_productButtonMouseExited

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        BuiltSystem.debugLog("Exit Button Clicked");
        BuiltSystem.CloseWindow(new LoginPage().getName());    
    }//GEN-LAST:event_exitButtonMouseClicked

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        exitButton.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        exitButton.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_exitButtonMouseExited

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void memberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberButtonActionPerformed

    private void deleteButtonTransMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonTransMouseExited
        deleteButtonTrans.setBackground(new Color(96, 94, 161));
        
    }//GEN-LAST:event_deleteButtonTransMouseExited

    private void deleteButtonTransMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonTransMouseEntered
        deleteButtonTrans.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_deleteButtonTransMouseEntered

    private void deleteButtonTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonTransMouseClicked
        int selectedRow=tableTrans.getSelectedRow();
        if(selectedRow != -1) {
            DeleteDataByTable();
        } else {
            DeleteData();
        }
    }//GEN-LAST:event_deleteButtonTransMouseClicked

    private void TransInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransInputFieldActionPerformed
        SearchData();
    }//GEN-LAST:event_TransInputFieldActionPerformed

    private void TransInputFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TransInputFieldKeyPressed
        
    }//GEN-LAST:event_TransInputFieldKeyPressed

    private void TransInputFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TransInputFieldPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_TransInputFieldPropertyChange

    private void TransInputFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TransInputFieldKeyTyped
        SearchData();
    }//GEN-LAST:event_TransInputFieldKeyTyped

    private void TransInputFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransInputFieldMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TransInputFieldMouseEntered

    private void showButtonTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonTransMouseClicked
        BuiltSystem.debugLog("Show Button Clicked");
        TransactionShowDetailPage transactionShowDetailPage = new TransactionShowDetailPage(trans_id, total_recap);
        transactionShowDetailPage.setName("TransactionShowDetailPage");
        BuiltSystem.OpenWindow(transactionShowDetailPage, "TransactionShowDetailPage");
    }//GEN-LAST:event_showButtonTransMouseClicked

    private void showButtonTransMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonTransMouseEntered
        showButtonTrans.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_showButtonTransMouseEntered

    private void showButtonTransMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonTransMouseExited
        showButtonTrans.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_showButtonTransMouseExited

    private void deleteButtonTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonTransActionPerformed

    private void tableTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransMouseClicked
        int selectedRow=tableTrans.getSelectedRow();
        if(selectedRow != -1){
            trans_id= Integer.parseInt(tableTrans.getValueAt(selectedRow, 0).toString());
            total_recap = Integer.parseInt(tableTrans.getValueAt(selectedRow, 2).toString().substring(4));
        }
        else{
            System.out.println("row not selected");
        }
        System.out.println("trans_id :" +  trans_id);
        System.out.println("selectedRow : " + selectedRow);
        System.out.println("total recap : "+ total_recap);
        
        Transactions trans=new Transactions();
        for (int i = 0; i <trans.Dids_trans.size(); i++) {
            if(trans.Dids_trans.get(i).equals(String.valueOf(trans_id))){
                String productID= trans.Dids_products.get(i);
                int quantity = Integer.parseInt(trans.Dquantities.get(i));
                
                System.out.println("product ID : "+ productID +" return quantity "+ quantity);
            }
        }
    }//GEN-LAST:event_tableTransMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TransInputField;
    private javax.swing.JButton deleteButtonTrans;
    private javax.swing.JLabel deleteWarning;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton memberButton;
    private javax.swing.JButton productButton;
    private javax.swing.JButton showButtonTrans;
    private javax.swing.JTable tableTrans;
    private javax.swing.JLabel totalMember;
    private javax.swing.JButton transactionButton;
    // End of variables declaration//GEN-END:variables

}
