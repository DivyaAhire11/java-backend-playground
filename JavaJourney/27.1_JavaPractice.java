// Write a Java program to display the details of College(CID , CName , address , Year) on JTable.

import javax.swing.*;  //JFrame , JTable , JScrollPane
import java.sql.*;  //Connection , Statement , ResultSet
import java.util.Vector;  //Vector is used to store: Column names , Table data (rows)

class CollegeTable extends JFrame{
    JTable table;
    CollegeTable(){
        Vector<String> columnNames = new Vector<>(); // column names of table
        Vector<Vector<String>> data = new Vector<>();  // data = all rows of table : Each row is also a Vector

        try {
            //load driver
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals", "postgres", "tybcs");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM college");

            columnNames.add("CID");
            columnNames.add("CName");
            columnNames.add("Address");
            columnNames.add("Year");

            while(rs.next()){
                Vector<String> row = new Vector<>();  //Create a new row
               //Get values from DB columns , Add them into row
                row.add(rs.getString("cid"));
                row.add(rs.getString("cname"));
                row.add(rs.getString("address"));
                row.add(rs.getString("year"));
               
                data.add(row); //Add row into main data vector
            }

            //JTable : Create table using: data → rows , columnNames 
            table = new JTable(data , columnNames);
            add(new JScrollPane(table)); //Adds scroll bar if data is large

            setSize(500,300);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            con.close();


        } catch (Exception e) {
             System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new CollegeTable();
    }
}
