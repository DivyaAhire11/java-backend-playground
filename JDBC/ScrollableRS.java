package JDBC;

/*
   ResultSet rs = stmt.executeQuery(sql); 
     --> This is FORWARD ONLY(we can only go next)
   
     TYPES:
     TYPE_FORWARD_ONLY : move only next(default)
     TYPE_SCROLL_INSENSITIVE : Scollable,not  affected by DB changes
     TYPE_SCROLL_SENSITIVE : Scollable + reflects DB changes

    RS CONCURRENCY:
      CONCUR_READ_ONLY : only read data
      CONCUR_UPDATEBLE : can update ResultSet

    
     */

    //first() : move to first row
    //last() : move to last row
    //previous : move backward
    //absolute(n) : move to row n
    //getRow()  : current row number
    
import java.sql.*;

public class ScrollableRS {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(System.getenv("DB_URL"), System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD"));

            Statement stm = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stm.executeQuery("SELECT * FROM student");

            // MOVE TO LAST
            rs.last();
            System.out.println("Last Record : " + rs.getString("name"));

            // MOVE TO FIRST
            rs.first();
            System.out.println("First Record :" + rs.getString("name"));

            // MOVE TO BACKWARD
            rs.afterLast();
            while (rs.previous()) {
                System.out.println(rs.getInt(1) + "  = " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
