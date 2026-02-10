package JavaJourney;

/*
   Write a Java program to display first record from student table
   (RNo, SName, Per) onto the TextFields by clicking on button.
   (Assume student table is already created)
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class FirstRecordDemo extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton b;

    Connection con;
    Statement stm;
    ResultSet rs;

    FirstRecordDemo() {

        // Frame settings
        setTitle("First Student Record");
        setSize(350, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        // UI Components
        add(new JLabel("Roll No : "));
        t1 = new JTextField();
        t1.setEditable(false);
        add(t1);

        add(new JLabel("Student Name : "));
        t2 = new JTextField();
        t2.setEditable(false);
        add(t2);

        add(new JLabel("Percentage : "));
        t3 = new JTextField();
        t3.setEditable(false);
        add(t3);

        b = new JButton("Show First Record");
        add(b);

        b.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // JDBC Code
        try {
            // Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // Create connection
            con = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD")
            );

            // Create scrollable ResultSet
            stm = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            // Execute query
            rs = stm.executeQuery("SELECT * FROM student");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "PostgreSQL JDBC Driver not found.\nAdd JDBC JAR to project.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Database error: " + e.getMessage());
        }
    }

    // Button click
    public void actionPerformed(ActionEvent e) {
        try {
            if (rs == null) {
                JOptionPane.showMessageDialog(this, "Database not connected");
                return;
            }

            if (rs.next()) {
                t1.setText(String.valueOf(rs.getInt("id")));
                t2.setText(rs.getString("name"));
                t3.setText(String.valueOf(rs.getDouble("marks")));
            } else {
                JOptionPane.showMessageDialog(this, "No records found");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FirstRecordDemo();
    }
}
