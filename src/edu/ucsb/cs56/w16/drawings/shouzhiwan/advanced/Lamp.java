package edu.ucsb.cs56.w16.drawings.shouzhiwan.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Shouzhi Wan
   @version for CS56, W16, UCSB
   
*/
public class Lamp extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
    */
    public Lamp(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double coverH = .25 * height;
        double barH = height - coverH;
        double bottomH = .05 * height;

	double coverW = width;
	double barW = 0.1 * width;
	double bottomW = width;
        // Make the first story
	double locBarX =x + 0.5 * coverW - 0.5 *barW;
        double locBarY = y + coverH;
	double locBottomX = x;
	double locBottomY = locBarY + barH;
        Rectangle2D.Double top = 
            new Rectangle2D.Double(x, y ,
				   width, coverH);
	
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen

	Rectangle2D.Double middle =
	    new Rectangle2D.Double(locBarX, locBarY, barW,barH);

	Rectangle2D.Double bottom =
	    new Rectangle2D.Double(locBottomX, locBottomY, bottomW, bottomH);
       
        // put the whole house together
	
        GeneralPath wholeLamp = this.get();
        wholeLamp.append(top, false);
        wholeLamp.append(middle, false);
        wholeLamp.append(bottom, false);    
    }
}
