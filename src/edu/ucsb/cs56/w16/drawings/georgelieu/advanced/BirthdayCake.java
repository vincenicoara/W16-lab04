package edu.ucsb.cs56.w16.drawings.georgelieu.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D; 

/**
   A Birthday Cake, made of a cake with one candle and its wick
      
   @author George Lieu
   @version for CS56, W16, UCSB
   
*/

public class BirthdayCake extends Cake implements Shape
{
    /**
     * Constructor for a Birthday Cake
     */ 
    public BirthdayCake(double x, double y, double width, double height)
    {
	// basic cake
	super(x,y,width,height);
	GeneralPath gp = this.get();

	
	double candleHt = height * .1;
	double candleTop = y - candleHt;
	double candleWd = height * .025;
	double wickLength = candleHt *.7;
	double theCandle = (width*.5);
        
	Rectangle2D.Double candle =
	    new Rectangle2D.Double(x + theCandle - (.5*candleWd), candleTop, candleWd, candleHt);

	Line2D.Double wick =
	    new Line2D.Double(x + theCandle, candleTop,
			      x + theCandle, candleTop - wickLength); 
	
    GeneralPath wholeCake = this.get();
    wholeCake.append(candle, false);
    wholeCake.append(wick, false);
         
        
    }
}

     
