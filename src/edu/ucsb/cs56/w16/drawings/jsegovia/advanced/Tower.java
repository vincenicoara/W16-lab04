package edu.ucsb.cs56.w16.drawings.jsegovia.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a Tower that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jonathan Segovia
   @version for CS56, W16, UCSB
   
*/
public class Tower extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of the tower
       @param y y coord of lower left corner of the tower
       @param width width of the tower
       @param height of tower (including first story and second story)
    */
    public Tower(double x, double y, double width, double height)
    {
	double newWidth = width/4.0;
	double newHeight = height*3.5;
	
        Rectangle2D.Double newTower = 
            new Rectangle2D.Double(x, y,newWidth, newHeight);
	
       	
        GeneralPath tower = this.get();
	tower.append(newTower, false);
       
    }
}
