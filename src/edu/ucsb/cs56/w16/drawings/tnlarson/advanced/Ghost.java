package edu.ucsb.cs56.w16.drawings.tnlarson.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a ghost that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc. Uses GeneralPath to create straight lines,
   curves, and zig-zags.

   @author Troy Larson
   @version for CS56, W16, UCSB

*/

public class Ghost extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of ghost
       @param y y coord of lower left corner of ghost
       @param width width of ghost
       @param height height of ghost
    */
    public Ghost(double x, double y, double width, double height)
    {
	// A ghost is drawn about as basic as you can imagine one.
	// Semicircular top, straight middle, zig-zag bottom.
	// Specifically,
	// The top will be 25% of the height.
	// the middle will be 50% of the height.
	// The bottom will be 25% of the height.

	double topHeight = 0.25 * height;
	double bodyHeight = 0.5 * height;
	double bottomHeight = 0.25 * height;

	// Let's code the bottom, and build up.
	// This is because the bottom is most dependent on the position.
	GeneralPath bottomPath = new GeneralPath();
	bottomPath.moveTo(x,y - height*0.25);
	bottomPath.lineTo(x,y);

	//we'll have 4 "zags"
	bottomPath.lineTo(x+width*0.125,y - height*0.125);
	bottomPath.lineTo(x+width*0.25,y);
	bottomPath.lineTo(x+width*0.375,y - height*0.125);
	bottomPath.lineTo(x+width*0.5,y);
       	bottomPath.lineTo(x+width*0.625,y - height*0.125);
	bottomPath.lineTo(x+width*0.75,y);
	bottomPath.lineTo(x+width*0.875,y - height*0.125);
	bottomPath.lineTo(x+width,y);
	bottomPath.lineTo(x+width,y-height*0.25);

	// Now, let's code the middle.
	GeneralPath middlePath = new GeneralPath();
	middlePath.moveTo(x,y-height*0.25);
	middlePath.lineTo(x,y-height*0.75);
	middlePath.moveTo(x+width,y-height*0.75);
	middlePath.lineTo(x+width,y-height*0.25);

	// Now for the top.
	GeneralPath topPath = new GeneralPath();

	// This one's the most complicated because it utilizes a curve.

	topPath.moveTo(x, y-height*0.75);
	
	topPath.curveTo(x,y-height*0.75,
			x,y-height
			,x+width*0.5,y-height);
	
	topPath.curveTo(x+width*0.5,y-height,
			x+width,y-height,
			x+width,y-height*0.75);

	// We need to combine all three paths into the complete ghost.
	GeneralPath ghost = new GeneralPath();
	ghost.append(bottomPath,false);
	ghost.append(middlePath,false);
	ghost.append(topPath,false);

	this.set(ghost);
    }
}
