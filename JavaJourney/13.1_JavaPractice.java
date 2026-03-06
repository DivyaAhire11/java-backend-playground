package JavaJourney;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/*
   write a java program to display information about the database and list all the tables in the database.(Use DatabaseMetaData)
*/
class INFO_DATABASE{
    public static void main(String[] args) {
       try {
        //load Driver
        Class.forName("org.postgresql.Driver");
        
        //create connection
        String URL = System.getenv("DB_URL");
        String USER = System.getenv("DB_USER");
        String PASSWORD = System.getenv("DB_PASSWORD");
        Connection con = DriverManager.getConnection(URL , USER , PASSWORD);

        //create statement
        Statement stm = con.createStatement();

        
       } catch (Exception e) {
        // TODO: handle exception
       }
        
    }
}
