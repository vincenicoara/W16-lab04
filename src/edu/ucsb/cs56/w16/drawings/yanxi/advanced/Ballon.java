package edu.ucsb.cs56.w16.drawings.yanxi.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.awt.geom.Line2D;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
import edu.ucsb.cs56.w16.drawings.yanxi.simple.Circle;
/**
   A basic ballon
   
   @author Yanxi Chen
   @version for cs56, W16, UCSB

*/

public class Ballon extends GeneralPathWrapper implements Shape{
    
    /**
       Constructor
       @param x x coordinate of center of ballon
       @param y y coordinate of center of ballon
       @param r radius of the ballon
       @param l lenght of string of the ballon
    */

    public Ballon(double x, double y, double r, double l){
	Circle ballon = new Circle(x, y, r);
	Line2D.Double g = new Line2D.Double(x, y+r, x, y+r+l);

	GeneralPath wholeScreen = this.get();
	wholeScreen.append(ballon, false);
	wholeScreen.append(g, false);
    }
}
    
