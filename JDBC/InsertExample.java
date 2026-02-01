package JDBC;

import java.sql.*;

class InsertExample {
    public static void main(String[] args) {
        try {
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
