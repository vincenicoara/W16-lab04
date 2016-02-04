package edu.ucsb.cs56.w16.drawings.changreytang.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles

import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;


/**
   A component that draws an animated picture by Jakob Staahl
   
   @author Chang Rey Tang 
   @version CS56, W16
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape TouchScreenPhone;
    private Shape IPhone;
    private Shape BottomLine;
    private Shape TopLine;
    private Shape LockHold;
    private Shape Lock;
    private int time = 0;
    private int lockTime = 0;
    private double xLockSpeed;
    private double phoneXPos;
    private double phoneYPos;
    private double phoneHeight;
    private double phoneWidth;


    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a pencil writing across the screen

	@param phoneXPos the starting x position of the phone 
	@param phoneYPos the starting y position of the phone 
	@param phoneHeight the speed at which the pencil will move
	across the screen
    */
    public AnimatedPictureComponent(double phoneXPos, double phoneYPos, double phoneHeight) {
	this.phoneXPos = phoneXPos;
	this.phoneYPos = phoneYPos;
	this.phoneHeight = phoneHeight;
	this.phoneWidth = 0.6*phoneHeight;
	this.xLockSpeed = (phoneYPos+0.77*phoneHeight - 2*0.15*phoneWidth)/200;

	LockHold = new Rectangle2D.Double(phoneXPos+0.1*phoneWidth, phoneYPos+0.77*phoneHeight, 0.77*phoneWidth, 0.1*phoneHeight);
	Lock = new Rectangle2D.Double(phoneXPos+0.1*phoneWidth, phoneYPos+0.77*phoneHeight, 0.20*phoneWidth, 0.1*phoneHeight);
	BottomLine = new Line2D.Double(phoneXPos+phoneHeight*0.025, phoneYPos+0.73*phoneHeight, phoneXPos+phoneHeight*0.025+0.9*phoneWidth, phoneYPos+0.73*phoneHeight);
	TopLine = new Line2D.Double(phoneXPos+phoneHeight*0.025, phoneYPos+0.22*phoneHeight, phoneXPos+phoneHeight*0.025+0.9*phoneWidth, phoneYPos+0.22*phoneHeight);
    	TouchScreenPhone = new TouchScreenPhone(this.phoneXPos, this.phoneYPos, this.phoneHeight);
	IPhone = new IPhone(this.phoneXPos, this.phoneYPos, this.phoneHeight);
    }

    /** The paintComponent method is overriden to display
	out animation. Each time this method is called, the
	position of the pencil is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
       
       g2.setColor(Color.BLACK);
       if(time < 200 && (time%12 == 0 || time%12 == 1 || time%12 == 2 || time%12 == 3)) {
       	   g2.draw(IPhone);
	   g2.drawString("BOOTING UP.",(int)(phoneXPos+0.25*phoneWidth),(int)(phoneYPos+0.70*phoneHeight));
       }
       else if (time < 200 && (time%12 == 4 || time%12 == 5 || time%12 == 6 || time%12 == 7)) {
           g2.draw(IPhone);
	   g2.drawString("BOOTING UP..",(int)(phoneXPos+0.25*phoneWidth),(int)(phoneYPos+0.70*phoneHeight));
       }
       else if (time < 200 && (time%12 == 8 || time%12 == 9 || time%12 == 10 || time%12 == 11)) {
           g2.draw(IPhone);
	   g2.drawString("BOOTING UP...",(int)(phoneXPos+0.25*phoneWidth),(int)(phoneYPos+0.70*phoneHeight));
       }
       else if (time > 200) {
       	   g2.draw(TouchScreenPhone);
	   g2.draw(BottomLine);
	   g2.draw(TopLine);
	   g2.draw(LockHold);
	   g2.drawString("11:11 PM", (int)(phoneXPos+0.33*phoneWidth),(int)(phoneYPos+0.15*phoneHeight));
	   g2.drawString("Slide to unlock",(int)( phoneXPos+0.18*phoneWidth), (int)(phoneYPos+0.84*phoneHeight));
	   g2.setColor(Color.BLUE);
	   if(time < 250) 
	       g2.draw(Lock);
	   else {
	       Lock = ShapeTransforms.translatedCopyOf(Lock,xLockSpeed,0);
	       g2.draw(Lock);
	       lockTime++;
	   }       
	   if(lockTime > 68) {
	       time = 0;
	       lockTime = 0;
	       Lock = new Rectangle2D.Double(phoneXPos+0.1*phoneWidth, phoneYPos+0.77*phoneHeight, 0.20*phoneWidth, 0.1*phoneHeight);
	   }
       }
       time++;
   }    
  
}
