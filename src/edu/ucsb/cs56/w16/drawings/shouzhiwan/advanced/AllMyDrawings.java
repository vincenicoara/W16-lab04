package edu.ucsb.cs56.w16.drawings.shouzhiwan.advanced;

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
 * @author Shouzhi Wan
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
  
    
    public static void drawPicture1(Graphics2D g2) {

	
	FloorLamp fl1 =new FloorLamp (70,400,60,80);
	FloorLamp fl2 =new FloorLamp (400, 700, 300, 150);

	g2.setColor(Color.BLACK); g2.draw(fl1);
	

	
	Shape l2 = ShapeTransforms.scaledCopyOfLL(fl1,0.5,0.5);
	l2 = ShapeTransforms.translatedCopyOf(fl2,150,0);
	g2.setColor(Color.BLUE); g2.draw(l2);
	

	l2 = ShapeTransforms.scaledCopyOfLL(l2,3,3);
	l2 = ShapeTransforms.translatedCopyOf(l2,200,0);
	


	
	g2.draw(fl1);
	g2.setColor(new Color(0x8F00FE)); g2.draw(fl2);
	

	
	//	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few FloorLamp by Shouzhi Wan", 25,25);
    }
    
    

    public static void drawPicture2(Graphics2D g2) {
	
	
	Lamp l1 = new Lamp(140,300,50,75);
	g2.setColor(Color.CYAN); g2.draw(l1);

	Shape l2 = ShapeTransforms.scaledCopyOfLL(l1,0.5,0.5);
	l2 = ShapeTransforms.translatedCopyOf(l2,150,0);
	g2.setColor(Color.BLACK); g2.draw(l2);
	

	l2 = ShapeTransforms.scaledCopyOfLL(l2,30,40);
	l2 = ShapeTransforms.translatedCopyOf(l2,25,15);
	
	FloorLamp fl2 = new FloorLamp(400,200,200,150);
	FloorLamp fl1 = new FloorLamp(70,80,150,250);
	g2.draw(fl1);
	g2.setColor(new Color(0x8FEEFF)); 
	

	Shape fl3 = ShapeTransforms.rotatedCopyOf(fl2, Math.PI/2.0);
	
	g2.draw(fl3);
	
	//	g2.setStroke(orig);
	g2.setColor(Color.RED); 
	g2.drawString("Some lamps by Shouzhi Wan", 30,30);
    }
    

    
    public static void drawPicture3(Graphics2D g2) {
	

	
	g2.drawString("Some Lamps by Shouzhi Wan", 20,20);
	
	
	
	FloorLamp largefl = new FloorLamp(150,50,500,400);
	FloorLamp smallfl = new FloorLamp(20,70,30,40);
	
	g2.setColor(Color.BLUE);     g2.draw(largefl);
	g2.setColor(Color.BLACK);   g2.draw(smallfl);
	
    }       
}
