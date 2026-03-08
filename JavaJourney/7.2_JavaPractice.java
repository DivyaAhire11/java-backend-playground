
// package JavaJourney;
/*
   write a java for the following:
      1.To create a Product(Pid,Pname,Price) table.
      2.Insert at least five records into the table
      3.Display all the records from a table
*/
import java.sql.*;

class Product {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            
            Connection con = DriverManager.getConnection(System.getenv("DB_URL"), System.getenv("DB_USER"),
                    System.getenv(("DB_PASSWORD")));

            Statement st = con.createStatement();
            String createTable = "CREATE TABLE IF NOT EXITS Product( " + " Pid INT PRIMARY KEY," + "Pname VARCHAR(50),"
                    + "Price DOUBLE)";

            st.executeUpdate(createTable);
            System.out.println("Product table created successfully.");

            st.executeUpdate("INSERT INTO Product VALUES(1,'Laptop',60000)");
            st.executeUpdate("INSERT INTO Product VALUES(2,'Mobile',25000)");
            st.executeUpdate("INSERT INTO Product VALUES(3,'Keyboard',800)");
            st.executeUpdate("INSERT INTO Product VALUES(4,'Mouse',500)");
            st.executeUpdate("INSERT INTO Product VALUES(5,'Tablet',5000)");
            st.executeUpdate("INSERT INTO Product VALUES(6,'Monitor',12000)");

            System.out.println("Records insert successfully!!");

            ResultSet rs = st.executeQuery("SELECT * FROM Product");

            System.out.println("\n --------Product Table Records:------------ ");
            System.out.println("Pid \t Pname \t Price");
            while (rs.next()) {
                int id = rs.getInt("Pid");
                int name = rs.getInt("Pname");
                int price = rs.getInt("Price");

                System.out.println(id + "\t" + name + "\t" + price);
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
