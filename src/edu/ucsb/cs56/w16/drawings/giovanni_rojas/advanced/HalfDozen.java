package edu.ucsb.cs56.w16.drawings.giovanni_rojas.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of an eggcarton that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author Phill Conrad
   @version for CS56, W16, UCSB

*/
public class HalfDozen extends EggCarton implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of egg carton
       @param y y coord of lower left corner of egg carton
       @param width width of the egg carton
       @param height of egg carton
    */
    public HalfDozen(double x, double y, double width, double height)
    {

	super(x, y, width, height);
	GeneralPath wholeCarton = this.get();

	double r = width * 0.13;
	double firstColumnX = x + (0.25 * width);
	double secondColumnX = x + (0.5 * width);
	double thirdColumnX = x + (0.75 * width);
	double firstRowY = y + (0.33 * 0.37 * width);
	double secondRowY = y + (0.66 * 0.37 * width);

	Ellipse2D.Double egg1 = new Ellipse2D.Double(firstColumnX, firstRowY, r, r);
	Ellipse2D.Double egg2 = new Ellipse2D.Double(secondColumnX, firstRowY, r, r);
	Ellipse2D.Double egg3 = new Ellipse2D.Double(thirdColumnX, firstRowY, r, r);
	Ellipse2D.Double egg4 = new Ellipse2D.Double(firstColumnX, secondRowY, r, r);
	Ellipse2D.Double egg5 = new Ellipse2D.Double(secondColumnX, secondRowY, r, r);
	Ellipse2D.Double egg6 = new Ellipse2D.Double(thirdColumnX, secondRowY, r, r);

	wholeCarton.append(egg1, false);
	wholeCarton.append(egg2, false);
	wholeCarton.append(egg3, false);
	wholeCarton.append(egg4, false);
	wholeCarton.append(egg5, false);
	wholeCarton.append(egg6, false);

    }
}
