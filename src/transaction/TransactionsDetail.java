package transaction;

import gardeniastoremanagementsystem.BuiltSystem;
import gardeniastoremanagementsystem.GardeniaStoreManagementSystem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class TransactionsDetail {
    
    Connection connection;
        
    ArrayList<String> ids_trans = new ArrayList<>();
    ArrayList<String> product_names=new ArrayList<>();
    ArrayList<String> quantities=new ArrayList<>();
    ArrayList<String> product_prices=new ArrayList<>();
    ArrayList<String> total_details=new ArrayList<>();
    ArrayList<String> member_names= new ArrayList<>();
    ArrayList<String> ids_products= new ArrayList<>();
    
    TransactionsDetail(int trans_id, int total_recap) {
        connection = BuiltSystem.CreateConnection(connection);
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT \n"
                    + "	t.transaction_id,\n"
                    + "	p.product_id,\n"
                    + "	p.product_name,\n"
                    + "	d.quantity,\n"
                    + "	p.product_price,\n"
                    + "	d.total_detail,\n"
                    + "	m.member_id,\n"
                    + "	m.member_name\n"
                    + "FROM transactions t\n"
                    + "JOIN\n"
                    + "detailtransactions d ON d.transaction_id= t.transaction_id\n"
                    + "\n"
                    + "JOIN\n"
                    + "products p ON p.product_id=d.product_id\n"
                    + "\n"
                    + "JOIN\n"
                    + "members m ON m.member_id=t.member_id\n"
                    + "\n"
                    + "WHERE\n"
                    + "	p.product_id=d.product_id AND\n"
                    + "	d.transaction_id = '" + trans_id + "' AND	m.member_id=t.member_id;");
            
            while(result.next()) {
                String id_trans = result.getString("transaction_id").strip();
                String product_name = result.getString("product_name").strip();
                String quantity = result.getString("quantity").strip();
                String product_price = result.getString("product_price").strip();
                String total_detail = result.getString("total_detail").strip();
                String member_name = result.getString("member_name").strip();
                String id_product = result.getString("product_id").strip();
                
                ids_trans.add(id_trans);
                product_names.add(product_name);
                quantities.add(quantity);
                product_prices.add(product_price);
                total_details.add(total_detail);
                member_names.add(member_name);
                ids_products.add(id_product);
            
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }   
}