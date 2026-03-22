import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/*
   write a java program to display information about the database 
   and list all the tables in the database.(Use DatabaseMetaData)
*/
class INFO_DATABASE{
    public static void main(String[] args) {
       try {
        //load Driver
        Class.forName("org.postgresql.Driver");
        
        //create connection
        String USER = System.getenv("DB_USER");
        String PASSWORD = System.getenv("DB_PASSWORD");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals" , USER , PASSWORD);

        // 3. Get databaseMetaData object 
         DatabaseMetaData dbmd = con.getMetaData();

        // 4. Display Database Information
        System.out.println("Database Product Name : "+ dbmd.getDatabaseProductName());
        System.out.println("Database Product Version :"+ dbmd.getDatabaseProductVersion());
        System.out.println("Driver Name : "+ dbmd.getDriverName());
        System.out.println("Driver Version : "+ dbmd.getDriverVersion());
        System.out.println("User Name : "+ dbmd.getUserName());

        System.out.println("\n List of Tables :");
        // 5. Get all tables
        ResultSet rs = dbmd.getTables(null, null, "%", new String[]{ "TABLE"});
      /*  
          ResultSet rs =  table like object(row + columns) 
          dbmd.getTables(....) = Method of DatabaseMetaData class
                                 Used to fetch table details from database
          getTables(catalog,schema,tableNamePattern,types)
          catalog : null => not used in PostgreSQL
          schema : null => Default schema used(like pulic in postgreSQL)
          tableNamePattern : % => all tables(wildcard)
      
          GET ALL TABLES FROM DATABASE AND STORE IN RESULTSET

      */
        //6.Display table Names
        while(rs.next()){
         System.out.println(rs.getString("TABLE_NAME"));
        }

         con.close();

       } catch (Exception e) {
           System.out.println(e);
       }
        
    }
}
