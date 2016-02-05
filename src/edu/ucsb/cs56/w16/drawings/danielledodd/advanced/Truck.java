package edu.ucsb.cs56.w16.drawings.danielledodd.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A Truck
      
   @author Danielle Dodd 
   @version for CS56, W16, UCSB
   
*/
public class Truck extends Car implements Shape
{
    /**
     * Constructor for objects of class Truck
     */
    public Truck(double x, double y, double width, double height)
    {
	// construct the basic car shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// the truck bed will be half the height of the carHeight
	// the width of the truck bed will be .75 the width of the carWidth
	//therefore, the x coordinate is the same as x+width
	//the y coordinate will be the same as the car body
	
	double bedWidth = 0.6 * width;
	double bedHeight = 0.5 * height;
	double bedXCoordinate = x + width;
	double bedYCoordinate = y+bedHeight;

	Rectangle2D.Double bed =
	    new Rectangle2D.Double(bedXCoordinate, bedYCoordinate,
				   bedWidth, bedHeight);
		
        GeneralPath wholeTruck = this.get();
        wholeTruck.append(bed, false);
      
    }    
}
