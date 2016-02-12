package edu.ucsb.cs56.w16.drawings.mcaccamo.advanced;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Shape;
import java.awt.geom.*;

/**
 * A main class to view an animation
 *
 * @author Michael Caccamo
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
    private DrawPanel panel = new DrawPanel();
    private BoatWithMast b1 = new BoatWithMast(100,100,100);

    Thread anim;

    private int x =100;
    private int y =100;
    private int dx = 5;
    private int dy = 2;
    private int dw = 1;
    private int width = 100;
    public static void main( String [] args){
	new AnimatedPictureViewer().go();
    }

    public void go(){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.getContentPane().add(panel);
	frame.setSize(640,480);
	frame.setVisible(true);
	
	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e){
		    System.out.println("mouse clicked");
		    anim = new Animation();
		    anim.start();
		}
		
		public void mouseReleased(MouseEvent e){        
		    System.out.println("Mouse unclicked");
		    // Kill the animation thread
		    anim.interrupt();
		    while (anim.isAlive()){}
		    anim = null;         
		    panel.repaint();        
		}
	    });
	
    }

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    g2.setColor(Color.BLUE);
	    BoatWithMast test  = new BoatWithMast(x,y, width);
	    //g2.rotate(Math.toRadians(45));
	    g2.draw(test);
	    g2.drawString("CLICK ME TO SAIL",20,20);
	    CubicCurve2D waves = new CubicCurve2D.Double();
	    waves.setCurve(0, 120, 45, 70, 90, 140, 140, 100);
	    g2.draw(waves);
	    //2nd column of waves
	    CubicCurve2D secwaves = new CubicCurve2D.Double();
	    secwaves.setCurve(140, 160, 185, 110, 230, 180, 275, 140);
	    //TODO LAYER THE WAVES!!!!!! y+40 then start with y+80 so on maybe doa  y-40 too 
	    g2.draw(secwaves);
	    //first column of waves
	    CubicCurve2D thirdwaves = new CubicCurve2D.Double();
	    thirdwaves.setCurve(30, 240, 75,190, 120, 260, 165, 220);
	    g2.draw(thirdwaves);
	    CubicCurve2D fourthwaves = new CubicCurve2D.Double();
	    //1st column of waves - 3rd row 
	    fourthwaves.setCurve(10, 360, 55, 310, 100, 380, 145, 340);
	    g2.draw(fourthwaves);
	    //2nd column of waves - 2nd row 
	    CubicCurve2D fifthwaves = new CubicCurve2D.Double();
	    fifthwaves.setCurve(140, 280, 185, 230, 230, 300, 275, 260);
	    g2.draw(fifthwaves);

	    //third column of waves - first row
	    CubicCurve2D thirdCol1 = new CubicCurve2D.Double();
	    thirdCol1.setCurve(280, 120, 325, 70, 370, 140, 415, 100);
	    g2.draw(thirdCol1);

	    //third colum 2nd row
	    CubicCurve2D thirdCol2 = new CubicCurve2D.Double();
	    thirdCol2.setCurve(280, 240 , 325, 190 , 370,260 , 415, 220);
	    g2.draw(thirdCol2);

	    //3rd col 3rd row
	    CubicCurve2D thirdCol3 = new CubicCurve2D.Double();
	    thirdCol3.setCurve( 290, 360, 335, 310, 380, 380, 425, 340);
	    g2.draw(thirdCol3);
	    
	    //4th row 1
	    CubicCurve2D fourthCol = new CubicCurve2D.Double();
	    fourthCol.setCurve( 420, 160, 465, 110, 505, 180, 550, 140);
	    g2.draw(fourthCol);

	    //4th row 2nd
	    CubicCurve2D fourthCol2 = new CubicCurve2D.Double();
	    fourthCol2.setCurve(420, 280, 465,230 , 505, 300, 550,260 );
	    g2.draw(fourthCol2);
	}
    }

    class Animation extends Thread {
	public void run() {
	     try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { dx = -5; }
            if (x <= 50) { dx = 5; }
            
            x += dx;
	    int h=0;

	    if(y>=320){ 
		dy = -2;
		dw = -1;
	    }
	   
	    if( y<=100) {
		dw = 1;
		dy = 2;
	    }

	    
		y += dy;
		width += dw;
	    
	    
	 	        	              
	    
            panel.repaint();
            Thread.sleep(60);
          
	  }
	     }



	     catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
