package bancodedados2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Programa {
    
    public static void main(String[] args) {
    
        String address = "jdbc:mysql://localhost/world?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";

        //Database db = new Database();
        
        Database2 db2 = new Database2();
        db2.menu(address, user, password, "readestado");
        
        
        //db.insert("jdbc:mysql://localhost/world?useTimezone=true&serverTimezone=UTC", "root", "");
        //db.example("jdbc:mysql://localhost/world?useTimezone=true&serverTimezone=UTC", "root", "");
    }
}
