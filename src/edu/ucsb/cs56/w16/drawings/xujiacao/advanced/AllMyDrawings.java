package edu.ucsb.cs56.w16.drawings.xujiacao.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Xujia Cao
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few screen and monitors 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Screen s1 = new Screen(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black screen that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a screen that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw two monitor
	
	Monitor m1 = new Monitor(50,350,40,75);
	Monitor m2 = new Monitor(200,350,200,100);
	
	g2.draw(m1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(m2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few scrrens and monitors by Xujia Cao", 20,20);
    }
    
    
    /** Draw a picture with a few monitor and screen
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some monitor.
	
	Monitor large = new Monitor(100,50,225,150);
	Monitor smallM = new Monitor(20,50,40,30);
	Monitor tallSkinny = new Monitor(20,150,20,40);
	Monitor shortFat = new Monitor(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallM);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Screen s1 = new Screen(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black screen that's half the size, 
	// and moved over 150 pixels in x direction
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw two Monitor
	
	Monitor m1 = new Monitor(50,350,40,75);
	Monitor m2 = new Monitor(200,350,200,100);
	
	g2.draw(m1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second monitor 45 degrees around its center.
	Shape m3 = ShapeTransforms.rotatedCopyOf(m2, Math.PI/4.0);
	
	g2.draw(m3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Monitor and a few screen by Xujia Cao", 20,20);
    }
    
    /** Draw a different picture with a few Monitors
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Monitor by Xujia Cao", 20,20);
	
	
	// Draw some coffee cups.
	
	Monitor large = new Monitor(100,50,225,150);
	Monitor smallM = new Monitor(20,50,40,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallM);
	
    }       
}
