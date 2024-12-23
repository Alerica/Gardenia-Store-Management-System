package transaction;

import cashier.*;
import gardeniastoremanagementsystem.BuiltSystem;
import gardeniastoremanagementsystem.GardeniaStoreManagementSystem;
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


public class Transactions {
    
    Connection connection;
    
    //transactions all
    ArrayList<String> ids_trans = new ArrayList<>();
    ArrayList<String> member_ids=new ArrayList<>();
    ArrayList<String> transaction_totals=new ArrayList<>();
    ArrayList<String> transaction_dates=new ArrayList<>();
    
    //return quantity to stock
    ArrayList<String> Jids_trans = new ArrayList<>();
    ArrayList<String> ids_products=new ArrayList<>();
    ArrayList<String> quantities=new ArrayList<>();
    ArrayList<String> product_stocks=new ArrayList<>();
    
    //detailtransaction table
    ArrayList<String> Dids_trans = new ArrayList<>();
    ArrayList<String> Dids_products = new ArrayList<>();
    ArrayList<String> Dquantities = new ArrayList<>();
    ArrayList<String> Dtotal_details = new ArrayList<>();

    
    Transactions() {
        CreateConnection();
        try {
            //INSERT INTO transactions (transaction_id, member_id, transaction_total, date_transaction) VALUES
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM transactions");
            while(result.next()) {
                
                String id_trans = result.getString("transaction_id").strip();
                String member_id = result.getString("member_id").strip();
                String transaction_total = result.getString("transaction_total").strip();
                String date_transaction = result.getString("date_transaction").strip();
                
                ids_trans.add(String.valueOf(result.getInt("transaction_id")));
                member_ids.add(String.valueOf(result.getInt("transaction_id")));
                transaction_totals.add(transaction_total);
                transaction_dates.add(date_transaction);
            }
            
            //join detailtransactions, products, transactions
            result = stmt.executeQuery("SELECT\n"
                    + "	d.product_id,\n"
                    + "	d.transaction_id,\n"
                    + "	d.quantity,\n"
                    + "	p.product_stock\n"
                    + "\n"
                    + "FROM detailtransactions d\n"
                    + "\n"
                    + "JOIN\n"
                    + "	transactions t ON d.transaction_id = t.transaction_id\n"
                    + "JOIN\n"
                    + "	products p ON d.product_id = p.product_id\n"
                    + "WHERE\n"
                    + "	d.transaction_id = t.transaction_id AND \n"
                    + "	d.product_id = p.product_id");

            
            while(result.next()) {
                
                String Jid_trans = result.getString("transaction_id").strip();
                String id_products = result.getString("product_id").strip();
                String quantity = result.getString("quantity").strip();
                String product_stock = result.getString("product_stock").strip();
                
                Jids_trans.add(Jid_trans);
                ids_products.add(id_products);
                quantities.add(quantity);
                product_stocks.add(product_stock);
            }
            
            result = stmt.executeQuery("SELECT * FROM detailtransactions");
            
            while(result.next()) {
                
                String Did_trans = result.getString("transaction_id").strip();
                String Did_products = result.getString("product_id").strip();
                String Dquantity= result.getString("quantity").strip();
                String Dtotal_detail = result.getString("total_detail").strip();
                
                Dids_trans.add(Did_trans);
                Dids_products.add(Did_products);
                Dquantities.add(Dquantity);
                Dtotal_details.add(Dtotal_detail);
                
            }
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }   
    
    void InsertDataTransaction(String member_id, String total) {
        try {
            int id = Integer.parseInt(ids_trans.get(ids_trans.size()- 1));
            id++;
            
            String transaction_date = BuiltSystem.getCurrentDateFormattedDatabase();
            Statement stmt = connection.createStatement();
            // INSERT INTO transactions VALUES (id, member_id, total, date);   
            String query = "INSERT INTO transactions VALUES(" + id + "," + member_id + "," +total + ",'" +transaction_date + "');";
            stmt.execute(query);
            stmt.close();
            
            ids_trans.add("" + id);
            member_ids.add(member_id);
            transaction_totals.add(total);
            transaction_dates.add(transaction_date);
            
            BuiltSystem.debugLog("Running InsertData()");
        } catch (SQLException ex) {
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void InsertDataDetailTransaction(String product_id, String quantity, String total) {
        try {
            int id = Integer.parseInt(ids_trans.get(ids_trans.size()- 1));
            
            String transaction_date = BuiltSystem.getCurrentDateFormattedDatabase();
            Statement stmt = connection.createStatement();
            // INSERT INTO detailtransactions VALUES (transaction_id, product_id, quantity, total_detail);  
            String query = "INSERT INTO detailtransactions VALUES(" + id + "," + product_id + "," +quantity + "," +total + ");";
            stmt.execute(query);
            stmt.close();
            
            BuiltSystem.debugLog("Running InsertData()");
        } catch (SQLException ex) {
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void DeleteData(String id_trans){
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM detailtransactions WHERE transaction_id = '" + id_trans + "';");
            System.out.println(BuiltSystem.getCurrentTime() + " Deleted detailtransaction with id " + id_trans);
            
            stmt.execute("DELETE FROM Transactions WHERE transaction_id = '" + id_trans + "';");
            System.out.println(BuiltSystem.getCurrentTime() + " Deleted transaction with id " + id_trans);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        for(int i = 0; i < ids_trans.size(); i++) {
            if(ids_trans.get(i).equals(id_trans)) {
                ids_trans.remove(i);
                member_ids.remove(i);
                transaction_totals.remove(i);
                transaction_dates.remove(i); 
                break;
            }
        }
        BuiltSystem.debugLog("DeletedData() Completed");
    }
    
    void CreateConnection(){
        String url = "jdbc:mysql://localhost:3306/gardenia";
        String username = "root"; // Default XAMPP MySQL username
        String password = "4321";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(BuiltSystem.getCurrentTime() + " Connection Success"); 
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}