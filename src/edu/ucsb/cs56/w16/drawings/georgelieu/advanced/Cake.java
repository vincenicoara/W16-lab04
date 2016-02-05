package edu.ucsb.cs56.w16.drawings.georgelieu.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a cake that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author George Lieu
   @version for CS56, W16, UCSB
   
*/
public class Cake extends GeneralPathWrapper implements Shape
{
    /**
       Constructor for a general Cake
       
       @param x x coord of lower left corner of cake
       @param y y coord of lower left corner of cake
       @param width width of the cake
       @param height of cake 
    */
    public Cake(double x, double y, double width, double height)
    {

	double bottomLayerHeight = (.44) * height;
	double middleLayerHeight = (.34) * height;
	double topLayerHeight = (.22) * height;
	
	double middleLayerWidth = .5 * width;
	double topLayerWidth = .25 * width;

	double bottomLayerUpperLeftY = y + topLayerHeight + middleLayerHeight; 
	double middleLayerUpperLeftY = y + topLayerHeight;
	double topLayerUpperLeftY = y;

	// draws bottom layer of the cake
	Rectangle2D.Double bottomLayer =
	    new Rectangle2D.Double(x,bottomLayerUpperLeftY,
				   width, bottomLayerHeight);

	//draws middle layer of cake
	
	Rectangle2D.Double middleLayer =
	    new Rectangle2D.Double(x + (.5*middleLayerWidth), middleLayerUpperLeftY,
				   middleLayerWidth, middleLayerHeight);

	//draws top layer of the cake	
	
	Rectangle2D.Double topLayer =
	    new Rectangle2D.Double(x + (.5*middleLayerWidth) + (.5*topLayerWidth),
				   topLayerUpperLeftY,topLayerWidth, topLayerHeight);
	
        // put the whole cake together
	
        GeneralPath wholeCake = this.get();
        wholeCake.append(bottomLayer, false);
        wholeCake.append(middleLayer, false);
	wholeCake.append(topLayer,false);
    }
}
