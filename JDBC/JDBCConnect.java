package JDBC;

import java.sql.DriverManager;
import java.sql.Connection;
/*
CREATE TABLE student(
 id INT PRIMARY KEY,
 name VARCHAR(50),
 marks INT
 );
 
 Class.forName() : loads JDBC driver
 DriverManager.getConnection() : connect java with database
 Connection : represent database connection
 con.close() : frees resources
 
 */
public class JDBCConnect {
    public static void main(String[] args) {
        try {

            // 1 .Load Driver
            Class.forName("org.postgresql.Driver");

            // 2 .Create Connection
           Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres","tybcs");
       
            System.out.println("DataBase Connected Successfully!");
       
          //6 . Close connection
          con.close();

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
