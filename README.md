# Gardenia Store Management System
Gardenia Store Managament System is a window application that help organize product, member, transaction.
There`s also cashier page to make transaction

## Authors
* 2702224950 - Alexander Ricky Budianto - Alerica
* 2702236925 - Grace Birgitta Hadhinata
* 2702343914 - Rafly Adha Prathama - ShiroeWT
* 2702257620 - Christian Jodi Wisnuwardana 
<br>

# If you want to run Gardenia Store Management System make sure you follow this step
## 1. Create gardenia Database
Make sure you already create the gardenia database, you can do this simply by importing **gardenia.sql**

## 2. Make sure to add Connector.jar
If you`re using NetBeans you can do this by going to the project_name > Libraries, right click > Add JAR/FOLDER > Add the mysql-connector.jar

## 3.Connect to Gardenia Database 
Make sure you adjust the username and password of your database
By default your database username should be "root" and your password should be "", you can change the connection in the BuiltSystem class

```java
public static Connection CreateConnection(Connection connection){
    String url = "jdbc:mysql://localhost:3306/gardenia";
    String username = "root"; // Change this to your database used 
    String password = ""; // Replace "" with "your_password"
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

## 4. Login Page
If you want to go to the admin page
the default password is "4321" and username is "admin"

If you want to go to the cahsier page
the default password is "1234" and username is "user"

## Common issue you may found
#### **Can't login : **
Make sure the username and password have no trailing space
#### **Can't connect to database : **
Make sure you already change the password to ""
Make sure you already start the SQL server either with MySQL or XAMPP
Make sure your open port is 3306, if not change the connection in the BuiltSystem class
