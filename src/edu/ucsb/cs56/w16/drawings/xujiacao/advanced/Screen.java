package edu.ucsb.cs56.w16.drawings.xujiacao.advanced;
import java.awt.geom.GeneralPath; 
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of Screen made of two rectangles

   @author Xujia Cao
   @version for cs56, W16, UCSB
*/

public class Screen extends GeneralPathWrapper implements Shape{

     /**
       Constructor
       
       @param x x coord of upper left corner of screen
       @param y y coord of upper left corner of screen
       @param width width of the screen
       @param height of screen
    */
    
    public Screen(double x, double y, double width, double height){
	//componment used to draw the inner rectangle
	double innerWidth = 0.8*width;
	double innerHeight = 0.8*height;
	double innerx = x+0.1*width;
	double innery = y+0.1*height;

	Rectangle2D.Double outerScreen =
	    new Rectangle2D.Double(x,y,width,height);
	Rectangle2D.Double innerScreen =
	    new Rectangle2D.Double(innerx,innery,innerWidth,innerHeight);

	GeneralPath wholeScreen = this.get();
	//add two rectangles
	wholeScreen.append(outerScreen,false);
	wholeScreen.append(innerScreen,false);
    }
}
