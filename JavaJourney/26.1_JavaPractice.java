// Write a Java Program to delete the details of given employee(ENo EName Salary) 
// Accept employee ID through command line.(Use PreparedStatement interface)

import java.sql.*; // Connection , DriverManager , PreparedStatement

class DeleteEmployee{
    public static void main(String[] args) {
         // Check if employee ID is provided

        if (args.length == 0) {
            System.out.println("Please provide the Employee ID as a command line argument.");
            return;
    }
        int empId = Integer.parseInt(args[0]);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals", "postgres", "tybcs");

            //delete query
            PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE eno=?");
            ps.setInt(1, empId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + empId + " deleted successfully.");
            } else {
                System.out.println("No employee found with ID " + empId + ".");
            }
            con.close();
        
        } catch (Exception e) {
            System.out.println(e);
        }
}
}