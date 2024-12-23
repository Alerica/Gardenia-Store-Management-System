package products;

import members.*;
import gardeniastoremanagementsystem.BuiltSystem;
import dashboard.MainPage;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import login.LoginPage;
import suppliers.SupplierShowPage;
import transaction.TransactionPage;


public class ProductPage extends javax.swing.JFrame {

    Connection connection;
    
    public ProductPage() {
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
        
        JTableHeader header = tableProducts.getTableHeader();
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Font verdanaFont = new Font("Verdana", Font.PLAIN, 14); // Font, style, size
        header.setFont(verdanaFont);
        header.setBackground(new Color(34, 23, 122));
        header.setForeground(Color.WHITE);   
        
        Products products = new Products();
        totalProduct.setText("Total Products : " + products.product_ids.size());
    }
    
    private void RefreshData() {
        BuiltSystem.debugLog("Running RefreshData()");
        
        DefaultTableModel tableModel = (DefaultTableModel)tableProducts.getModel();
        Products products = new Products();
        String product_id, category_name, name, stock, last_update, price;
        int size = products.product_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            product_id = products.product_ids.get(i);
            category_name = products.category_names.get(i);
            name = products.product_names.get(i);
            stock = products.product_stocks.get(i);
            last_update = products.product_last_updates.get(i);
            price = products.product_prices.get(i);
            String rowData[] = {product_id, category_name, name, stock, last_update, price};
            tableModel.addRow(rowData);
        }   
        
