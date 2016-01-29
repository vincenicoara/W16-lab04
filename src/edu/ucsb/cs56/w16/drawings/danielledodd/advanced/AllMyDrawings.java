package edu.ucsb.cs56.w16.drawings.danielledodd.advanced;

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
 * @author Phill Conrad, edited for Car by Danielle DOdd
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few cars and trucks 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	//for the average car look, width should be greater than height
	Car c1 = new Car(200,250,75,50); //x, y, width, height
	g2.setColor(Color.RED); g2.draw(c1);
	
	// Make a dark gray car that's 1/4 the size, of c1 
	// and moved it
	
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.25,0.25);
	c2 = ShapeTransforms.translatedCopyOf(c2,100,100);
	g2.setColor(Color.darkGray); g2.draw(c2);
	
	// Here's a car that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,6,6);
	c2 = ShapeTransforms.translatedCopyOf(c2,100,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	
	Truck t1 = new Truck(10,10,50,50);
	g2.draw(t1);
	g2.setColor(new Color(0xB284BE)); g2.draw(t1); // color is "african violet"
	
	// FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLUE); 
	g2.drawString("A Few Cars by Danielle Dodd", 100,20);
    }
    
    
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some trucks.
	
	Truck large = new Truck(10,50,150, 60);
	Truck toy = new Truck(250,50,40,30);
	Truck boxy = new Truck(330,250,100,100);
	Truck tall = new Truck(10,150,50,150);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.ORANGE);   g2.draw(toy);
	g2.setColor(Color.YELLOW);    g2.draw(boxy);
	g2.setColor(Color.MAGENTA); g2.draw(tall);
	
	Car c1 = new Car(200,200,50,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black car that's half the size, 
	// and moved over 150 pixels in x direction
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,80,-20);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	Shape c3 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c3 = ShapeTransforms.translatedCopyOf(c3,90,-80);
	c3 = ShapeTransforms.rotatedCopyOf(c3, Math.PI/4.0);
	g2.setColor(Color.GREEN); g2.draw(c3);
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x3D2B1F)); //color is "bistre" 
	g2.draw(c2); 
	
	
	// Rotate the toy truck 180 degrees around its center.
	Shape t3 = ShapeTransforms.rotatedCopyOf(toy, Math.PI);
	t3 = ShapeTransforms.translatedCopyOf(t3, 10, 300);
	g2.draw(t3);
	
	// FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLUE); 
	g2.drawString("Cars and Trucks by Danielle Dodd", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A street by Danielle Dodd", 20,20);
	
	
	// Draw some cars/trucks.
	
	Truck t1 = new Truck(20,50,40,30);
	Truck t2 = new Truck(100,50,40,30);
	Truck t3 = new Truck(180,50,40,30);
	Truck t4 = new Truck(260,50,40,30);
	Truck t5 = new Truck(340,50,40,30);
	Car c1 = new Car(30, 150, 40, 30);
	Car c2 = new Car(90, 150, 40, 30);
	Car c3 = new Car(150, 150, 40, 30);
	Car c4 = new Car(200, 150, 40, 30);
	Car c5 = new Car(270, 150, 40, 30);
	g2.setColor(Color.RED);     g2.draw(t1);
	g2.setColor(Color.GREEN);   g2.draw(t2);
	g2.setColor(Color.YELLOW);     g2.draw(t3);
	g2.setColor(Color.BLACK);     g2.draw(t4);
	g2.setColor(Color.GRAY);     g2.draw(t5);
	g2.setColor(Color.BLUE);     g2.draw(c1);
	g2.setColor(Color.CYAN);     g2.draw(c2);
	g2.setColor(Color.PINK);     g2.draw(c3);
	g2.setColor(Color.ORANGE);     g2.draw(c4);
	
	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLUE); 
	g2.drawString("A Street by Danielle Dodd", 350,350);
    }       
}
