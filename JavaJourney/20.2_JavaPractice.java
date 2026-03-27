import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class BlinkImage extends JFrame implements Runnable{
    JLabel l;
    Thread t;
    BlinkImage(){
        //load image 
        ImageIcon img = new ImageIcon("./image.png");


        Image scaledImage = img.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
     
        l = new JLabel(resizedIcon);
        add(l);

        setSize(400,500);
        setVisible(true);

        t = new Thread(this);
        t.start();
    }

    public void run(){
        try {
            while(true){
                l.setVisible(false); //hide
                Thread.sleep(500);

                 l.setVisible(true); //show
                Thread.sleep(500);
            }
        } catch (Exception e) {
             System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new BlinkImage();
    }
}