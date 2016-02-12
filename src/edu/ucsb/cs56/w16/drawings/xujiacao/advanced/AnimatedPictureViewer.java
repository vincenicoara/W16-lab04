package edu.ucsb.cs56.w16.drawings.xujiacao.advanced;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {
    private DrawPanel panel = new DrawPanel();

    private Monitor m = new Monitor(20,20,100,100);

    Thread anim;
    private int x = 100;
    private int y = 100;

    private int dx = 5;
    private int dy = 8;

    private int size = 100;
    private boolean bigger = false;
    private int count = 50;

    public static void main(String[] args){
	new AnimatedPictureViewer().go();
    }

    public void go(){
	JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(720,720);
	frame.setVisible(true);

	frame.getContentPane().addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
		    anim = new Animation();
		    anim.start();
		}

		public void mouseExited(MouseEvent e){
		    anim.interrupt();
		    while(anim.isAlive()){}
		    anim = null;
		    panel.repaint();
		}

		public void mouseClicked(MouseEvent e){
		    dx+=2;
		    dy+=2;
		}
		
	    });
    }

    class DrawPanel extends JPanel{
	public void paintComponent(Graphics g){
	    Graphics2D g2 = (Graphics2D) g;

	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(),this.getHeight());

	    g2.setColor(Color.BLACK);
	    Monitor temp = new Monitor(x,y,size,size);
	    g2.draw(temp);
	    Monitor temp2 = new Monitor(620-x,620-y,size,size);
	    g2.draw(temp2);
	}
    }

    class Animation extends Thread{
	public void run(){
	    try{
		while(true){
		    if(count==50 ){
			bigger = false;
		    }
		    if(count ==0){
			bigger = true;
		    }
		    if(bigger){
			count++;
			size-=1;
		    }
		    else{
			count--;
			size+=1;
		    }
		    
		    if(x>=(760-Math.abs(dx)-size)) {dx = -Math.abs(dx);}
		    if(x<=Math.abs(dx))  {dx = Math.abs(dx);}

		    if(y>=(760-Math.abs(dy)-size)) {dy = -1*Math.abs(dy);}
		    if(y<=Math.abs(dy))  {dy = Math.abs(dy);}
		    
		    x+=dx;
		    y+=dy;
		    panel.repaint();
		    Thread.sleep(50);
		}
	    }catch(Exception ex){
		if(ex instanceof InterruptedException){
		}else{
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }
    
}
