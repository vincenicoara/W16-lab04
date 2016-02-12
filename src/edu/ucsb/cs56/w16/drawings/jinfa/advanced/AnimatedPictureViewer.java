package edu.ucsb.cs56.w16.drawings.jinfa.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Jinfa Zhu
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
    
    private DrawPanel panel = new DrawPanel();
    
    private RockHammer RockHammer = new RockHammer(50, 50, 100, 50);
    
    private Hammer Hammer = new Hammer(150, 100, 100, 50);
    
    Thread anim;   
    
    private int x = 50;
    private int y = 50;
    
    private int dx = 5;
    private int dy = 5;
    
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }
    
    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.getContentPane().add(panel);
	frame.setSize(960,640);
	frame.setVisible(true);
	frame.setTitle("Jinfa Zhu's Animated Drawing");
	
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
	    // Draw the RockHammer
	    int red = (int)(Math.random()*256);
	    int green = (int)(Math.random()*256);
	    int blue = (int)(Math.random()*256);
	    g2.setColor(new Color(red,green,blue));
	    int length=(int)(Math.random()*100)+100;
	    int width=length/2;
	    RockHammer rh = new RockHammer(x, y, length, width);
	    Hammer h = new Hammer(x+length+width, y+width/2, length, width);
	    g2.draw(rh);
	    g2.draw(h);
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    if (x >= 400) { dx = -5; }
		    if (x <= 50 ) { dx = 5;  }
		    if (y >= 480) { dy = -5; }
		    if (y <= 60) { dy = 5;  }
		    
		    x += dx;
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
