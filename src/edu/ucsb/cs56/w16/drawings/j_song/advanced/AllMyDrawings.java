package edu.ucsb.cs56.w16.drawings.j_song.advanced;

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
 * @author Joseph Song
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few controllers and SNES controllers
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Controller c1 = new Controller(100,270,90,50);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.ORANGE); g2.draw(c2);
	
	c2 = ShapeTransforms.scaledCopyOfLL(c2,3,3);
	c2 = ShapeTransforms.translatedCopyOf(c2,140,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x87A96B)); 
	g2.draw(c2); 
	
	SNESController sc0 = new SNESController(50,75,100,75);
	SNESController sc1 = new SNESController(180,150,200,100);
	
	g2.draw(sc0);
	g2.setColor(new Color(0x89CFF0)); g2.draw(sc1);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some inaccurate Nintendo controllers by Joseph Song", 20,20);
    }
    
    
    /** Draw a picture with a few controllers
     */
    public static void drawPicture2(Graphics2D g2) {
	
	
	Controller bigC = new Controller(100,50,400,220);
	Controller littleC = new Controller(20,75,40,30);
	Controller longC = new Controller(20,150,20,100);
	Controller wideC = new Controller(40,250,100,20);
	
	g2.setColor(Color.PINK);     g2.draw(bigC);
	g2.setColor(Color.GREEN);   g2.draw(littleC);
	g2.setColor(Color.BLUE);    g2.draw(longC);
	g2.setColor(Color.YELLOW); g2.draw(wideC);
	
	Shape c1 = ShapeTransforms.scaledCopyOfLL(bigC,0.5,0.5);
	c1 = ShapeTransforms.translatedCopyOf(c1,150,120);
	g2.setColor(Color.ORANGE); g2.draw(c1);
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	// Rotate this controller 45 degrees around its center.
	Shape c2 = ShapeTransforms.rotatedCopyOf(c1, Math.PI/4.0);
    c2 = ShapeTransforms.translatedCopyOf(c2, 160, 30);
	g2.setColor(Color.DARK_GRAY);
	g2.draw(c2);
	
	g2.setColor(Color.BLACK); 
	g2.drawString("Picasso's controllers by Joseph Song", 20,20);
    }
    
    /** Draw one SNES Controller
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("The lone SNES Controller by Joseph Song", 20,20);
	
	
	SNESController lone = new SNESController(130,140,400,200);
	
	g2.setColor(Color.BLACK);     g2.draw(lone);
	
    }       
}
