package transaction;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class TransactionsDetail {
    
    Connection connection;
        
    ArrayList<String> ids_trans = new ArrayList<>();
    ArrayList<String> product_names=new ArrayList<>();
    ArrayList<String> quantities=new ArrayList<>();
    ArrayList<String> product_prices=new ArrayList<>();
    ArrayList<String> total_details=new ArrayList<>();
    ArrayList<String> member_names= new ArrayList<>();
    ArrayList<String> ids_products= new ArrayList<>();
//    TransactionShowDetailPage tsd = new TransactionShowDetailPage();
//    void 
    
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
    

//    private void RefreshData() {
//        BuiltSystem.debugLog("Running RefreshData()");
//        
//        DefaultTableModel tableModel = (DefaultTableModel)tableMembers.getModel();
//        Members members = new Members();
//        String id, name, gender, registration_date, phone_number;
//        int size = members.ids.size();
//        int total_row = tableModel.getRowCount();
//        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
//        for (int i = 0; i < size;  i++) {
//            id = members.ids.get(i);
//            name = members.names.get(i);
//            gender = members.genders.get(i);
//            registration_date = members.registration_dates.get(i);
//            phone_number = members.phone_numbers.get(i);
//            String rowData[] = {id, name, gender, registration_date, phone_number};
//            tableModel.addRow(rowData);
//        }   
//        
//        BuiltSystem.debugLog("RefreshData() Completed");
//    }
    
//    private void SearchData(){
//        BuiltSystem.debugLog("Running SearchData()");
//        DefaultTableModel tableModel = (DefaultTableModel)tableMembers.getModel();
//        Members members = new Members();
//        totalMember.setText("Total Member : " + members.ids.size());
//        String id, name, gender, registration_date, phone_number;
//        int size = members.ids.size();
//        int total_row = tableModel.getRowCount();
//        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
//        for (int i = 0; i < size;  i++) {
//            String input = memberInputField.getText().toLowerCase();
//            id = members.ids.get(i);
//            name = members.names.get(i).toLowerCase();
//            gender = members.genders.get(i).toLowerCase().strip();
//            registration_date = members.registration_dates.get(i);
//            phone_number = members.phone_numbers.get(i);
//            if(input.startsWith("@")) {
//                if(id.equalsIgnoreCase(input.substring(1, input.length()))) {
//                    String rowData[] = {id, name, gender, registration_date, phone_number};
//                    tableModel.addRow(rowData);
//                    break;
//                }
//            }
//            if (id.equals(input) || name.contains(input) || gender.contains(input) || registration_date.contains(input) || phone_number.equals(input)) {
//                String rowData[] = {id, name, gender, registration_date, phone_number};
//                tableModel.addRow(rowData);
//            }         
//        }   
//        BuiltSystem.debugLog("SearchData() Completed");
//    }
    
    
//    void DeleteData(String id) {
//        // DELETE FROM Member WHERE member_id = '5';
//        try {
//            Statement stmt = connection.createStatement();
//            stmt.execute("DELETE FROM Members WHERE member_id = '" + id + "';");
//            System.out.println(BuiltSystem.getCurrentTime() + " Deleted member with id " + id);
//            stmt.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        
//        
//        for(int i = 0; i < ids.size(); i++) {
//            if(ids.get(i).equals(id)) {
//                ids.remove(i);
//                names.remove(i);
//                genders.remove(i);
//                registration_dates.remove(i);
//                phone_numbers.remove(i);   
//                break;
//            }
//        }
//        BuiltSystem.debugLog("DeletedData() Completed");
//    }
    
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