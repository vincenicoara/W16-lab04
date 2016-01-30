package edu.ucsb.cs56.w16.drawings.yanxi.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.yanxi.simple.Circle;

/**
   A Ballon with face

   @author Yanxi Chen
   @version for CS56, W16, UCSB
*/

public class BallonWithFace extends Ballon implements Shape{
    
    /**
       Constructor 

       @param x x coord of the center of the ballon
       @param y y coord of the center of the ballon
       @param r radius of the ballon
       @param l length of the string of the ballon
    */

    public BallonWithFace(double x, double y, double r, double l){

	super(x, y, r, l);
	
	GeneralPath gp = this.get();

	Circle eye1 = new Circle(x-r/4, y, r/8);
	Circle eye2 = new Circle(x+r/4, y, r/8);

	GeneralPath whole = this.get();
	whole.append(eye1, false);
	whole.append(eye2, false);
    }
}
