package JDBC;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class SelectExample {
    public static void main(String[] args) {
        try {
            // 1. load driver
            // Class.forName("org.postgresql.Driver");

            // 2. create connection
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(url, user, password);
            // 3. create statement
            Statement stm = con.createStatement();

            // 4.Execute Query
            ResultSet rs = stm.executeQuery("SELECT * FROM student");

            // 5.Process Result
            // getInt() : fetch INT column
            // getString() : fetch VARCHAR

            while (rs.next()) { // next() : move to next row
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("marks"));
            }
            // connection close
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
