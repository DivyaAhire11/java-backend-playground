package JDBC;

import java.sql.*;

/*
    
*/
public class PreparedInsert{
    public static void main(String[] args) {
        try {
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO student VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 4);
            ps.setString(2, "Janu");
            ps.setInt(3, 80);

            ps.executeUpdate();
            System.out.println("Record Inserted Successfully!!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
