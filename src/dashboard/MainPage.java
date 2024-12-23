package dashboard;

import gardeniastoremanagementsystem.BuiltSystem;
import gardeniastoremanagementsystem.GardeniaStoreManagementSystem;
import members.MemberPage;
import java.awt.Color;
import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.LoginPage;
import products.ProductPage;
import transaction.TransactionPage;
import transaction.Transactions;


public class MainPage extends javax.swing.JFrame {

    Connection connection;
    
    public MainPage() {
        connection = BuiltSystem.CreateConnection(connection);
        initComponents();
        
        StartingComponent();
        LastTransactionSummary();
    }
    
    public MainPage(String username) {
        connection = BuiltSystem.CreateConnection(connection);
        initComponents();
        StartingComponent();
        if(username.equals(" username")) {
            jLabel15.setText("Hello User!");
        } else {
            jLabel15.setText("Hello " + username + "!");
        }
        
        LastTransactionSummary();
    }
    
    private void StartingComponent() {
        this.setVisible(true);
        this.setLocation(50,50);
        this.setSize(1300,512);
        this.setResizable(false);
        
        totalSummary.setText("Rp. " + GetSummary() );
        incomeThisMonth.setText("Rp. " + GetSummaryThisMonth());
        incomeLastMonth.setText("Rp. " + GetSummaryLastMonth());
    }
    
    private void LastTransactionSummary() {
        Transactions transactions = new Transactions();
        String[] total = {null, null, null};
        for(int i = 1; i < 4; i++) {
            total[i-1] = transactions.transaction_totals.get(transactions.transaction_totals.size() - i);
        }
        
        transaction1.setText("Rp. " + total[0] + " on " + transactions.transaction_dates.get(transactions.transaction_totals.size() - 1)   );
        transaction2.setText("Rp. " + total[1] + " on " + transactions.transaction_dates.get(transactions.transaction_totals.size() - 2)   );
        transaction3.setText("Rp. " + total[2] + " on " + transactions.transaction_dates.get(transactions.transaction_totals.size() - 3)   );
    }
    

    
    int GetSummary() {
        int total = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Transactions");
            while(result.next()) {
                String date = result.getString("date_transaction");
                String value = result.getString("transaction_total");
                String currentYear = date.substring(0,4);
                if(currentYear.equals(Integer.toString(BuiltSystem.getCurrentYearAsNumber()))) {
                    total += (int) Double.parseDouble(value);
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    int GetSummaryThisMonth() {
        int total = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Transactions");
            while(result.next()) {
                String date = result.getString("date_transaction");
                String value = result.getString("transaction_total");
                String currentMonth = date.substring( 5, 7);
                String currentYear = date.substring(0,4);
                if(currentMonth.equals(Integer.toString(BuiltSystem.getCurrentMonthAsNumber())) && currentYear.equals(Integer.toString(BuiltSystem.getCurrentYearAsNumber()))) {
                    total += (int) Double.parseDouble(value);
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    int GetSummaryLastMonth() {
        int total = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Transactions");
            while(result.next()) {
                String date = result.getString("date_transaction");
                String value = result.getString("transaction_total");
                String currentMonth = date.substring( 5, 7);
                String currentYear = date.substring(0,4);
                if(currentMonth.equals(Integer.toString(BuiltSystem.getCurrentMonthAsNumber() - 1)) && currentYear.equals(Integer.toString(BuiltSystem.getCurrentYearAsNumber()))) {
                    total += (int) Double.parseDouble(value);
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
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
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        incomeLastMonth = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalSummary = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        incomeThisMonth = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        transaction1 = new javax.swing.JLabel();
        transaction2 = new javax.swing.JLabel();
        transaction3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        jLabel4.setText("Gardenia / Home");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Home ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel4.setBackground(new java.awt.Color(96, 94, 161));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last month");

        incomeLastMonth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        incomeLastMonth.setForeground(new java.awt.Color(255, 255, 255));
        incomeLastMonth.setText("Rp. 57.000.000");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Income Summary");

        totalSummary.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        totalSummary.setForeground(new java.awt.Color(255, 255, 255));
        totalSummary.setText("Rp. 237.451.000");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("This month");

        incomeThisMonth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        incomeThisMonth.setForeground(new java.awt.Color(255, 255, 255));
        incomeThisMonth.setText("Rp. 180.451.000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(incomeThisMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(incomeLastMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel5)))
                        .addContainerGap(40, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel7)
                    .addContainerGap(139, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(totalSummary)
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(incomeLastMonth)
                    .addComponent(incomeThisMonth))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel7)
                    .addContainerGap(152, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(96, 94, 161));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Last Transaction");

        transaction1.setForeground(new java.awt.Color(255, 255, 255));
        transaction1.setText("20/11/2024 by 2989 : Rp. 50.000");

        transaction2.setForeground(new java.awt.Color(255, 255, 255));
        transaction2.setText("20/11/2024 by 2322 : Rp. 425.000");

        transaction3.setForeground(new java.awt.Color(255, 255, 255));
        transaction3.setText("20/11/2024 by 4523 : Rp. 19.000");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transaction2)
                            .addComponent(transaction1)
                            .addComponent(transaction3))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(transaction1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transaction2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transaction3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel16.setText("This year report");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel incomeLastMonth;
    private javax.swing.JLabel incomeThisMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton memberButton;
    private javax.swing.JButton productButton;
    private javax.swing.JLabel totalSummary;
    private javax.swing.JLabel transaction1;
    private javax.swing.JLabel transaction2;
    private javax.swing.JLabel transaction3;
    private javax.swing.JButton transactionButton;
    // End of variables declaration//GEN-END:variables
}
