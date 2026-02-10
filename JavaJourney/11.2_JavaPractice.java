package JavaJourney;
/*
 * ResultSetMetaData is used to get information about the columns of a tale.

 * getMetaData() : returns metadata of the Resultset
 IMP METHOD:
     - getColumnCount() -> total columns
     - getColumnName(int) -> column name 
     - getColumnTypeName(int) -> data type of column
     - getColumnDisplaySize(int) -> size of column
     - isNullable(int) -> whether column can have null values or not

*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

class DonarMetaData{
    public static void main(String[] args) {
        try {
            //Load JDBC Driver 
            Class.forName("org.postgresql.Driver");

            //Establish Connection
            Connection con = DriverManager.getConnection(
                System.getenv("DB_URL"),
                System.getenv("DB_USER"),
                System.getenv("DB_PASSWORD")
            );

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM donar");

            //Get Database Metadata
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
            System.out.println("Column Count: " + columnCount);

            System.out.println("------------------------------------");

            //display info about each column
            for(int i=1;i<= columnCount;i++){
                System.out.println("Column " + i + ":");
                System.out.println("Name: " + rsmd.getColumnName(i));
                System.out.println("Type: " + rsmd.getColumnTypeName(i));
                System.out.println("Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("Nullable: " + (rsmd.isNullable(i) == ResultSetMetaData.columnNullable ? "Yes" : "No"));
                System.out.println("------------------------------------");
            }
            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
