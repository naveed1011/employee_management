
package projectemployee;
import java.sql.*;

public class ConnectionJDBC {
    Connection conn;
    Statement st;
    public static final String url = "jdbc:mysql://localhost/employeemanagmentsystem";
    public static final String username = "root";
    public static final String password = "";
    
    public ConnectionJDBC() {
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username,password);
            st = conn.createStatement();
           
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
