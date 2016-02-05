package edu.ucsb.cs56.w16.drawings.changreytang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of an Apple iPhone which extends 
   TouchScreenPhone using the Shape interface, and 
   so can be drawn, as well as rotated, scaled, etc.
      
   @author Chang Rey Tang 
   @version for CS56, W16, UCSB
   
*/
public class IPhone extends TouchScreenPhone implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of phone from the left
       @param y y coord of upper left corner of phone from the top 
       @param height height of the phone 
    */
    public IPhone(double x, double y, double height)
    {
	super(x,y,height);
	
	GeneralPath gp = this.get();	

	double phoneHeight = height;
	double phoneWidth = 0.6*height;
	double xhalf = phoneWidth/2;
	double yhalf = phoneHeight/2;
	
	Line2D.Double line1 = new Line2D.Double(x+xhalf,y+yhalf+yhalf*0.2,
			       		        x+xhalf+xhalf*0.3,y+yhalf+yhalf*0.25);
	Line2D.Double line2 = new Line2D.Double(x+xhalf+xhalf*0.3,y+yhalf+yhalf*0.25,
					        x+xhalf+xhalf*0.45,y+yhalf);
	Line2D.Double line3 = new Line2D.Double(x+xhalf+xhalf*0.45,y+yhalf,
						x+xhalf+xhalf*0.25,y+yhalf-yhalf*0.2);
	Line2D.Double line4 = new Line2D.Double(x+xhalf+xhalf*0.25,y+yhalf-yhalf*0.2,
						x+xhalf,y+yhalf-yhalf*0.15);
	Line2D.Double line5 = new Line2D.Double(x+xhalf,y+yhalf-yhalf*0.15,
						x+xhalf-xhalf*0.25,y+yhalf-yhalf*0.2);
	Line2D.Double line6 = new Line2D.Double(x+xhalf-xhalf*0.25,y+yhalf-yhalf*0.2,
						x+xhalf-xhalf*0.45,y+yhalf);
	Line2D.Double line7 = new Line2D.Double(x+xhalf-xhalf*0.45,y+yhalf,
						x+xhalf-xhalf*0.3,y+yhalf+yhalf*0.25);
	Line2D.Double line8 = new Line2D.Double(x+xhalf-xhalf*0.3,y+yhalf+yhalf*0.25,
						x+xhalf,y+yhalf+yhalf*0.2);
	Line2D.Double line9 = new Line2D.Double(x+xhalf,y+yhalf-yhalf*0.2,
						x+xhalf,y+yhalf-yhalf*0.25);
	Line2D.Double line10 = new Line2D.Double(x+xhalf,y+yhalf-yhalf*0.25,
						 x+xhalf+xhalf*0.1,y+yhalf-yhalf*0.3);
	Line2D.Double line11 = new Line2D.Double(x+xhalf+xhalf*0.1,y+yhalf-yhalf*0.3,
						 x+xhalf+xhalf*0.1,y+yhalf-yhalf*0.25);
	Line2D.Double line12 = new Line2D.Double(x+xhalf+xhalf*0.1,y+yhalf-yhalf*0.25,
						 x+xhalf,y+yhalf-yhalf*0.2);
	

        GeneralPath apple = this.get();
        apple.append(line1, false);
	apple.append(line2, false);
	apple.append(line3, false);
	apple.append(line4, false);
	apple.append(line5, false);
	apple.append(line6, false);
	apple.append(line7, false);
	apple.append(line8, false);
	apple.append(line9, false);
	apple.append(line10, false);
	apple.append(line11, false);
	apple.append(line12, false);
    }
}
