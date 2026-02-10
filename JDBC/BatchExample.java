package JDBC;

//Insert update many records at once
//improve performance
/*  BATCH PROCESSING :
        Multiple SQL -> one DB call
        Fast
*/
import java.sql.*;

public class BatchExample {
    public static void main(String[] args) {
        try {
             Connection con = DriverManager.getConnection(System.getenv("DB_URL"), System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD"));

            Statement stm = con.createStatement();

            stm.addBatch("INSERT INTO student VALUES (6,'Pratibha',88)");
            stm.addBatch("INSERT INTO student VALUES(7,'Surbhi',74)");
            stm.addBatch("INSERT INTO student VALUES(8,'Geeta',44)");

            int[] result = stm.executeBatch();
            System.out.println("Records Inserted : "+result.length);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
