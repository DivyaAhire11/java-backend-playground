package JavaJourney;

import javax.swing.*;
import java.awt.*;

/*
  Write a Java program using Runnable interface to blink Text on the frame.
*/
class BlinkText extends JFrame implements Runnable {
    JLabel l;
    Thread t;

    BlinkText() {

        // Label to blink
        l = new JLabel("WelCome! to Java Blinking Text");
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setForeground(Color.BLUE);
        add(l);

        // Create and Start Thread
        t = new Thread(this);
        t.start();

        // Frame settings
        setTitle("Blinking Text Using Runnable");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void run() {
        try {
           while (true) {
             //Make the Text Invisible
             l.setVisible(false);
             Thread.sleep(500);  // wait for 0.5 sec
            

             //Make text visible
             l.setVisible(true);  
             Thread.sleep(500);
           }
          

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Testing {
    public static void main(String[] args) {
        new BlinkText();
    }
}
