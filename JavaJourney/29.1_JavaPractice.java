/*
  Write a Java Program to display information about all columns in the DONAR table using ResultSetMetaData

  getColumnCount() : to get total number of columns
  getColumnName() : to get column name
  getColumnTypeName() : to get column data type
  getColumnDisplaySize() : to get column size

  */

import java.sql.*;  //Connection , DriverManager , Statement , ResultSet , ResultSetMetaData

class DonarDetails{
    public static void main(String[] args) {
        try {
            //Load Driver
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals","postgres","tybcs");
            Statement stmt = con.createStatement();
            
            //fetch data
            String sql = "SELECT * FROM donar";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            //GET Metadata
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols= rsmd.getColumnCount();
            
            System.out.println("Column Details : ");
            for(int i=1; i<= cols;i++){
                System.out.println("Column No : "+ i);
                System.out.println("Column Name : "+rsmd.getColumnName(i));
                System.out.println("Column Type : "+rsmd.getColumnTypeName(i));
                System.out.println("Column Size : "+rsmd.getColumnDisplaySize(i));
                
                System.out.println("-------------------------------");
                
                con.close();
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Expetion Occured "+e);
        }
    }
}
