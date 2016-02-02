package edu.ucsb.cs56.w16.drawings.tnlarson.advanced;
import javax.swing.JFrame;
import java.awt.event.*;

/** A viewer class to see an animated Ghost by Troy Larson

    @author Troy Larson
    @version CS56, W16
*/

public class AnimatedPictureViewer extends JFrame
{
    // To make it clear to both myself and whoever may read this:
    // What I'm trying to do is animate the Ghost in a spiral motion
    
    // To make this animation easier, I'm going to use polar coordinates,
    // changing the radius and the angle theta with each call of paintComponent()

    
    Thread animate;
    AnimatedPictureComponent component;

    // With this system, it'll be a little weird.
    // the "origin" will be the center of the screen.
    // This lets the polar coordinates be relative to the center instead of the top-left.
    
    static final double init_radius = 300;
    static final double init_theta = 0;
    
    //velocity is measured in degrees.
    static final double radial_velocity = 0.66;
    static final double angular_velocity = 2.5;
    
    static final double width = 100;
    static final double height = 200;
    static final double center_x = 400;
    static final double center_y = 500;


    /** constructs a JFrame with an animated picture within
     */
    public AnimatedPictureViewer() {
	setSize(900, 900);

	setTitle("Troy Larson's Animated Ghost");

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	component = new AnimatedPictureComponent(init_radius, init_theta, center_x, center_y, radial_velocity, angular_velocity, width, height);

	animate = new Animate();
	animate.start();
	
	add(component);

	setVisible(true);
    }

    public static void main(String[] args) {
	AnimatedPictureViewer apv = new AnimatedPictureViewer();
    }

    class Animate extends Thread {
	public void run(){
	    try{
		while(true){
		    display(20); //1000/20 = 50 (in other words, set the frame rate to ~50fps)
		}
	    }catch(Exception ex){
		if(ex instanceof InterruptedException){
		    //nop
		} else {
		    System.err.println(ex);
		    System.exit(1);
		}
	    }
	}

	void display(int delay)
	throws InterruptedException {
	    component.repaint();

	    if(Thread.currentThread().interrupted())
		throw(new InterruptedException());

	    Thread.currentThread().sleep(delay);
	}
	
    }
    
}
