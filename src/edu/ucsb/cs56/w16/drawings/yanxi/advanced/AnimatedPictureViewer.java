package edu.ucsb.cs56.w16.drawings.yanxi.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

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

    private int x1 = 100;
    private int y1 = 100;
    private int x2 = 400;
    private int y2 = 110;
    
    private int r = 50;
    private int l = 50;
    private int dx1 = 10;
    private int dy1 = 10;
    private int dx2 = -10;
    private int dy2 = 10;
    
    private Color color = Color.BLUE;
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

	frame.getContentPane().addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		    dx1 ++;
		    dy1 --;
		    dx2 --;
		    dy2 ++;
		}
	    });
    }

    class DrawPanel extends JPanel{
	public void paintComponent(Graphics g){
	    Graphics2D g2 = (Graphics2D) g;

	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    g2.setColor(color);
	    BallonWithFace b = new BallonWithFace(x1, y1, r, l);
	    BallonWithFace a = new BallonWithFace(x2, y2, r, l);
	    g2.draw(b);
	    g2.draw(a);
	}
    }
    
    class Animate extends Thread{
	public void run(){
	    try{
		while(true){
		    if (x1 >= 600 || x1 <= 50){
			dx1 *= -1;
		    }
		    if (y1 >= 400 || y1 <= 50){
			dy1 *= -1;
		    }
		    if (x2 >= 600 || x2 <= 50){
			dx2 *= -1;
		    }
		    if (y2 >= 400 || y2 <= 50){
			dy2 *= -1;
		    }
		    if(Math.hypot((x1-x2), (y1-y2)) <= r){
			dx1 *= -1;
			dy1 *= -1;
			dx2 *= -1;
			dy2 *= -1;
		    }
		    x1 += dx1;
		    y1 += dy1;
		    x2 += dx2;
		    y2 += dy2;
		    
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

