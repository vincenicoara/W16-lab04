package edu.ucsb.cs56.w16.drawings.jinfa.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Line2D;

/**
   A Hammer
      
   @author Jinfa Zhu 
   @version for CS56, W16, UCSB
   
*/
public class RockHammer extends Hammer implements Shape
{
    /**
     * Constructor for objects of class
     */
    public RockHammer(double x, double y, double length, double height)
    {
	// construct the basic harmer
	super(x,y,length,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make a pointed hammerhead
	Line2D.Double left =
	    new Line2D.Double(x+length,y-2*height/5,
			      x+length,y-2*height/5-height/3);
	Line2D.Double right =
	    new Line2D.Double(x+length+height/3,y-2*height/5,
			      x+length,y-2*height/5-height/3);
	// add the hammmerhead to the hammer
	
        GeneralPath hammer = this.get();
        hammer.append(left, false);
        hammer.append(right, false);
    }    
}
