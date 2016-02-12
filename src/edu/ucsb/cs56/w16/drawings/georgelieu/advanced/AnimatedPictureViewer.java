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
    
    Thread anim;   
    
    private int x = 0;
    private int y = 20;
    
    private int dx = 10;
    private int dy = 10;
    private int size = 1;

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
          BirthdayCake cake = new BirthdayCake(x, y, size+70, size+70);
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

            if (x >= 450) { dx = -10;}
            if (x <= 100) { dx = 10; }
            
            x += dx;

	    if (y >= 320) { dy = -10; }
	    if (y <= 100) { dy = 10; }

	    y += dy;
	    size = size + 2;
	    if(size >= 75) {size = 10;}
 
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
