package edu.ucsb.cs56.w16.drawings.shouzhiwan.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Shouzhi Wan
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    private Lamp lamp = new Lamp(160,300,100,400);
    // private FloorLamp fl = new FloorLamp(150,400,320,400);
    Thread anim;

    private int x = 100;
    private int y = 100;

    private int dx = 5;
    private int dy = -5;
    public static void main (String[] args){
	new AnimatedPictureViewer().go();
    }

    public void go(){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(640,640);
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
    }
    
    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {

	    Graphics2D g2 = (Graphics2D) g;
	    
	    // Clear the panel first
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    
	    int red = (int)(Math.random()*256);
	    int blue = (int)(Math.random()*256);
	    int green = (int)(Math.random()*256);
	    g2.setColor(new Color(red, blue, green));
	    int ranx = (int)(Math.random()*100);
	    int rany = (int)(Math.random()*100);
	    Lamp test = new Lamp(x, y, ranx, rany);
	    g2.draw(test);
	    
	    //Graphics2D g22 = (Graphics2D) g;
	    /*
	    int red2 = (int)(Math.random()*256);
	    int blue2 = (int)(Math.random()*256);
	    int green2 = (int)(Math.random()*256);
	    g2.setColor(new Color(red2, blue2, green2));
	    int ranx2 = (int)(Math.random()*100);
	    int rany2 = (int)(Math.random()*100);*/
	    FloorLamp test2 = new FloorLamp(x, y, ranx, rany);
	    g2.draw(test2);
	    
	    
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Bounce off the walls

		    if (x >= 600) { dx = -3; }
		    if (x <= 100) { dx = 3; }
		    if (y >= 600) { dy = -5;}
		    if (y <= 100) { dy = 5;}
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
