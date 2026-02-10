package JavaJourney;

/*
   write a JAva program to diplay first record from student table(RNo, SName , Per) onto the TextFields y clicking on button.(Assume student table is already created)
*/
import javax.swing.*;   // GUI components
import java.awt.*;      //Layout
import java.awt.event.*;   //Button click
import java.sql.*;         //JDBC(database)

class FirstRecordDemo extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    JButton b;

    Connection con;    //connect java program to database
    Statement stm; //sends SQL query to database
    ResultSet rs;  // stores data returned from database

    FirstRecordDemo() {
        setTitle("First Student Record");
        setSize(350, 250);
        setLayout(new GridLayout(4, 2, 10, 10)); // row,col,hgap,vgap
        add(new JLabel("Roll No : "));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Student Name : "));
        t2 = new JTextField();
        add(t2);

        add(new JLabel("Percentage : "));
        t3 = new JTextField();
        add(t3);

        b = new JButton("Show First Record :");
        add(b);

        b.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            // Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // create connection
            con = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD"));

            // create statement
            stm = con.createStatement();

            // fetch All record
            rs = stm.executeQuery("SELECT * FROM student");

        } catch (ClassNotFoundException c) {
            System.out.println(c);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (rs.next()) { // move cursor to next record
                t1.setText(String.valueOf(rs.getInt("RNo")));
                t2.setText(rs.getString("SName"));
                t3.setText(String.valueOf(rs.getDouble("Per")));
            } else {
                JOptionPane.showMessageDialog(this, "No more records");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new FirstRecordDemo();
    }
}
