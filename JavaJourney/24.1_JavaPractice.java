//Write a java program to scroll the Text from left to right continuously

import javax.swing.*; //JFrame , JLabel , Thread

class ScrollText extends JFrame implements Runnable {
    JLabel l;
    String text = " Welcome to Java Programming ";
    Thread t;

    ScrollText() {
        l = new JLabel(text);
        add(l);

        setSize(200, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                // Move first character to end
                // text = text.substring(1) + text.charAt(0); // It looks like the text is moving right-to-left
               
                //last character Move it to the front
                text = text.charAt(text.length() - 1) + text.substring(0, text.length() - 1);//It appears to move left-to-right

                l.setText(text);
                Thread.sleep(300); // sleep

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new ScrollText();
    }
}