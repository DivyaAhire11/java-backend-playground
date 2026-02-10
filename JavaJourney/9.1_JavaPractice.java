package JavaJourney;
/*
  write a java program to create a thread for moving a ball inside a panel vertically. The ball should be created when the user clicks on the start button.
*/

/*
Full picture in ONE FLOW

  1 . Thread starts
  2 . Loop runs
  3 . Update position (x += dx)
  4 . Check wall collision
  5 . Reverse direction if needed
  6 . Call repaint()
  7 . Swing redraws ball
  8 . Sleep
  9 . Repeat */

//dx = 3  moving right
//dx = -3 moving left
//dy = 4 moving down
//dy = -4 moving up
//dx & dy = speed + direction together

import javax.swing.*;  //JFrame, JPanel, JButton
import java.awt.*;    //Graphics, Color, Layouts
// import java.awt.event.*; //Button click events

//Panel where ball will move
class BallPanel extends JPanel implements Runnable {
   int x = 100, y = 0; // position of ball
   int dx = 3; // move 3 pixels horizontally
   int dy = 4; // move 4 pixels vertically
   int size = 30; // size of ball

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

         /*
          * x <= 0   :  Ball touched left wall
          * x >= getWidth() - size  :   Ball touched right wall
          * getWidth() = panel width
          * size = ball diameter
          * subtracting ensures full ball stays visible
          * 
          *** When the ball hits a wall, reverse its direction
          */
         // Bounce from walls
         if (x <= 0 || x >= getWidth() - size)
            dx = -dx;

         if (y <= 0 || y >= getHeight() - size) {
            dy = -dy;
         }

         // Important:
         // repaint() does NOT draw
         // It requests Swing to redraw
         // Swing then automatically calls:paintComponent(Graphics g)
         /*
          * repaint()
          * ↓
          * Event Queue
          * ↓
          * paintComponent()
          */
         repaint(); // redraw panel

         try {
            Thread.sleep(20);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   // super.paintComponent(g): Clears old drawings ,Paints background color
   // ,Prevents trail / ghosting
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
