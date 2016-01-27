package edu.ucsb.cs56.w16.drawings.xujiacao.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D; 

/**
   A monitor which is a scrren with a stand

   @author Xujia Cao
   @version for CS56, W16, UCSB
*/

public class Monitor extends Screen implements Shape{

    /** 
	Constructor

	@param x x coord of upper left corner of Monitor
	@param y y coord of upper left corner of Monitor
	@param width width of the Monitor
	@param height height of the Monitor (includes scrren and stand)
    */
    
    public Monitor(double x, double y, double width, double height){
		
	super(x,y,width,height*0.7);

	
	GeneralPath gp = this.get();

       	double standHeight = 0.3*height;
	//lower part of the stand
	double bottemStart = x+0.2*width;
	double bottemEnd   = x+0.8*width;
	//points that used to draw two verticle lines represents stand
	double standXStart = x+0.4*width;
	double standXEnd   = x+0.6*width;
	double standYStart = y+0.7*height;
	double standYEnd   = y+height;

	Line2D.Double standLeft =
	    new Line2D.Double(standXStart, standYStart,
			      standXStart, standYEnd);
	Line2D.Double standRight =
	    new Line2D.Double(standXEnd, standYStart,
			      standXEnd, standYEnd);
	Line2D.Double standBottom =
	    new Line2D.Double(bottemStart, standYEnd,
			      bottemEnd,   standYEnd);

	GeneralPath wholeMonitor = this.get();
	//add all component into path
	wholeMonitor.append(standLeft,false);
	wholeMonitor.append(standRight,false);
	wholeMonitor.append(standBottom,false);
	
    }
}
