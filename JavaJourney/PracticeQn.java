package JavaJourney;

import java.util.Enumeration;
import java.util.Hashtable;

//JFrame,JButton ,JPanel ,JTextArea ,JLabel,JTextField
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PracticeQn extends JFrame implements ActionListener {
    JFrame jf;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;
    JTextArea t;
    JPanel p1, p2;
    Hashtable<String, Integer> ts;

    PracticeQn() {

        jf = new JFrame();

        ts = new Hashtable<>();

        l1 = new JLabel("Enter City Name :");
        l2 = new JLabel("Enter City Code :");
        l3 = new JLabel("Enter City Name to Search : ");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        b1 = new JButton("ADD");
        b2 = new JButton("SEARCH");
        b3 = new JButton("REMOVE");

        t = new JTextArea(20, 20);

        p1 = new JPanel();
        p1.add(t);
        add(p1);

        p2 = new JPanel();
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(b1);
        p2.add(l3);
        p2.add(t3);
        p2.add(b2);
        p2.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        t.setEditable(false);
        add(p1);
        add(p2);
        setSize(400, 400);

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        if (b1 == e.getSource()) {
            String nm = t1.getText(); // get name
            int code = Integer.parseInt(t2.getText()); // get Code
            ts.put(nm, code); // put in hashtable

            Enumeration<String> k = ts.keys();
            Enumeration<Integer> v = ts.elements();

            String msg = "";
            while (k.hasMoreElements()) {
                msg = msg + k.nextElement() + "=" + v.nextElement() + "\n";
            }
            t.setText(msg);
            t1.setText("");
            t2.setText("");

            if (ts != null)
                JOptionPane.showMessageDialog(null, "Data Inserted...");
            else
                JOptionPane.showMessageDialog(null, "Data not Inserted...");
        } else if (b2 == e.getSource()) { // Search

            String nm = t3.getText(); // get city name to be search

            if (ts.containsKey(nm)) {
                t.setText(ts.get(nm).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Data not found...");
            }
        } else if (b3 == e.getSource()) {
            String nm = t3.getText();

            if(ts.containsKey(nm)){
                ts.remove(nm);
                JOptionPane.showMessageDialog(null,  nm +"  City deleted..");
            }else{
                JOptionPane.showMessageDialog(null, "City Not Found");
            }
        }
    }

    public static void main(String[] args) {
        new PracticeQn();
    }
}
