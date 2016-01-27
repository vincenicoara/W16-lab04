package edu.ucsb.cs56.w16.drawings.changreytang.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 *
 * @author Chang Rey Tang
 * @version for CS56, W16, UCSB
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	IPhone ip1 = new IPhone(350,150,200);
	TouchScreenPhone p1 = new TouchScreenPhone(350,150,170);
	Shape p2 = ShapeTransforms.rotatedCopyOf(p1, Math.PI/8);
	p2 = ShapeTransforms.scaledCopyOfLL(p2,0.8,0.8);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	Shape p3 = ShapeTransforms.rotatedCopyOf(p1, Math.PI/4);
	p3 = ShapeTransforms.scaledCopyOfLL(p3,0.65,0.65);
	p3 = ShapeTransforms.translatedCopyOf(p3,-100,0);
	Shape p4 = ShapeTransforms.rotatedCopyOf(p1, Math.PI);
	p4 = ShapeTransforms.scaledCopyOfLL(p4,0.5,0.5);
	p4 = ShapeTransforms.translatedCopyOf(p4,-350,20);
	Shape p5 = ShapeTransforms.rotatedCopyOf(p1, Math.PI*1.25);
	p5 = ShapeTransforms.scaledCopyOfLL(p5,0.3,0.3); 
	p5 = ShapeTransforms.translatedCopyOf(p5, 150,-150);

	g2.setColor(Color.BLACK);
	g2.draw(ip1);
	g2.setColor(Color.BLUE);
	g2.draw(p2);
	g2.setColor(Color.GREEN);
	g2.draw(p3);
	g2.setColor(Color.YELLOW);
	g2.draw(p4);
	g2.setColor(Color.RED);
	g2.draw(p5);	

	g2.drawString("Touch Screen Phones G0ne Cr4zy by Chang Rey Tang", 20, 20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	
	Stroke stroke1 = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke stroke2 = new BasicStroke (1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig = g2.getStroke();

	TouchScreenPhone p1 = new TouchScreenPhone(150,150,200);
	TouchScreenPhone p2 = new TouchScreenPhone(10,200,145);
	TouchScreenPhone p3 = new TouchScreenPhone(400,20,230);
	IPhone ip = new IPhone(500,300,120);
	Shape ip1 = ShapeTransforms.rotatedCopyOf(ip,Math.PI/2);
	IPhone ip2 = new IPhone(200,200,178);

	g2.setColor(Color.RED);
	g2.draw(p1);
	g2.setStroke(stroke1);
	g2.setColor(Color.BLUE);
	g2.draw(p2);
	g2.setColor(Color.MAGENTA);
	g2.draw(p3);
	g2.setStroke(stroke2);
	g2.setColor(Color.YELLOW);
	g2.draw(ip1);
	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
	g2.draw(ip2);
	
	g2.drawString("Phone Screen Stroke by Chang Rey Tang", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	IPhone ip1 = new IPhone(250,150,300);
	IPhone ip2 = new IPhone(250,150,260);
	IPhone ip3 = new IPhone(250,150,224);
	IPhone ip4 = new IPhone(250,150,150);
	IPhone ip5 = new IPhone(250,150,60);

	g2.setColor(new Color(0x002FA7));
	g2.draw(ip1);
	g2.setColor(Color.MAGENTA);
	g2.draw(ip2);
	g2.setColor(Color.YELLOW);
	g2.draw(ip3);
	g2.setColor(new Color(0x00B21F));
	g2.draw(ip4);
	g2.setColor(Color.RED);
	g2.draw(ip5);	

	g2.drawString("IPhonception by Chang Rey Tang", 20,20);
	
    }       
}
