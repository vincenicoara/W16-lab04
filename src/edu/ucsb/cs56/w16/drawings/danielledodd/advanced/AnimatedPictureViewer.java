package edu.ucsb.cs56.w16.drawings.danielledodd.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animated cars, on a street
 *
 * @author Danielle Dodd
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private int x = 0;
    private int y = 0;
    
    private int dx = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }
    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the trucks
          g2.setColor(Color.BLUE);
          Truck t1 = new Truck(x, y, 50, 50);
	  g2.draw(t1);
	  
	  g2.setColor(Color.RED);
	  Truck t2 = new Truck(x+90, y, 50, 50);
	  g2.draw(t2);

	  g2.setColor(Color.GREEN);
	  Truck t3 = new Truck(x+180, y, 50, 50);
	  g2.draw(t3);

	  g2.setColor(Color.CYAN);
	  Truck t4 = new Truck(x, y+80, 50, 50);
	  g2.draw(t4);

	  g2.setColor(Color.BLACK);
	  Truck t5 = new Truck(x+90, y+80, 50, 50);
	  g2.draw(t5);

	  g2.setColor(Color.DARK_GRAY);
	  Truck t6 = new Truck(x+180, y+80, 50, 50);
	  g2.draw(t6);

	  g2.setColor(Color.MAGENTA);
	  Truck t7 = new Truck(x, y+160, 50, 50);
	  g2.draw(t7);

	  g2.setColor(Color.ORANGE);
	  Truck t8 = new Truck(x+90, y+160, 50, 50);
	  g2.draw(t8);

	  g2.setColor(Color.PINK);
	  Truck t9 = new Truck(x+180, y+160, 50, 50);
	  g2.draw(t9);
	  
       }
    }
    
    class Animation extends Thread {
      public void run() {
	  try {
	      while (true) {
		  // drive from the left to the right
		  //when reach the right edge, appear on the left
		  //on the left but lower on the screen.
		  //repeat
		  dx = 10;
		  x += dx;
		  if (x == 720) {
		      x = -100;
		      y = y + 100;
		     if(y >= 300)
		   	  y = 0;
		   }
		  
            panel.repaint();
            Thread.sleep(30);
	      }
	  } catch(Exception ex) {
	      if (ex instanceof InterruptedException) {
		  // Do nothing - expected on mouseExited
	      } else {
		  ex.printStackTrace();
		  System.exit(1);
	      }
	  }
      }
    }
    
}