        BuiltSystem.debugLog("RefreshData() Completed");
    }
    
    private void SearchData(){
        BuiltSystem.debugLog("Running SearchData()");
        DefaultTableModel tableModel = (DefaultTableModel)tableProducts.getModel();
        Products products = new Products();
        totalProduct.setText("Total Member : " + products.product_ids.size());
        String product_id, category_name, name, stock, last_update, price;
        int size = products.product_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            String input = memberInputField.getText().toLowerCase();
            product_id = products.product_ids.get(i);
            category_name = products.category_names.get(i);
            name = products.product_names.get(i).toLowerCase();
            stock = products.product_stocks.get(i);
            last_update = products.product_last_updates.get(i);
            price = products.product_prices.get(i);
            if(input.startsWith("@")) {
                if(product_id.equalsIgnoreCase(input.substring(1, input.length()))) {
                    String rowData[] = {product_id, products.category_names.get(i), products.product_names.get(i), stock, last_update, price};
                    tableModel.addRow(rowData);
                    break;
                }
            }
            if (product_id.equals(input) || category_name.contains(input)||name.contains(input) || stock.contains(input) || last_update.contains(input) || price.equals(input)) {
                String rowData[] = {product_id, products.category_names.get(i), products.product_names.get(i), stock, last_update, price};
                tableModel.addRow(rowData);
            }         
        }   
        BuiltSystem.debugLog("SearchData() Completed");
    }
    
    private void DeleteData(){
        BuiltSystem.debugLog("Running DeleteData()");
        DefaultTableModel tableModel = (DefaultTableModel)tableProducts.getModel();
        Products products = new Products();
        String id;
        boolean valid = false;
        int size = products.product_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            String input;
            if(memberInputField.getText().startsWith("@")) {
                input = memberInputField.getText().toLowerCase().substring(1);
            } else {
                input = memberInputField.getText().toLowerCase();
            }
            
            id = products.product_ids.get(i);
            String stock_now = products.product_stocks.get(i);
            String price_now = products.product_prices.get(i);
            if (id.equals(input)) {
                valid = true;
                ProductStockDelete productStockDelete =  new ProductStockDelete(products.product_names.get(i), id, stock_now, price_now);
                productStockDelete.setName("ProductStockDelete");
                BuiltSystem.OpenWindow(productStockDelete, "ProductStockDelete");
            }         
        }   
        
        if(!valid) {
            deleteWarning.setText("Delete must use stock ID!!");
        }
        RefreshData();
        BuiltSystem.debugLog("DeleteData() Completed");
    }
    
    private void InsertData(){
        BuiltSystem.debugLog("Running InsertData()");
        DefaultTableModel tableModel = (DefaultTableModel)tableProducts.getModel();
        Products products = new Products();
        String id;
        boolean valid = false;
        int size = products.product_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            String input;
            if(memberInputField.getText().startsWith("@")) {
                input = memberInputField.getText().toLowerCase().substring(1);
            } else {
                input = memberInputField.getText().toLowerCase();
            }
            id = products.product_ids.get(i);
            String stock_now = products.product_stocks.get(i);
            String price_now = products.product_prices.get(i);
            if (id.equals(input)) {
                valid = true;
                ProductStockInsert productStockInsert =  new ProductStockInsert(products.product_names.get(i), id, stock_now, price_now);
                productStockInsert.setName("ProductStockInsert");
                BuiltSystem.OpenWindow(productStockInsert, "ProductStockInsert");
            }         
        }   
        
        if(!valid) {
            deleteWarning.setText("Insert must use stock ID!!");
        }
        
        RefreshData();
        
        BuiltSystem.debugLog("*InsertData() Completed");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        memberButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalProduct = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        memberInputField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        InsertButton = new javax.swing.JButton();
        deleteWarning = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        ShowSupplierButton = new javax.swing.JButton();
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

        jButton5.setBackground(new java.awt.Color(34, 23, 122));
        jButton5.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Transaction    ");
        jButton5.setAlignmentY(0.0F);
        jButton5.setBorder(null);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
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

        jButton6.setBackground(new java.awt.Color(34, 23, 122));
        jButton6.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Product           ");
        jButton6.setAlignmentY(0.0F);
        jButton6.setBorder(null);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(34, 23, 122));
        jButton7.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Exit                  ");
        jButton7.setAlignmentY(0.0F);
        jButton7.setBorder(null);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gardenia");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(96, 94, 161));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gardenia / Prodcut");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Products");

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
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Store Management System");

        totalProduct.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        totalProduct.setText("Total Product : 1");

        tableProducts.setBackground(new java.awt.Color(96, 94, 161));
        tableProducts.setForeground(new java.awt.Color(255, 255, 255));
        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Category", "Name", "Stock", "Last Update", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProducts.setGridColor(new java.awt.Color(96, 94, 161));
        jScrollPane1.setViewportView(tableProducts);
        if (tableProducts.getColumnModel().getColumnCount() > 0) {
            tableProducts.getColumnModel().getColumn(0).setResizable(false);
            tableProducts.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableProducts.getColumnModel().getColumn(1).setResizable(false);
            tableProducts.getColumnModel().getColumn(2).setResizable(false);
            tableProducts.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableProducts.getColumnModel().getColumn(3).setResizable(false);
            tableProducts.getColumnModel().getColumn(3).setPreferredWidth(5);
            tableProducts.getColumnModel().getColumn(4).setResizable(false);
            tableProducts.getColumnModel().getColumn(5).setResizable(false);
        }

        memberInputField.setText("Search... use @ to find ID");
        memberInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberInputFieldActionPerformed(evt);
            }
        });
        memberInputField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                memberInputFieldPropertyChange(evt);
            }
        });
        memberInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                memberInputFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                memberInputFieldKeyTyped(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(96, 94, 161));
        deleteButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete Stock");
        deleteButton.setBorder(null);
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        InsertButton.setBackground(new java.awt.Color(96, 94, 161));
        InsertButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        InsertButton.setForeground(new java.awt.Color(255, 255, 255));
        InsertButton.setText("Insert Product");
        InsertButton.setBorder(null);
        InsertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InsertButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InsertButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InsertButtonMouseExited(evt);
            }
        });
        InsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButtonActionPerformed(evt);
            }
        });

        deleteWarning.setForeground(new java.awt.Color(255, 0, 51));

        updateButton.setBackground(new java.awt.Color(96, 94, 161));
        updateButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Insert Stock");
        updateButton.setBorder(null);
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateButtonMouseExited(evt);
            }
        });
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        ShowSupplierButton.setBackground(new java.awt.Color(96, 94, 161));
        ShowSupplierButton.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        ShowSupplierButton.setForeground(new java.awt.Color(255, 255, 255));
        ShowSupplierButton.setText("Supplier List");
        ShowSupplierButton.setBorder(null);
        ShowSupplierButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowSupplierButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ShowSupplierButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ShowSupplierButtonMouseExited(evt);
            }
        });
        ShowSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowSupplierButtonActionPerformed(evt);
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
                                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(memberInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(InsertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowSupplierButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                .addComponent(totalProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(totalProduct)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(deleteWarning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memberInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ShowSupplierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(137, Short.MAX_VALUE))
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
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        BuiltSystem.debugLog("Transaction Button Clicked");
        BuiltSystem.CloseWindow(new TransactionPage().getName());   
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jButton5.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        BuiltSystem.debugLog("Product Button Clicked");
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
       jButton6.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        BuiltSystem.debugLog("Exit Button Clicked");
        BuiltSystem.CloseWindow(new LoginPage().getName());   
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        jButton7.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        jButton7.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_jButton7MouseExited

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void memberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberButtonActionPerformed

    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseExited
        deleteButton.setBackground(new Color(96, 94, 161));
        
    }//GEN-LAST:event_deleteButtonMouseExited

    private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseEntered
        deleteButton.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_deleteButtonMouseEntered

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        DeleteData();
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void InsertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertButtonMouseClicked
        BuiltSystem.debugLog("Insert Button Clicked");
        ProductRegistration productRegistration = new ProductRegistration();
        productRegistration.setName("ProductRegistration");
        BuiltSystem.OpenWindow(productRegistration, "ProductRegistration");
        RefreshData();
    }//GEN-LAST:event_InsertButtonMouseClicked

    private void InsertButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertButtonMouseEntered
        InsertButton.setBackground(new Color(34, 23, 122));
    }//GEN-LAST:event_InsertButtonMouseEntered

    private void InsertButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertButtonMouseExited
        InsertButton.setBackground(new Color(96, 94, 161));
    }//GEN-LAST:event_InsertButtonMouseExited

    private void InsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertButtonActionPerformed

    private void memberInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberInputFieldActionPerformed
        SearchData();
    }//GEN-LAST:event_memberInputFieldActionPerformed

    private void memberInputFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberInputFieldKeyPressed
        
    }//GEN-LAST:event_memberInputFieldKeyPressed

    private void memberInputFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_memberInputFieldPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_memberInputFieldPropertyChange

    private void memberInputFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberInputFieldKeyTyped
        SearchData();
    }//GEN-LAST:event_memberInputFieldKeyTyped

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        BuiltSystem.debugLog("Update Button Clicked");
        InsertData();
    }//GEN-LAST:event_updateButtonMouseClicked

    private void updateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonMouseEntered

    private void updateButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonMouseExited

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void ShowSupplierButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowSupplierButtonMouseClicked
        new SupplierShowPage();
        SupplierShowPage supplierShowPage = new SupplierShowPage();
        supplierShowPage.setName("SupplierShowPage");
        BuiltSystem.OpenWindow(supplierShowPage, "SupplierShowPage");
    }//GEN-LAST:event_ShowSupplierButtonMouseClicked

    private void ShowSupplierButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowSupplierButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ShowSupplierButtonMouseEntered

    private void ShowSupplierButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowSupplierButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ShowSupplierButtonMouseExited

    private void ShowSupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowSupplierButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShowSupplierButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InsertButton;
    private javax.swing.JButton ShowSupplierButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteWarning;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
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
    private javax.swing.JTextField memberInputField;
    private javax.swing.JTable tableProducts;
    private javax.swing.JLabel totalProduct;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
