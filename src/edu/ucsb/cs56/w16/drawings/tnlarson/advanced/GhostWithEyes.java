package edu.ucsb.cs56.w16.drawings.tnlarson.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;

/**
   Adding eyes to the Ghost
  
   @author Troy Larson
   @version for CS56, W16, UCSB

*/

public class GhostWithEyes extends Ghost implements Shape {
    /**
       Constructor for objects of class GhostWithEyes
    */
    public GhostWithEyes(double x, double y, double width, double height)
    {
	super(x,y,width,height);

	// All we're gonna do is draw some circles towards the top of the Ghost.
	// We'll do this by drawing two ellipses

	double eyeWidth = 0.25 * width;
	double eyeHeight = 0.125 * height;
	
	Ellipse2D.Double leftEye = new Ellipse2D.Double(x + 0.125*width, y-height*0.75,
							    eyeWidth, eyeHeight);
	Ellipse2D.Double rightEye = new Ellipse2D.Double(x + 0.625*width, y-height*0.75,
							     eyeWidth, eyeHeight);
	
	GeneralPath theGhost = this.get();
	theGhost.append(leftEye,false);
	theGhost.append(rightEye,false);
    }
}
