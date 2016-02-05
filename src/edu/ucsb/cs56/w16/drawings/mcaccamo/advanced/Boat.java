package edu.ucsb.cs56.w16.drawings.mcaccamo.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a boat that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Michael Caccamo
   @version for CS56, W16, UCSB
   
*/
public class Boat extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of boat
       @param y y coord of lower left corner of boat
       @param width width of the house, will be used to calculate height
      
    */
    public Boat(double x, double y, double width)
    {
	
        
        Rectangle2D.Double Hull = 
            new Rectangle2D.Double(x, y,
				   width, width/4);
       

	
        GeneralPath Boat = this.get();
	Boat.append(Hull, false);
        
    }
}
