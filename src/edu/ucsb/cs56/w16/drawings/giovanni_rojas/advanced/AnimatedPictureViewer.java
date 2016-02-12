package edu.ucsb.cs56.w16.drawings.giovanni_rojas.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * A main class to view an animation
 *
 * @author Giovanni Rojas
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    private HalfDozen h1 = new HalfDozen(30, 90, 580, 200);

    Thread anim;

    private int x = 30;
    private int y = 90;

    private int dx = 5;
    private int dy = 5;

    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(840,680);
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

	    // Draw the HalfDozen
	    Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	    Stroke orig=g2.getStroke();
	    g2.setStroke(thick);
	    g2.setColor(Color.RED);
	    HalfDozen test = new HalfDozen(x, y, 580, 200);
	    g2.draw(test);
	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Bounce off the walls
		    if (y >= 380) { dy = (int)( Math.random()*50*(-1)); }
		    if (y <= 0) { dy = (int) (Math.random()*50); }
		    if (x <= 0) { dx = (int) (Math.random()*50); }
		    if (x >= 260) { dx = (int) (Math.random()*50*(-1)); }

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
