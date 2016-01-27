package edu.ucsb.cs56.w16.drawings.tnlarson.advanced;

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
 * @author Phill Conrad 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few ghosts 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	//I'll draw 3 ghosts, one of which with eyes.
	
	Ghost ghost0 = new Ghost(500,100,50,75);
	g2.setColor(new Color(0xFF4500));
	g2.draw(ghost0);

        Ghost ghost1 = new Ghost(300,250,100,200);
	g2.setColor(new Color(0x8FF20C));
	g2.draw(ghost1);

	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	
        GhostWithEyes ghost2 = new GhostWithEyes(25,400,200,300);
	
	g2.setStroke(thick);
	g2.setColor(new Color(0xDABEEF)); 
	g2.draw(ghost2); 

	g2.setColor(Color.BLACK);
	g2.drawString("Boo! A few ghosts by Troy Larson", 20,20);
    }
    
    
    /** Draw a picture with some ghosts
     */
    public static void drawPicture2(Graphics2D g2) {
	
	Ghost large = new Ghost(325,350,225,150);
	GhostWithEyes smallCC = new GhostWithEyes(20,75,40,30);
	Ghost tallSkinny = new Ghost(20,425,75,300);
	GhostWithEyes shortFat = new GhostWithEyes(150,150,200,100);
	
	g2.setColor(new Color(0x6F0CF2));
	g2.draw(large);
	
	g2.setColor(new Color(0x007D25));
	g2.draw(smallCC);
	
	g2.setColor(new Color(0x7D0058));
	g2.draw(tallSkinny);
	
	g2.setColor(new Color(0xFF00BF));
	g2.draw(shortFat);

	g2.setColor(Color.BLACK); 
	g2.drawString("Boo! Some ghosts by Troy Larson", 20,20);
    }
    
    /** Draw a different picture with a couple ghosts
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Boo! A couple ghosts by Troy Larson", 20,20);
	
	
	// Draw a ghost.
	
	Ghost theGhost = new Ghost(250,250,100,200);
	
	g2.setColor(Color.RED);
	g2.draw(theGhost);

	GhostWithEyes theGhostWithEyes = new GhostWithEyes(375,375,100,250);
	g2.setColor(Color.ORANGE);
	g2.draw(theGhostWithEyes);
	
    }
}
