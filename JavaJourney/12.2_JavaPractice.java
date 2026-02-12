package JavaJourney;

// javac -cp "postgresql-42.7.9.jar" JavaJourney\12.2_JavaPractice.java
//java -cp "postgresql-42.7.9.jar;." JavaJourney.ProjectTableDemo 

/*write a java program to create a PROJECT table with fields 
  project_id , project_name,project_description,project_status.
  Insert values in the table. Display all the details of the PROJECT table in a tabular format on the screen(using swing).
*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class ProjectTableDemo extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ProjectTableDemo() {
        setTitle("PROJECT Table Details");
        setSize(600, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] cols = { "Project ID", "Project Name", "Description", "Status" };
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        fetchData();

        setLocationRelativeTo(null); // center window
        setVisible(true);
        
    }

    void fetchData() {
       

        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Create connection
            Connection con = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD")
            );

            String sql = "SELECT * FROM project";

                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql);

                // Insert data into JTable
                while (rs.next()) {
                    Object[] row = {
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getString("status")
                    };
                    model.addRow(row);
                }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error loading data from database",
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProjectTableDemo::new);
    }
}
