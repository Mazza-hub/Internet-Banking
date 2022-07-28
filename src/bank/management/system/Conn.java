package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn(){
        try {
                   //don't need to register the driver because java pick the class path by itself.
         // Class.forName(com.mysql.cj.jdbc.Driver);       //register,  (driver name). 
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "123456789"); // create connection
            s = c.createStatement();  //create statement, helps to execute query
        } catch (Exception e){
            System.out.println(e);
        }
    }    
}
