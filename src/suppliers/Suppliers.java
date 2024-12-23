package suppliers;

import gardeniastoremanagementsystem.BuiltSystem;
import gardeniastoremanagementsystem.GardeniaStoreManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import members.Members;

public class Suppliers {
    //INSERT INTO suppliers (id_product, name_supplier, supplier_phone) VALUES
    Connection connection;

    public Suppliers() {
        connection = BuiltSystem.CreateConnection(connection);
    }
    
    public void InsertData(String productID, String name, String phone) {
        try {
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO suppliers (id_product, name_supplier, supplier_phone) VALUES(" + productID+ ",'" + name + "','"+ phone + "');";
            stmt.execute(query);
            
            BuiltSystem.debugLog("Running InsertData()");
            System.out.println("HAHHAH");
        } catch (SQLException ex) {
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

