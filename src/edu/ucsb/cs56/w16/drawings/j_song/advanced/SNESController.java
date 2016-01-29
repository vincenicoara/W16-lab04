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
      
   @author Joseph Song
   @version for CS56, W16, UCSB
   
*/
public class SNESController extends Controller implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of controller
       @param y y coord of lower left corner of controller
       @param width width of the controller
       @param height of the controller
    */
    public SNESController(double x, double y, double width, double height)
    {
	
        //construct the controller shell
        super(x, y, width, height);

        //get the GeneralPath
        GeneralPath gp = this.get();

        double buttonRadius = .1 * height;
        //add two staggered buttons

        Circle button3 = new Circle(x+(width*.62), y+(height*.5), buttonRadius);
        Circle button4 = new Circle(x+(width*.75), y+(height*.30), buttonRadius);

        GeneralPath wholeController = this.get();
        wholeController.append(button3, false);
        wholeController.append(button4, false);
    }
}
