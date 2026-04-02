
import javax.swing.*; // Frame , TextField , Button 
import java.awt.event.*;  //ActionListener
import java.sql.*;  //Connection , Statement
import java.awt.*;

class DDLOperation extends JFrame implements ActionListener {

    JTextField tf;
    JButton b1, b2, b3;

    Connection con;
    Statement stmt;

    DDLOperation() {
        setLayout(new FlowLayout());
        tf = new JTextField(30);

        b1 = new JButton("Create Table");
        b2 = new JButton("Alter Table");
        b3 = new JButton("Drop Table");

        add(new Label("Enter DDL Query:"));
        add(tf);

        add(b1);
        add(b2);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setSize(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals", "postgres", "tybcs");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String query = tf.getText().trim().toLowerCase();

        try {
            // Check which button is pressed and validate query type
            if (e.getSource() == b1) { // Create
                if (!query.startsWith("create")) {
                    JOptionPane.showMessageDialog(this,
                            "Please enter a CREATE query!",
                            "Invalid Action",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Table Created Successfully!");

            } else if (e.getSource() == b2) { // Alter
                if (!query.startsWith("alter")) {
                    JOptionPane.showMessageDialog(this,
                            "Please enter an ALTER query!",
                            "Invalid Action",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Table Altered Successfully!");

            } else if (e.getSource() == b3) { // Drop
                if (!query.startsWith("drop")) {
                    JOptionPane.showMessageDialog(this,
                            "Please enter a DROP query!",
                            "Invalid Action",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Table Dropped Successfully!");
            }

        } catch (SQLException ee) {
            // SQL Error popup
            JOptionPane.showMessageDialog(this,
                    "SQL Error: " + ee.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new DDLOperation();
    }
}
