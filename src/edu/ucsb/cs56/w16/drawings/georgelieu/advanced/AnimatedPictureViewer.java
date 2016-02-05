package edu.ucsb.cs56.w16.drawings.georgelieu.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author George Lieu
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private BirthdayCake cake = new BirthdayCake(0,0, 75, 75);
    
    Thread anim;   
    
    private int x = 0;
    private int y = 240;
    
    private int dx = 10;
    private int dy = 10;
    

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
        System.out.println("Mouse entered");
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
          g2.setColor(Color.BLACK);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Birthday cake
          g2.setColor(Color.WHITE);
          BirthdayCake cake = new BirthdayCake(x, y, 100, 100);
	  Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);      
	  g2.setStroke(thick);
          g2.draw(cake);
	  
		    
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { dx = -5; }
            if (x <= 50) { dx = 5; }
            
            x += dx;

	    if (y >= 600) { dy = -5; }
	    if (y <= 50) { dy = 5; }

	    y += dy;
	  
            panel.repaint();
            Thread.sleep(50);
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
