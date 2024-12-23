package cashier;

import gardeniastoremanagementsystem.BuiltSystem;
import gardeniastoremanagementsystem.GardeniaStoreManagementSystem;
import members.MemberPage;
import javax.swing.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import login.LoginPage;
import transaction.TransactionPage;

public class CashierPage extends javax.swing.JFrame {

    Connection connection;
    ArrayList<CartItem> cartItems = new ArrayList<>();
    String lastInsertedID = "";
    
    public CashierPage() {
        initComponents();
        connection = BuiltSystem.CreateConnection(connection);
        JFrame frame = new JFrame();
        this.setVisible(true);
        this.setLocation(50,50);
        this.setSize(1300,600);
        this.setResizable(false);
        
        RefreshData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        inputField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        itemSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        changeLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        paymentField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        memberField = new javax.swing.JTextField();
        memberLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        inputField.setBackground(new java.awt.Color(255, 255, 255));
        inputField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        inputField.setForeground(new java.awt.Color(102, 102, 102));
        inputField.setText("Enter Product ID");
        inputField.setBorder(null);

        jLabel1.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("/ Product");

        jLabel2.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Gardenia");

        jButton2.setBackground(new java.awt.Color(96, 94, 161));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLOSE");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        productTable.setBackground(new java.awt.Color(255, 255, 255));
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Stock", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(1).setPreferredWidth(250);
            productTable.getColumnModel().getColumn(2).setResizable(false);
            productTable.getColumnModel().getColumn(2).setPreferredWidth(10);
            productTable.getColumnModel().getColumn(3).setResizable(false);
        }

