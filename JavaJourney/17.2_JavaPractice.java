/*
  Write a Multithreading program in java to display the number's between 1 to 100
  continuously in a TextField by clicking on button.( Use Runnable Interface)
*/
import java.awt.*; //Frame,TextField,Button
import java.awt.event.*; //ActionListener

class NumberThread implements Runnable{
    TextField tf;

    public NumberThread(TextField tf) {
        this.tf = tf;
    }
    
    @Override
    public void run() {
       try {
         for(int i=1; i <= 100;i++){
             tf.setText(String.valueOf(i));  //display number
             Thread.sleep(100);
         }

       } catch (Exception e) {
         System.out.println(e);
    }
        
    }
}
class NumberDisplay extends Frame implements ActionListener{
    TextField tf;
    Button btn;

    NumberDisplay(){
    
        tf = new TextField(30);
        btn = new Button("Start");

        setLayout(new FlowLayout());

        add(tf);
        add(btn);

        btn.addActionListener(this);

        setSize(300,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread t = new Thread(new NumberThread(tf));
        t.start();
    }
    public static void main(String[] args) {
        new NumberDisplay();
    }
}
