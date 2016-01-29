package edu.ucsb.cs56.w16.drawings.j_song.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a controller that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
*/
public class Controller extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of controller
       @param y y coord of lower left corner of controller
       @param width width of the controller
       @param height of the controller
    */
    public Controller(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        // Make the body of the controller
        
        Rectangle2D.Double controllerBody = 
            new Rectangle2D.Double(x, y,
				   width, height);
	
        // add the buttons.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        double buttonRadius = .15 * height;

        Circle button0 = new Circle(x+(width*.75), y+(height*.75));

        // put the whole Controller together
	
        GeneralPath wholeController = this.get();
        wholeHouse.append(controllerBody, false);
        wholeHouse.append(button0, false);
        wholeHouse.append(rightRoof, false);    
    }
}
