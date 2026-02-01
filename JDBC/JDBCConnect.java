package JDBC;

import java.sql.DriverManager;
import java.sql.Connection;

/*
 
 Class.forName() : loads JDBC driver
 DriverManager.getConnection() : connect java with database
 Connection : represent database connection
 con.close() : frees resources
 
 */
public class JDBCConnect {
    public static void main(String[] args) {
        try {

            // 1 .Load Driver
            // Class.forName("org.postgresql.Driver");

            // 2 .Create Connection
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("DataBase Connected Successfully!");

            // 6 . Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
