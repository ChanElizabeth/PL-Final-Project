
package final_java;
import java.sql.*;

public class MyConnection {
    //create a function to connect with mysql
   
    public static Connection getConnection()
    {
        Connection conn = null;
        String port = "3306";
        String dbName = "peopleInventory";
        String username = "root";
        String password = "";

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + dbName + "?serverTimezone=GMT", username, password);
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
}
