package edu.ucsb.cs56.w16.drawings.changreytang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of an touch screen phone using
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Chang Rey Tang 
   @version for CS56, W16, UCSB
   
*/
public class TouchScreenPhone extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of phone from the left
       @param y y coord of upper left corner of phone from the top 
       @param height height of the phone 
    */
    public TouchScreenPhone(double x, double y, double height)
    {
	
	double phoneHeight = height;
	double screenHeight = 0.9*phoneHeight;
	double phoneWidth = 0.6*height;
	double screenWidth = 0.9*phoneWidth;
        
        
        
        Rectangle2D.Double phoneBody = 
            new Rectangle2D.Double(x, y, phoneWidth, phoneHeight); 
	
	Rectangle2D.Double phoneScreen =
	    new Rectangle2D.Double(x+(phoneHeight*0.025), y+(phoneWidth*0.025), 
				   screenWidth, screenHeight);        

        GeneralPath phone = this.get();
        phone.append(phoneBody, false);
        phone.append(phoneScreen, false);
    }
}
