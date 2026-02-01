package JDBC;

import java.sql.*;
/*
  executeUpdate() : Used for INSERT / UPDATE / DELETE
                    return num og rows affected
*/
class InsertExample {
    public static void main(String[] args) {
        try {
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(url, user, password);

            Statement stm = con.createStatement();

            String sql = "INSERT INTO student VALUES(3,'Ritu',98)";

            int rows = stm.executeUpdate(sql);

            System.out.println(rows + " record inserted");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
