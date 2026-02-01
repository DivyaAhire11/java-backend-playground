package JDBC;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class SelectExample {
    public static void main(String[] args) {
        try {
            // 1. load driver
            Class.forName("org.posgresql.Driver");

            // 2. create connection
            Connection con = DriverManager.getConnection("/jdbc:postgresql://localhost:5432/testdb", "postgres",
                    "tybcs");

            // 3. create statement
            Statement stm = con.createStatement();

            // 4.Execute Query
            ResultSet rs = stm.executeQuery("SELECT * FROM student");

            // 5.Process Result
            while (rs.next()) {
               System.out.println(rs.getInt("id"+" "+rs.getString("name")+" "+rs.getInt("marks")));
            }
            // connection close
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
