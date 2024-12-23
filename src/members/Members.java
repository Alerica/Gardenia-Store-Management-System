
package members;

import cashier.*;
import members.*;
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


public class Members {
    
    Connection connection;
    
    public ArrayList<String> ids = new ArrayList<>();
    public ArrayList<String> names = new ArrayList<>();            
    public ArrayList<String> genders = new ArrayList<>();
    public ArrayList<String> registration_dates = new ArrayList<>();
    public ArrayList<String> phone_numbers = new ArrayList<>();
    
    public Members() {
        connection = BuiltSystem.CreateConnection(connection);
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Members");
            while(result.next()) {
                String id = result.getString("member_id").strip();
                String name = result.getString("member_name").strip();
                String gender = result.getString("member_gender").strip();
                String registration_date = result.getString("member_registration_date").strip();
                String phone_number = result.getString("member_phone_number").strip();
                
                ids.add(id);
                names.add(name);
                genders.add(gender);
                registration_dates.add(registration_date);
                phone_numbers.add(phone_number);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }   
    
    public void InsertData(String name, String gender, String phone_number) {
        try {
            
            for(int i = 0; i < ids.size(); i++) { }
            
            int id = Integer.parseInt(ids.get(ids.size()- 1));
            id++;
            
            String registration_date = BuiltSystem.getCurrentDateFormattedDatabase();
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO members VALUES(" + id + ",'" + name + "','" + gender + "','" + registration_date + "','" + phone_number + "');";
            stmt.execute(query);

            ids.add("" + id);
            names.add(name);
            genders.add(gender);
            registration_dates.add(registration_date);
            phone_numbers.add(phone_number); 
            stmt.close();
            
            BuiltSystem.debugLog("Running InsertData()");
        } catch (SQLException ex) {
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteData(String id) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Members WHERE member_id = '" + id + "';");
            System.out.println(BuiltSystem.getCurrentTime() + " Deleted member with id " + id);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        for(int i = 0; i < ids.size(); i++) {
            if(ids.get(i).equals(id)) {
                ids.remove(i);
                names.remove(i);
                genders.remove(i);
                registration_dates.remove(i);
                phone_numbers.remove(i);   
                break;
            }
        }
        BuiltSystem.debugLog("DeletedData() Completed");
    }    
}