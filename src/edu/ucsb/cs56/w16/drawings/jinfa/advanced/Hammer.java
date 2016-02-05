package edu.ucsb.cs56.w16.drawings.jinfa.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a hammer that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jinfa Zhu
   @version for CS56, W16, UCSB
   
*/
public class Hammer extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of hammer
       @param y y coord of upper left corner of hammer
       @param length length of the handle of the hammer
       @param height height of hammerhead 
    */
    public Hammer(double x, double y, double length, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double hammerheadHeight = height;
        
        double handleLength=length;
        
        // Draw the handle
        
        Rectangle2D.Double handle = 
            new Rectangle2D.Double(x, y, length, height/5);
	
        // Draw the hammerhead
        
        Rectangle2D.Double hammerhead = 
            new Rectangle2D.Double (x+length, y - 2*height/5,
                               height/3, height);
	
        // put the whole parts together
	
        GeneralPath hammer = this.get();
        hammer.append(handle, false);
        hammer.append(hammerhead, false);   
    }
}
