package edu.ucsb.cs56.w16.drawings.jinfa.advanced;

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
 * @author Phill Conrad 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	

	Hammer h1=new Hammer(100,250,60,30);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black hammer that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 =ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	// Here's a hammer that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,200);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two rock hammers


	RockHammer rh1= new RockHammer(50,350,100,40);
	RockHammer rh2= new RockHammer(200,350,200,80);
	g2.draw(rh1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(rh2);
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few hammers by Jinfa Zhu", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	RockHammer large = new RockHammer(100,400,225,150);
	RockHammer small = new RockHammer(20,50,40,30);
	RockHammer tallSkinny = new RockHammer(20,150,20,40);
	RockHammer shortFat = new RockHammer(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Hammer h1 = new Hammer(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black hammer that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a hammer that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two RockHammers
	
	RockHammer rh1= new RockHammer(50,350,100,40);
	RockHammer rh2= new RockHammer(200,350,200,80);
	
	g2.draw(rh1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape rh3 = ShapeTransforms.rotatedCopyOf(rh2, Math.PI/4.0);
	
	g2.draw(rh3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Rock hammers and hammers by Jinfa Zhu", 20,20);
    }
    
    /** Draw a different picture with rock hammers and hammers
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Some Hammers", 20,20);
	
	
	// Draw some coffee cups.
	
	RockHammer large = new RockHammer(100,200,225,150);
	RockHammer small = new RockHammer(20,50,40,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	
    }       
}
