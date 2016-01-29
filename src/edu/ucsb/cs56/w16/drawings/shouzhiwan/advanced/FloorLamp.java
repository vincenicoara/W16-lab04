package edu.ucsb.cs56.w16.drawings.shouzhiwan.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A House
      
   @author Shouzhi Wan
   @version for CS56, W16, UCSB
   
*/
public class FloorLamp extends Lamp implements Shape
{
    public FloorLamp(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        super(0,0,0,0);
        double coverH = .75 * height;
        double barH = 2*height - coverH;
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
	
        GeneralPath wholeFloorLamp = this.get();
        wholeFloorLamp.append(top, false);
        wholeFloorLamp.append(middle, false);
        wholeFloorLamp.append(bottom, false);
    }
}
