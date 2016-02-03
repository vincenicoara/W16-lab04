package edu.ucsb.cs56.w16.drawings.georgelieu.advanced;

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
    /** Draw a picture with two cakes and a Birthday cake
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Cake large = new Cake(300,300,300,300);
	Cake small = new BirthdayCake(100,100,100,100); 
	Cake medium = new Cake(200,200,200,200);

	g2.setColor(Color.RED);
	Shape different3 = ShapeTransforms.scaledCopyOfLL(large,0.5, 0.5);
	g2.draw(different3);

	Shape different = ShapeTransforms.translatedCopyOf(medium,100, 25);
	g2.setColor(Color.ORANGE);
	g2.draw(different);
	
	g2.setColor(Color.BLUE);
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);      
	g2.setStroke(thick);
	Shape different2 = ShapeTransforms.rotatedCopyOf(small, Math.PI/2.0);
	g2.draw(different2);

	g2.setColor(Color.YELLOW); 
	g2.drawString("A Mix of Cakes by George Lieu", 20,20);
       
    }
    
    
    /** Draw a picture with some cakes 
     */
    public static void drawPicture2(Graphics2D g2) {
	
	Cake large = new Cake(50,50,200,200);
	Cake small = new Cake(75,75,100,100); 
	Cake medium = new Cake(100,100,150,150);

	g2.setColor(Color.CYAN);
	Shape different3 = ShapeTransforms.scaledCopyOfLL(large,.75, .75);
	g2.draw(different3);

	Shape different = ShapeTransforms.translatedCopyOf(medium,100,33);
	g2.setColor(Color.BLACK);
	g2.draw(different);
	
	g2.setColor(Color.GREEN);
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);      
	g2.setStroke(thick);
	Shape different2 = ShapeTransforms.rotatedCopyOf(medium, Math.PI);
	g2.draw(different2);

	g2.setColor(Color.BLUE); 
	g2.drawString("A Mix of Cakes by George Lieu", 20,100);

    }
    
    /** Draw a different picture with some Birthday Cakes
     */
    
    public static void drawPicture3(Graphics2D g2) {
	

	Cake large = new BirthdayCake(200,123,421,123);
	Cake small = new BirthdayCake(50,50,50,50);
	Cake medium = new BirthdayCake(100,75, 100, 75);

	g2.setColor(Color.RED);
	Shape different3 = ShapeTransforms.scaledCopyOfLL(large,0.5, 0.5);
	g2.draw(different3);

	Shape different = ShapeTransforms.translatedCopyOf(medium,0, 150);
	g2.setColor(Color.GREEN);
	g2.draw(different);
	
	g2.setColor(Color.BLUE);
	Shape different2 = ShapeTransforms.rotatedCopyOf(medium, Math.PI/4.0);
	g2.draw(different2);

	g2.setColor(Color.BLACK); 
	g2.drawString("A Mix of Birthday Cakes by George Lieu", 20,20);
	
    }       
}
