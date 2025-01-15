package gardeniastoremanagementsystem;

import dashboard.MainPage;
import java.awt.Window;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuiltSystem {
    
    public static boolean IsWindowOpened(String windowName) {
        for (Window window : Window.getWindows()) {
            if (window.isVisible() && windowName.equals(window.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void OpenWindow(Window window, String windowName) {
        if (!IsWindowOpened(windowName)) {
            window.setName(windowName); 
            window.setVisible(true);   
        } else {
            System.out.println("Window is already open: " + windowName);
        }
    }

    
    public static void CloseWindow(String specificWindowName) {
        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        } 
    }
    
    public static int StringToInt(String text) {
        try {
            int number = Integer.parseInt(text);
            return number;
        } catch (Exception e) {
            return 0;
        }
    }
    
    // If Something goes wrong still return true
    public static boolean CheckNegative(String number) {
        try {
            if (Integer.parseInt(number) < 0) return true;
        } catch (Exception e) {
            return true;
        }
        return false;
    }
    
    
    public static boolean CheckPassword(String username, String password){
        if(username.equals(" username") && password.equals(" password")) {
            debugLogin();
            return true;
        }
        debugLoginInvalid();
        
        
        return false;
    }
    
    public static String getCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        return currentTime.format(formatter);
    }
    
    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }
    
    public static String getCurrentDateFormattedDatabase() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }
    
    public static String getCurrentDateFormattedProduct() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }
    
    public static Month getCurrentMonth() {
        return LocalDate.now().getMonth();
    }
    
    public static int getCurrentMonthAsNumber() {
        return LocalDate.now().getMonthValue();
    }
    
    public static int getCurrentYearAsNumber() {
        return LocalDate.now().getYear();
    }
    
    
    /*
    Connection
    */
    public static Connection CreateConnection(Connection connection){
        String url = "jdbc:mysql://localhost:3306/gardenia";
        String username = "root"; // Default XAMPP MySQL username
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            debugLog("Connection Success");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    /*
    Debug to tell what happen during specific time
    */
    public static void debugLog(String massage) {
        System.out.println(getCurrentTime() + " " +massage);
    }
    
    public static void debugLogin(){
        System.out.println(getCurrentTime() + " Succesfully login");
    }
    
    public static void debugLoginInvalid(){
        System.out.println(getCurrentTime() + " Failed login");
    }
    
    public static void debugTime() {
        System.out.println(getCurrentTime() + " Running");
    }
    
    
}
