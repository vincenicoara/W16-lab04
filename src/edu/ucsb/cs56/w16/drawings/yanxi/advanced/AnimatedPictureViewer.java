package edu.ucsb.cs56.w16.drawings.yanxi.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Yanxi Chen
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private BallonWithFace ballon = new BallonWithFace(100, 100, 50, 50);

    Thread anim;

    private int x = 100;
    private int y = 100;
    
    private int dx = 10;
    private int dy = 10;

    public static void main(String[] args){
	new AnimatedPictureViewer().go();
    }

    public void go(){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(640,480);
	frame.getContentPane().add(panel);
	frame.setVisible(true);
	anim = new Animate();
	anim.start();
    }

    class DrawPanel extends JPanel{
	public void paintComponent(Graphics g){
	    Graphics2D g2 = (Graphics2D) g;

	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    g2.setColor(Color.BLUE);
	    BallonWithFace b = new BallonWithFace(x, y, 50, 50);
	    g2.draw(b);
	}
    }
    
    class Animate extends Thread{
	public void run(){
	    try{
		while(true){
		    
		    if (x >= 600 || x <= 50){
			dx *= -1;
		    }
		    if (y >= 400 || y <= 50){
			dy *= -1;
		    }
		    x += dx;
		    y += dy;
		    panel.repaint();
		    Thread.sleep(50);
		}
	    } catch(Exception e){
		if(!(e instanceof InterruptedException))
		    e.printStackTrace();
		System.exit(1);
	    }
	}
    }
}
		    
