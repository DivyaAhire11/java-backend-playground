 package JavaJourney;

/**
 * Write a Java Program to accept the details of employee(ENO , EName, Designation, Salary )from a user and store it into the database.(Use Swing)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EmployeeForm extends JFrame implements ActionListener {
    JTextField EmpNo, EmpNm, degn, salary;
    JButton b;

    EmployeeForm() {
        setTitle("Employee Details");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Employee No :"));
        EmpNo = new JTextField();
        add(EmpNo);

        add(new JLabel("Employee Name :"));
        EmpNm = new JTextField();
        add(EmpNm);

        add(new JLabel("Designation :"));
        degn = new JTextField();
        add(degn);

        add(new JLabel("Salary : "));
        salary = new JTextField();
        add(salary);

        b = new JButton("Save");
        b.addActionListener(this);
        add(b);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            int eno = Integer.parseInt(EmpNo.getText());
            String name= EmpNm.getText();
            String designation = degn.getText();
           double sry = Double.parseDouble(salary.getText());

           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/company","root","password"
           );
           String sql = "INSERT INTO employee VALUES(?,?,?,?)";
           PreparedStatement ps = con.prepareStatement(sql);

           ps.setInt(1, eno);
           ps.setString(2, name);
           ps.setString(3, designation);
           ps.setDouble(4, sry);

           ps.executeUpdate();
          
           JOptionPane.showMessageDialog(this, "Employee Record Saved");
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}

class Main {
    public static void main(String[] args) {
          new EmployeeForm();
    }
}
