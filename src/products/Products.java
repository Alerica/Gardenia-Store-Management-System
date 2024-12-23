package products;

import products.*;
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


public class Products {
    
    Connection connection;
    //Products Table
    public ArrayList<String> product_ids = new ArrayList<>();
    public ArrayList<String> category_ids = new ArrayList<>();
    public ArrayList<String> product_names = new ArrayList<>();            
    public ArrayList<String> product_stocks = new ArrayList<>();
    public ArrayList<String> product_last_updates = new ArrayList<>();
    public ArrayList<String> product_prices = new ArrayList<>();
    public ArrayList<String> category_names = new ArrayList<>();
    
    //Category List
    public ArrayList<String> category_list_ids = new ArrayList<>();
    public ArrayList<String> category_list_names = new ArrayList<>();
    
    public Products() {
        connection = BuiltSystem.CreateConnection(connection);
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(
                    "SELECT P.product_id, P.category_id, C.category_name, P.product_name, P.product_stock, P.product_last_update, P.product_price " +
                    "FROM products P " +
                    "JOIN categories C ON C.category_id = P.category_id "
                  + "ORDER BY P.product_id asc");
            while(result.next()) { 
                String product_id = result.getString("product_id").strip();
                String category_id = result.getString("category_id").strip();
                String product_name = result.getString("product_name").strip();
                String product_stock = result.getString("product_stock").strip();
                String product_last_update = result.getString("product_last_update").strip();
                String product_price = result.getString("product_price").strip();
                String category_name = result.getString("category_name").strip();
                
                product_ids.add(product_id);
                category_ids.add(category_id);
                product_names.add(product_name);
                product_stocks.add(product_stock);
                product_last_updates.add(product_last_update);
                product_prices.add(product_price);
                category_names.add(category_name);
            }
            result = stmt.executeQuery("SELECT C.category_id, C.category_name "
                    + "FROM categories C");
            while(result.next()){
                String category_id = result.getString("category_id").strip();
                String category_name = result.getString("category_name").strip();
                
                category_list_ids.add(category_id);
                category_list_names.add(category_name);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }   
    
    public void InsertProduct(String name, String category_name, String stock, String price) {
        try {
            int i;
            String category_id = null, category_name_temp;
            for(int j = 0; j<category_list_ids.size(); j++){
                category_name_temp = category_list_names.get(j);
                if(category_name_temp.equals(category_name)){
                    category_id = category_list_ids.get(j);
                }
            }
            String product_last_update = BuiltSystem.getCurrentDateFormattedDatabase();
            Statement stmt = connection.createStatement();
            //Memeriksa apakah product sudah ada di tabel apa belum
            boolean doubleData = false;
            for(i = 0; i < product_ids.size(); i++) { 
                String namex = product_names.get(i);
                if(namex.equals(name)){
                    doubleData = true;
                    break;
                }
            }
            
            if(!doubleData){
                System.out.println("i : " + (i-1));
                int id = Integer.parseInt(product_ids.get(i-1));
                System.out.println("Nama Produk : " + product_names.get(i-1));
                id++;
                System.out.println("id : " + id);
                
                String query = "INSERT INTO products VALUES('"+ id + "','" + category_id + "','" + name + "','" + stock + "','" + product_last_update + "','" + price + "');";
                stmt.execute(query);
                product_ids.add("" + id);
                category_ids.add(category_id);
                product_names.add(name);
                product_stocks.add(stock);
                product_last_updates.add(product_last_update);
                product_prices.add(price); 
            } else{
                UpdateData(name, category_id, stock, price);
            }
            stmt.close();
            BuiltSystem.debugLog("Running InsertData()");
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateData(String name, String product_id, String stock, String price){
        try {
            int i;
            String product_last_update = BuiltSystem.getCurrentDateFormattedProduct();
            Statement stmt = connection.createStatement();
            //Memeriksa apakah product sudah ada di tabel apa belum
            for(i = 0; i < product_ids.size(); i++) { 
                String namex = product_names.get(i);
                if(namex.equalsIgnoreCase(name)){
                    break;
                }
            }
            
            
            System.out.println(stock);
            // menambah stock jika produk sudah ada ditabel
            int new_stock = Integer.parseInt(product_stocks.get(i));
            new_stock += Integer.parseInt(stock);
            String stock_now = String.valueOf(new_stock);
            product_stocks.set(i, stock_now);

            // merubah harga jika produk sudah ada ditabel
            product_prices.set(i, price);

            // merubah last update product
            product_last_updates.set(i, product_last_update);

            // query untuk update database
            String query = "update products SET product_stock = '"+product_stocks.get(i)+"', product_last_update = '"+product_last_updates.get(i)+"', product_price = '"+ product_prices.get(i) +"' WHERE product_id = '"+product_ids.get(i)+"';";
            stmt.execute(query);
            
            stmt.close();
            BuiltSystem.debugLog("Running UpdateData()");
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void DeleteData(String name, String product_id, String stock, String price){
        try {
            int i = product_ids.size() - 1;
            String product_last_update = BuiltSystem.getCurrentDateFormattedProduct();
            Statement stmt = connection.createStatement();
            
            // mengurangi stock jika produk sudah ada ditabel
            int new_stock = Integer.parseInt(product_stocks.get(i));
            new_stock -= Integer.parseInt(stock);
            String stock_now = String.valueOf(new_stock);
            product_stocks.set(i, stock_now);

            // merubah harga jika produk sudah ada ditabel
            product_prices.set(i, price);

            // merubah last update product
            product_last_updates.set(i, product_last_update);

            // query untuk update database
            String query = "update products SET product_stock = '"+product_stocks.get(i)+"', product_last_update = '"+product_last_updates.get(i)+"' WHERE product_id = '"+product_ids.get(i)+"';";
            stmt.execute(query);
            
            stmt.close();
            BuiltSystem.debugLog("Running UpdateData()");
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void RemoveStock(String product_id, String stock){
        try {
            int i = -1;
            for(i = 0; i < product_ids.size(); i++) { 
                String namex = product_names.get(i);
                if(product_ids.get(i).equals(product_id)){
                    break;
                }
            }
            
            String product_last_update = BuiltSystem.getCurrentDateFormattedProduct();
            Statement stmt = connection.createStatement();
            
            // mengurangi stock jika produk sudah ada ditabel
            int new_stock = Integer.parseInt(product_stocks.get(i));
            new_stock -= Integer.parseInt(stock);
            String stock_now = String.valueOf(new_stock);
            product_stocks.set(i, stock_now);

            // merubah last update product
            product_last_updates.set(i, product_last_update);

            String query = "update products SET product_stock = '"+product_stocks.get(i)+"', product_last_update = '"+product_last_updates.get(i)+"' WHERE product_id = '"+product_ids.get(i)+"';";
            stmt.execute(query);
            
            stmt.close();
            BuiltSystem.debugLog("Running UpdateData()");
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}