        addButton.setBackground(new java.awt.Color(96, 94, 161));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("ADD");
        addButton.setBorder(null);
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(96, 94, 161));
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("REMOVE");
        removeButton.setBorder(null);
        removeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeButtonMouseClicked(evt);
            }
        });

        itemSpinner.setValue(1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(itemSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jLabel3.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cart");

        jButton1.setBackground(new java.awt.Color(96, 94, 161));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DONE");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(245, 240, 205));

        changeLabel.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        changeLabel.setForeground(new java.awt.Color(0, 0, 0));
        changeLabel.setText("change   : 0");

        totalLabel.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalLabel.setText("total        : 0");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        jLabel6.setText("____________________________________");

        jLabel7.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("payment :");

        paymentField.setBackground(new java.awt.Color(255, 255, 255));
        paymentField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        paymentField.setForeground(new java.awt.Color(102, 102, 102));
        paymentField.setText("0");
        paymentField.setBorder(null);
        paymentField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paymentFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(changeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(paymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changeLabel)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        cartTable.setBackground(new java.awt.Color(255, 255, 255));
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cartTable);
        if (cartTable.getColumnModel().getColumnCount() > 0) {
            cartTable.getColumnModel().getColumn(0).setResizable(false);
            cartTable.getColumnModel().getColumn(0).setPreferredWidth(250);
            cartTable.getColumnModel().getColumn(1).setResizable(false);
            cartTable.getColumnModel().getColumn(1).setPreferredWidth(10);
            cartTable.getColumnModel().getColumn(2).setResizable(false);
            cartTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        }

        memberField.setBackground(new java.awt.Color(204, 204, 204));
        memberField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        memberField.setForeground(new java.awt.Color(102, 102, 102));
        memberField.setText(" member phone number (just leave it for guest) ");
        memberField.setBorder(null);
        memberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberFieldActionPerformed(evt);
            }
        });
        memberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                memberFieldKeyPressed(evt);
            }
        });

        memberLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        memberLabel.setForeground(new java.awt.Color(0, 153, 51));
        memberLabel.setText("                  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                                    .addComponent(memberField)
                                    .addComponent(memberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(memberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memberField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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

    private void RefreshData() {
        BuiltSystem.debugLog("Running RefreshData()");
        
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
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
            String rowData[] = {product_id, name, stock, price};
            tableModel.addRow(rowData);
        }   
        
        BuiltSystem.debugLog("RefreshData() Completed");
    }
    
    private void AddToCart(String product, String price) {
        BuiltSystem.debugLog("Running AddToCart()");
        DefaultTableModel tableModel = (DefaultTableModel) cartTable.getModel();
//        int total_row = tableModel.getRowCount();
//        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        String rowData[] = {product, "1", price};
        tableModel.addRow(rowData);
    }
    
    
    private void AddItemToCart(String ID, String name, int quantity, int price) {
        Products products = new Products();
        boolean notExisted = true;
        int stock = 0;
        for(int i = 0; i < cartItems.size(); i++) {
            String tempID = cartItems.get(i).ID;
            if(tempID.equals(ID)) {
                notExisted = false;
                for( int j = 0;  j < products.product_ids.size(); j++) {
                    if(products.product_ids.get(j).equals(cartItems.get(i).ID)) {
                        stock = Integer.parseInt(products.product_stocks.get(j));
                        break;
                    }
                }
                if(cartItems.get(i).quantity < stock) {
                    cartItems.get(i).AddQuantity(quantity);
                }
                
                break;
            }
        }
        
        if (notExisted) {
            CartItem item = new CartItem(ID, name, quantity, price);
            cartItems.add(item);
        }    
    }
    
    private void RemoveItemToCart(String ID, String name, int quantity, int price) {
        for(int i = 0; i < cartItems.size(); i++) {
            String tempID = cartItems.get(i).ID;
            if(tempID.equals(ID)) {
                if(cartItems.get(i).quantity > 1) {
                    cartItems.get(i).RemoveQuantity(quantity);
                    if(cartItems.get(i).quantity == 0) cartItems.remove(i);
                } else {
                    cartItems.remove(i);
                }
                break;
            }
        }
    }
    
    private void RefreshTotal() {
        int total = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            total += (cartItems.get(i).price * cartItems.get(i).quantity);
        }
        totalLabel.setText("total        : " + total);
        
        try {
            String inputPayment = paymentField.getText();
            int change = Integer.parseInt(inputPayment) - total;
            if (change < 0) {
                // Do Nothing
            } else {
                changeLabel.setText("change   : " + change);
            }        
        } catch (Exception e) {
            System.out.println("You Entered Non Integer");
        }
        
    }
    
    private void RefreshCart() {
        BuiltSystem.debugLog("Running RefreshCart()");
        
        DefaultTableModel tableModel = (DefaultTableModel) cartTable.getModel();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        
        for (int i = 0; i < cartItems.size(); i++) {
            String product = cartItems.get(i).name;
            String quantity = cartItems.get(i).getQuantityAsString();
            String total = String.valueOf(cartItems.get(i).getQuantity() * cartItems.get(i).getPrice());
            String price = "Rp. "  + total;
            String rowData[] = {product, quantity, price};
            tableModel.addRow(rowData);
        }
        RefreshTotal();
    }
    
    
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        new LoginPage();
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        int selectedRow= productTable.getSelectedRow();
        Products products = new Products();
        
        if(Integer.parseInt(products.product_stocks.get(selectedRow)) < 1) {
            return;
        }
        
        if(selectedRow != -1) {
            String name = products.product_names.get(selectedRow);
            String price = products.product_prices.get(selectedRow);
            int repeat = Integer.parseInt(itemSpinner.getValue().toString());
            int currentStock = Integer.parseInt(products.product_stocks.get(selectedRow));
            int cartStock = 0;
            for(int i = 0; i < cartItems.size(); i++) {
                if(Integer.parseInt(cartItems.get(i).ID) == Integer.parseInt(products.product_ids.get(selectedRow))) {
                    cartStock = cartItems.get(i).quantity;
                }
            }
            
            System.out.println(cartStock);
            
            
            if(repeat > 0 ) {
                if(repeat <= currentStock - cartStock) AddItemToCart(products.product_ids.get(selectedRow), name, repeat, Integer.parseInt(price));
                else AddItemToCart(products.product_ids.get(selectedRow), name, currentStock - cartStock, Integer.parseInt(price));
                lastInsertedID = products.product_ids.get(selectedRow);
            }
            System.out.println(products.product_ids.get(selectedRow)+ name+ 1+ Integer.parseInt(price));
        } else {
            String input = inputField.getText();
            
            try {
                int searchID = Integer.parseInt(input);
                for(int i = 0; i < products.product_ids.size(); i++) {
                    if(Integer.parseInt(products.product_ids.get(i)) == searchID) {
                        String name = products.product_names.get(i);
                        String price = products.product_prices.get(i);
                        int repeat = Integer.parseInt(itemSpinner.getValue().toString());
                        int currentStock = Integer.parseInt(products.product_stocks.get(searchID));
                        
                        int cartStock = 0;
                        for(int j = 0; j < cartItems.size(); j++) {
                            if(Integer.parseInt(cartItems.get(j).ID) == searchID) {
                                cartStock = cartItems.get(j).quantity;
                            }
                        }
                        
                        System.out.println(cartStock);
                        
                        if(repeat > 0) {
                            if(repeat <= currentStock - cartStock) AddItemToCart(products.product_ids.get(i), name, repeat, Integer.parseInt(price));
                            else AddItemToCart(products.product_ids.get(i), name, currentStock - cartStock, Integer.parseInt(price));
                            lastInsertedID = products.product_ids.get(i);
                        }
                        System.out.println(products.product_ids.get(i)+ name+ 1+ Integer.parseInt(price));
                    }
                }
            } catch (Exception e) {
                System.out.println("Something goes wrong!");
            }
        }
        RefreshCart();
    }//GEN-LAST:event_addButtonMouseClicked

    private void paymentFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paymentFieldKeyPressed
        RefreshTotal();
    }//GEN-LAST:event_paymentFieldKeyPressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int total = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            total += (cartItems.get(i).price * cartItems.get(i).quantity);
        }
        
        if (Integer.parseInt(paymentField.getText()) - total < 0) return;
        
        Transactions transactions = new Transactions();
        Products products = new Products();
        Members members = new Members();
        String input = memberField.getText();
        String member_id = "";
        boolean memberFound = false;
        for(int i = 0; i < members.ids.size();i++) {
            if(members.phone_numbers.get(i).equalsIgnoreCase(input)) {
                memberLabel.setText("Member Found!");
                member_id = members.ids.get(i);
                memberFound = true;
                break;
            }
        }
        if (!memberFound) {
            member_id = "0";
        }
        
       
        
        if(total > 0) {
            transactions.InsertDataTransaction(member_id, String.valueOf(total));
            for (int i = 0; i < cartItems.size(); i++) {
                String product_id = cartItems.get(i).ID;
                String quantity = String.valueOf(cartItems.get(i).quantity);
                String total_detail = String.valueOf(cartItems.get(i).quantity * cartItems.get(i).price);
                transactions.InsertDataDetailTransaction(product_id, quantity, total_detail);
                products.RemoveStock(product_id, quantity);
            }
        }
        
        
        new CashierPage();
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void removeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseClicked
        String input = inputField.getText();
        Products products = new Products();
        int repeat = Integer.parseInt(itemSpinner.getValue().toString());
      
        
        int selectedRow= cartTable.getSelectedRow();
        
        if(selectedRow == -1 && !(cartItems.isEmpty())) {
            try {
                Integer.parseInt(input);
            } catch (Exception e) {
                
                int cartStock = cartItems.get(cartItems.size()-1).quantity;
                if(repeat <= 0) return;

                if (repeat <= cartStock ) RemoveItemToCart(lastInsertedID, "", repeat, 0);
                else RemoveItemToCart(lastInsertedID, "", cartStock, 0);
                RefreshCart();
                return;
            }    
        }
        
        if( selectedRow != -1) {
            int searchID = Integer.parseInt(cartItems.get(selectedRow).getID());
            for(int i = 0; i < products.product_ids.size(); i++) {
                if(Integer.parseInt(products.product_ids.get(i)) == searchID) {
                    String name = products.product_names.get(i);
                    String price = products.product_prices.get(i);
                    
                    
                    int cartStock = 0;
                    for(int j = 0; j < cartItems.size(); j++) {
                        if(Integer.parseInt(cartItems.get(j).ID) == Integer.parseInt(products.product_ids.get(i))) {
                            cartStock = cartItems.get(j).quantity;
                        }
                    }

                    System.out.println(cartStock);


                    if(repeat > 0 ) {
                        if(repeat <= cartStock) RemoveItemToCart(products.product_ids.get(i), name, repeat, Integer.parseInt(price));
                        else RemoveItemToCart(products.product_ids.get(i), name, cartStock, Integer.parseInt(price));
                    }
                    
                    System.out.println(products.product_ids.get(i)+ name+ 1+ Integer.parseInt(price));
                }
            }
        } else {
            try {
                int searchID = Integer.parseInt(input);
                for(int i = 0; i < products.product_ids.size(); i++) {
                    if(Integer.parseInt(products.product_ids.get(i)) == searchID) {
                        String name = products.product_names.get(i);
                        String price = products.product_prices.get(i);
                        int cartStock = 0;
                        for(int j = 0; j < cartItems.size(); j++) {
                            if(Integer.parseInt(cartItems.get(j).ID) == Integer.parseInt(products.product_ids.get(i))) {
                                cartStock = cartItems.get(j).quantity;
                            }
                        }

                        System.out.println(cartStock);

                        if(repeat > 0 ) {
                            if(repeat <= cartStock) RemoveItemToCart(products.product_ids.get(i), name, repeat, Integer.parseInt(price));
                            else RemoveItemToCart(products.product_ids.get(i), name, cartStock, Integer.parseInt(price));
                        }

                        System.out.println(products.product_ids.get(i)+ name+ 1+ Integer.parseInt(price));
                    }
                }
            } catch (Exception e) {
                System.out.println("Something goes wrong!");
            }
        }
        RefreshCart();
    }//GEN-LAST:event_removeButtonMouseClicked

    private void memberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberFieldKeyPressed
        Members members = new Members();
        String input = memberField.getText();
        for(int i = 0; i < members.ids.size();i++) {
            if(members.phone_numbers.get(i).equalsIgnoreCase(input)) {
                memberLabel.setText("Member " + members.names.get(i) + " Found!");
                break;
            }
        }
    }//GEN-LAST:event_memberFieldKeyPressed

    private void memberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable cartTable;
    private javax.swing.JLabel changeLabel;
    private javax.swing.JTextField inputField;
    private javax.swing.JSpinner itemSpinner;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField memberField;
    private javax.swing.JLabel memberLabel;
    private javax.swing.JTextField paymentField;
    private javax.swing.JTable productTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
