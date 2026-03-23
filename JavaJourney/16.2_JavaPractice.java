// write a java program to accept the details of Teacher(TNo , TName, Subject). insert at least 5 records Into Teacher table
// and display the details of Teacher who is teaching "JAVA" Subject.(Use PreparedStatement Interface)

import java.sql.*; // Connection , DriverManager , PreparedStatement , ResultSet

class TeacherDB {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals",
                    System.getenv("DB_USER"), System.getenv("DB_PASSWORD"));

            PreparedStatement ps = con.prepareStatement("INSERT INTO Teacher VALUES(? , ? , ? ,?)");

            // Insert 5 records
            ps.setInt(1, 1);
            ps.setString(2, "Amit");
            ps.setString(3, "JAVA");
            ps.setString(4, "Experienced Java Developer with strong OOP concepts");
            ps.executeUpdate();

            ps.setInt(1, 2);
            ps.setString(2, "Sumit");
            ps.setString(3, "PYTHON");
            ps.setString(4,"Sharp and Kindly");
            ps.executeUpdate();

            ps.setInt(1, 3);
            ps.setString(2, "Rahul");
            ps.setString(3, "JAVA");
            ps.setString(4,"Proper Guidence");
            ps.executeUpdate();

            ps.setInt(1, 4);
            ps.setString(2, "Priya");
            ps.setString(3, "CN");
            ps.setString(4,"Expert in computer networks and protocols");
            ps.executeUpdate();

            ps.setInt(1, 5);
            ps.setString(2, "Sneha");
            ps.setString(3, "JAVA");
            ps.setString(4,"Focused on Java frameworks like Spring and Hibernate");
            ps.executeUpdate();

            ps.setInt(1, 6);
            ps.setString(2, "Neha");
            ps.setString(3, "JAVA");
            ps.setString(4,"Expert in Core Java and web applications");
            ps.executeUpdate();

            ps.setInt(1, 7);
            ps.setString(2, "Priya");
            ps.setString(3, "OS");
            ps.setString(4,"Kidly but less Experience, just like Freshers");
            ps.executeUpdate();

            ps.setInt(1, 8);
            ps.setString(2, "Kiran");
            ps.setString(3, "DBMS");
            ps.setString(4,"Specialist in database sedign and SQL  queries");
            ps.executeUpdate();

            // select teachers teaching JAVA
            PreparedStatement ps2 = con.prepareStatement(
                    "SELECT * FROM teacher WHERE subject = ?");
            ps2.setString(1, "JAVA");

            ResultSet rs = ps2.executeQuery();
            System.out.println("Teachers teaching JAVA :");

            while (rs.next()) {
                System.out.println(rs.getInt("tno") + "  " + rs.getString("tname") + "  " + rs.getString("subject")+ "  "+rs.getString("About"));
            }
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}