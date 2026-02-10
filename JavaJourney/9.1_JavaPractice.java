package JavaJourney;
/*
  write a java program to create a thread for moving a ball inside a panel vertically. The ball should be created when the user clicks on the start button.
*/

import javax.swing.*; //JFrame, JPanel, JButton
import java.awt.*; //Graphics, Color, Layouts
// import java.awt.event.*; //Button click events

//Panel where ball will move
class BallPanel extends JPanel implements Runnable {
   int x = 100, y = 0; // position of ball
   int dx = 3;
   int dy = 4; // speed of ball
   int size = 40;   //size of ball

   Thread t;
   boolean running = false;

   public BallPanel() {
      setBackground(Color.WHITE);
   }

   // start the ball movement
   public void startBall() {
      if (!running) {
         running = true;
         t = new Thread(this);
         t.start();
      }
   }

   public void stopBall() {
      running = false;
   }

   // thread logic
   public void run() {
      while (running) {
         x += dx;
         y += dy;

         // Bounce from walls
         if (x <= 0 || x >= getWidth() - size)
            dx = -dx;

         if (y <= 0 || y >= getHeight() - size) {
            dy = -dy;
         }

         repaint(); // redraw panel

         try {
            Thread.sleep(20);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLUE);
      g.fillOval(x, y, size, size); 
   }
}

class MovingBallDemo extends JFrame {
   BallPanel panel;
   JButton start, stop;

   public MovingBallDemo() {
      setTitle("Moving Ball using Thread");
      setSize(400, 400);
      setLayout(new BorderLayout());

      panel = new BallPanel();

      start = new JButton("Start");
      stop = new JButton("Stop");

      // button event to create and start the ball thread
      start.addActionListener(e -> panel.startBall());
      stop.addActionListener(e -> panel.stopBall());

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(start);
      buttonPanel.add(stop);

      add(panel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);

      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      new MovingBallDemo();
   }
}
