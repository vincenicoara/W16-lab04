package edu.ucsb.cs56.w16.drawings.danielledodd.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A  drawing of a car that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author  Danielle Dodd
   @version for CS56, W16, UCSB
   
*/
public class Car extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of car (exluding wheels)
       @param y y coord of lower left corner of car (excluding wheels)
       @param width width of the car
       @param height height of car
       @param wheelRadius radius of the wheels
    */
    public Car(double x, double y, double width, double height)
    {
	double wheelDiameter = 2*width*.125;
        // Rather than having to scale at the end, we can just
	Rectangle2D.Double carBody = 
	    new Rectangle2D.Double(x, y, width, height);
        Ellipse2D.Double leftWheel= 
	    new Ellipse2D.Double(x + .125*width, y+height, 
				 wheelDiameter, wheelDiameter);
	Ellipse2D.Double rightWheel = 
	    new Ellipse2D.Double(x+.625*width, y+height,
				 wheelDiameter, wheelDiameter); 
        // put the whole car together
	
        GeneralPath wholeCar = this.get();
        wholeCar.append(carBody, false);
        wholeCar.append(leftWheel, false);
        wholeCar.append(rightWheel, false);    
    }
}
