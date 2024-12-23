package suppliers;

import gardeniastoremanagementsystem.BuiltSystem;
import gardeniastoremanagementsystem.GardeniaStoreManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import members.Members;

public class Suppliers {
    //INSERT INTO suppliers (id_product, name_supplier, supplier_phone) VALUES
    Connection connection;
    //Supplier List
    public ArrayList<String> supplier_ids = new ArrayList<>();
    public ArrayList<String> supplier_names = new ArrayList<>();
    public ArrayList<String> supplier_phones = new ArrayList<>();

    public Suppliers() {
        connection = BuiltSystem.CreateConnection(connection);
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(
                    "SELECT S.supplier_id, S.name_supplier, S.supplier_phone " +
                            "FROM suppliers S ");
            while(result.next()) {
                String supplier_id = result.getString("supplier_id").strip();
                String name_supplier = result.getString("name_supplier").strip();
                String supplier_phone = result.getString("supplier_phone").strip();
                
                supplier_ids.add(supplier_id);
                supplier_names.add(name_supplier);
                supplier_phones.add(supplier_phone);
                
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Suppliers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void InsertData(String SupplierID, String name, String phone) {
        try {
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO suppliers (supplier_id, name_supplier, supplier_phone) VALUES(" + SupplierID+ ",'" + name + "','"+ phone + "');";
            stmt.execute(query);
            
            BuiltSystem.debugLog("Running InsertData()");
            System.out.println("HAHHAH");
        } catch (SQLException ex) {
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


