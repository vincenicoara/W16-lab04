package edu.ucsb.cs56.w16.drawings.jsegovia.advanced;

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
 * @author Jonathan Segovia
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few Towers 
     */
    
    public static void drawPicture1(Graphics2D g2) {

	Tower t1 = new Tower(0, 100, 100, 100);
	g2.setColor(Color.CYAN);
	g2.draw(t1);
	

	
	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	

	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	// Draw Storke Towers
	
	StorkeTower st1 = new StorkeTower(50,350,40,75);
	StorkeTower st2 = new StorkeTower(200,350,200,100);
	
	g2.draw(st1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(st2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few towers by Jonathan Segovia", 20,20);
    }
    
    
    /** Draw a picture with a few Towers and Storke Towers
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some Towers.
	
	Tower large = new Tower(100,50,225,150);
	Tower smallCC = new Tower(20,50,40,30);
	Tower tallSkinny = new Tower(20,150,20,40);
        Tower shortFat = new Tower(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	StorkeTower st1 = new StorkeTower(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(st1);
	

	Shape st2 = ShapeTransforms.scaledCopyOfLL(st1,0.5,0.5);
	st2 = ShapeTransforms.translatedCopyOf(st2,150,0);
	g2.setColor(Color.BLACK); g2.draw(st2);
	

	st2 = ShapeTransforms.scaledCopyOfLL(st2,4,4);
	st2 = ShapeTransforms.translatedCopyOf(st2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(st2); 
	
	
	StorkeTower st3 = new StorkeTower(50,350,40,75);
	StorkeTower st4 = new StorkeTower(200,350,200,100);
	
	g2.draw(st3);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape st3rotation = ShapeTransforms.rotatedCopyOf(st3, Math.PI/4.0);
	
	g2.draw(st3rotation);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Towers and Storke Towers by Jonathan Segovia", 20,20);
    }
    
    /** Draw a different picture with a few Storke Towers
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Storke Towers by Jonathan Segovia", 20,20);
	
	
	// Draw some Storke Towers.
	
	StorkeTower large = new StorkeTower(100,50,225,150);
	StorkeTower smallST = new StorkeTower(20,50,40,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallST);
	
    }       
}
