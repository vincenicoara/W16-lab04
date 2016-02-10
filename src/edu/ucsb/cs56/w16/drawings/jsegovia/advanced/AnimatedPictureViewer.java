package edu.ucsb.cs56.w16.drawings.jsegovia.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Jonathan Segovia
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private StorkeTower st = new StorkeTower(100, 100, 150, 50);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int height = 50;
    private int width = 130;
    
    private int dx = 5;
    private int dh = 10;
    private int dw = 10;

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
        public void mousePressed(MouseEvent e){
	    System.out.println("Mouse clicked");
	    anim = new Animation();
	    anim.start();
        }
	      
	public void mouseReleased(MouseEvent e){        
	    System.out.println("Mouse released");
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
	   g2.setColor(Color.cyan);
	   g2.fillRect(0,0,this.getWidth(), this.getHeight());
	   
	   // Draw Storke Tower and print message
	   g2.setColor(Color.BLACK);
	   g2.drawString("Press and hold to animate", 20,20);
	   StorkeTower test = new StorkeTower(x, y, width, height);
	   g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400){
		dx = -5;
		dw = -10;
		dh = -10;
	    }
            if (x <= 50) {
		dx = 5;
		dw = 10;
		dh = 10;
	    }
            
            x += dx;
	    width += dw;
	    height += dh;
            panel.repaint();
            Thread.sleep(15);
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
