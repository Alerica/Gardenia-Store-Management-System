# Gardenia Store Management System

## 1. Create gardenia Database
Make sure you already create the gardenia
## 2.Connecto To Database 

```java
public static Connection CreateConnection(Connection connection){
    String url = "jdbc:mysql://localhost:3306/gardenia";
    String username = "root"; // Change this to your database used 
    String password = "4321"; // 
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
```
