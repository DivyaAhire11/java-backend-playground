/*
   Write a java program for the implementation of scrollable ResultSet. Assume Teacher table with attributes(TID , TName , Salary) is already created.
*/
import java.sql.*;  // Connection , DriverManager , Statement 
//ResultSet (TYPE_SCROLL_INSENSITIVE)

class ScrollableResultSet {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals","postgres","tybcs");
        
            //Create scrollable ResultSet
            Statement stmt = con.createStatement(
              ResultSet.TYPE_SCROLL_INSENSITIVE,
              ResultSet.CONCUR_READ_ONLY
            );
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM teacher");
            System.out.println("Forward Direction :");
            while(rs.next()){
                //System.out.println(rs.getInt("tno")+"  "+rs.getString("tname")+"  "+rs.getDouble("salary"));   
                System.out.println(rs.getInt("tno")+"  "+rs.getString("tname")+"  "+rs.getString("subject")+"  "+rs.getString("About"));
            }
             System.out.println("\n ---------------Backward Direction ---------------");
             while(rs.previous()){
                 System.out.println(rs.getInt("tno")+"  "+rs.getString("tname")+" "+ rs.getString("subject")+"  "+rs.getString("About"));
             }
             
             con.close();
        } catch (Exception e) {
            System.out.println("Exception :"+e);
        }
    }
}
