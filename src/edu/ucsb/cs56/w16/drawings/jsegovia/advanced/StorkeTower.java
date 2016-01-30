package edu.ucsb.cs56.w16.drawings.jsegovia.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   Storke Tower
      
   @author Jsegovia 
   @version for CS56, W16, UCSB
   
*/
public class StorkeTower extends Tower implements Shape
{
    /**
     * Constructor for objects of class StorkeTower
     */
    public StorkeTower(double x, double y, double width, double height)
    {
	// construct the basic tower shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double w = width/40;
	double winTop = y*1.03;
	double winHt =  0.25 * height;
	
	Rectangle2D.Double win1 =
	    new Rectangle2D.Double(x + w, winTop, 2.0 * w, winHt);
	Rectangle2D.Double win2 =
	    new Rectangle2D.Double(x + 4.0*w, winTop, 2.0 * w, winHt);
	Rectangle2D.Double win3 =
	    new Rectangle2D.Double(x + 7.0*w, winTop, 2.0 * w, winHt);
	
	// add the windows to Storke Tower
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath storkeTower = this.get();
        storkeTower.append(win1, false);
        storkeTower.append(win2, false);
        storkeTower.append(win3, false); 
    }    
}
