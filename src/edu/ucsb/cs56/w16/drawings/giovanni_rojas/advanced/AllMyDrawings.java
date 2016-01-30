package edu.ucsb.cs56.w16.drawings.giovanni_rojas.advanced;

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
	
	EggCarton e1 = new EggCarton(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(e1);
	
	Shape e2 = ShapeTransforms.scaledCopyOfLL(e1,0.5,0.5);
	e2 = ShapeTransforms.translatedCopyOf(e2,150,0);
	g2.setColor(Color.BLACK); g2.draw(e2);
	
	e2 = ShapeTransforms.scaledCopyOfLL(e2,4,4);
	e2 = ShapeTransforms.translatedCopyOf(e2,150,0);
		
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(e2); 
	
	// Draw two houses with Windows
	
	HalfDozen h1 = new HalfDozen(50,350,40,75);
	HalfDozen h2 = new HalfDozen(200,350,200,100);
	
	g2.draw(h1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(h2);
	
      	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("HalfDozens by Gio", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	HalfDozen h1 = new HalfDozen(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
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
	
	// Draw two houses with Windows
	
	HalfDozen hd1 = new HalfDozen(90,210,90,175);
	HalfDozen hd2 = new HalfDozen(20,50,200,199);
	
	g2.draw(hd1);
	g2.setColor(new Color(0x8F00FF)); 
	
	Shape hd3 = ShapeTransforms.rotatedCopyOf(hd2, Math.PI/4.0);
	
	g2.draw(hd3);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLUE); 
	g2.drawString("Some more egg cartons", 40,40);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("One GIGANTIC HalfDozen", 20,20);

		
	HalfDozen h1 = new HalfDozen(0,40,580,200);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.RED);
	g2.draw(h1);
    }
}
