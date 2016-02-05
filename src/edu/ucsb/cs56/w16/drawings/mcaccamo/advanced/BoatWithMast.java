package edu.ucsb.cs56.w16.drawings.mcaccamo.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a Boat with a mast  that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Michael Caccamo
   @version for CS56, W16, UCSB
   
*/

public class BoatWithMast extends Boat implements Shape{

    public BoatWithMast( double x, double y, double width){
	super(x,y,width);
	GeneralPath gp = this.get();


	double fl = .25 * width;

	Line2D.Double mast = new Line2D.Double( x + width /2, y, x+ width /2 , y -(width  * .45) );
	
	Rectangle2D.Double flag  =
	    new Rectangle2D.Double(x + width/2, y - (width * .45) , width/6,  width/6   );

	GeneralPath wholeBoat = this.get();
	wholeBoat.append(mast, false);
		wholeBoat.append(flag, false);
    }}
