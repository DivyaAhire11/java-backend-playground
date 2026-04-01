//write a Menu Driven program in Java for the following:
//  Assume Employee table with attributes(Eno , EName, Salary) is already created.
// 1.Insert , 2.Update , 3.Display , 4.Exit

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class MultiOpJDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals", "postgres",
                    "tybcs");

            int choice;
            do {
                System.out.println("\n 1.Insert");
                System.out.println("\n 2.Update");
                System.out.println("\n 3.Display");
                System.out.println("\n 4.Exit");
                System.out.print("\n Enter Choice :");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: // Insert
                        PreparedStatement ps1 = con.prepareStatement("INSERT INTO employee VALUES(? , ? ,?)");
                        System.out.print("Enter ENo : ");
                        int eno = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name : ");
                        String name = sc.nextLine();

                        System.out.print("Enter Salary : ");
                        double sal = sc.nextDouble();

                        ps1.setInt(1, eno);
                        ps1.setString(2, name);
                        ps1.setDouble(3, sal);

                        ps1.executeUpdate();
                        System.out.println("Record Inserted!!");

                        break;
                    case 2: // Update
                         PreparedStatement ps2 = con.prepareStatement("UPDATE employee SET salary=? WHERE eno=?");
                         System.out.print("Enter ENO to UPDATE : ");
                         int ueno = sc.nextInt();
    
                         System.out.print("Enter new Salary : ");
                         double usal = sc.nextDouble();

                         ps2.setDouble(1, usal);
                         ps2.setInt(2, ueno);
    
                         ps2.executeUpdate();
                         System.out.println("Record Updated");
                         break;
                    case 3: //Display
                         PreparedStatement ps3 = con.prepareStatement("SELECT * FROM employee");
                         ResultSet rs = ps3.executeQuery();
                         System.out.println("Employee Details:");
                         while(rs.next()){
                            System.out.println(
                                rs.getInt("eno")+ " " +
                                rs.getString("ename")+ " "+
                                rs.getDouble("salary")
                            );
                         }
                         break;
                    case 4: System.out.println("Exit...");
                          break;
                    default: System.out.println("Invalid Choice");
                
                }

            } while (choice != 4);

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}