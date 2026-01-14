package JavaJourney;

import java.util.Hashtable;

//JFrame,JButton ,JPanel ,JTextArea ,JLabel,JTextField
import javax.swing.*;
import java.awt.*;//BorderLayout , 
import java.awt.event.*; //ActionEvent , ActionListener

class PracticeQn extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;
    JTextArea t;
    JPanel p1, p2;
    Hashtable<String, Integer> ts;

    PracticeQn() {
        ts = new Hashtable<>();

        l1 = new JLabel("Enter City Name :");
        l2 = new JLabel("Enter City Code :");
        l3 = new JLabel("Enter City Name (Search / Remove) : ");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        b1 = new JButton("ADD");
        b2 = new JButton("SEARCH");
        b3 = new JButton("REMOVE");

        t = new JTextArea(10, 30);

        p1 = new JPanel();
        p1.add(t);
        add(p1, BorderLayout.NORTH);

        p2 = new JPanel(new GridLayout(5,2));
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        add(p2, BorderLayout.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        t.setEditable(false);
      
        setSize(400, 400);
        setTitle("City");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == b1) {

            addCity();

        } else if (src == b2) {

            searchCity();

        } else if (src == b3) {

            removeCity();
        }
    }

    void addCity() {
        String city = t1.getText().trim(); // get name
        String code = t2.getText(); // get Code

        if (city.isEmpty() || code.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter city Name and Code : ");
            return;
        }

        try {
            int c = Integer.parseInt(code);
            ts.put(city, c); // put in hashtable

            displayAll();
            clearFields();

            JOptionPane.showMessageDialog(null, "City Add Successfully...");

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    public void searchCity() {

        String city = t3.getText().trim(); // get city name to be search

        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter city name to search ");
            return;
        }
        Integer code = ts.get(city);
        if (code != null) {
            JOptionPane.showMessageDialog(
                    this, city + " = " + code, " Search Result",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
        JOptionPane.showMessageDialog(null, "City not found...");
        }
    }

    public void removeCity() {

        String city = t3.getText().trim();

        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter city name to remove");
            return;
        }

        if (ts.remove(city) != null) {
            displayAll();
            JOptionPane.showMessageDialog(this, city + " City Remove successfully...");
        } else {
            JOptionPane.showMessageDialog(null, "City Not Found");
        }

    }

    public void displayAll() {
        StringBuilder sb = new StringBuilder();
        for (String key : ts.keySet()) {
            sb.append(key).append(" = ").append(ts.get(key)).append("\n");
        }
        t.setText(sb.toString());
    }

    public void clearFields() {
        t1.setText("");
        t2.setText("");
    }

    public static void main(String[] args) {
        new PracticeQn();
    }
}
