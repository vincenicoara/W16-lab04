package edu.ucsb.cs56.w16.drawings.giovanni_rojas.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of an eggcarton that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
*/
public class EggCarton extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of egg carton
       @param y y coord of lower left corner of egg carton
       @param width width of the egg carton
       @param height of egg carton
    */
    public EggCarton(double x, double y, double width, double height)
    {
	
            Rectangle2D.Double carton = 
            new Rectangle2D.Double(x, y ,
				   width, 0.45 * width);
	
        GeneralPath wholeCarton = this.get();
	wholeCarton.append(carton, false);
    }
}
