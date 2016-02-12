package edu.ucsb.cs56.w16.drawings.j_song.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class for animation viewing
 *
 * @author Joseph Song
 * @version for CS56, W16
 */

public class AnimatedPictureViewer{

    private DrawPanel panel = new DrawPanel();

    Thread anim;

    private int x = 340;
    private int y = 150;
    private int dx = 5;
    private int dy = 5;
    private Color col = Color.RED;

    public static void main(String[] args){
        new AnimatedPictureViewer().start();
    }

    public void start(){
        JFrame frame = new JFrame();
        frame.setSize(640,480);
        frame.setTitle("The Clockwise Controller (With Original SNES Logo Colors)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(panel);
    
        System.out.println("Hold mouse down to continue animation");

        frame.getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                System.out.println("mouse held to start");
                anim = new Animation();
                anim.start();
            }
            public void mouseReleased(MouseEvent e){
                System.out.println("mouse released to stop");
                anim.interrupt();
                while (anim.isAlive()){}
                anim = null;
                panel.repaint();
            }

        }); 
    }

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.DARK_GRAY);
            g2.fillRect(0,0,this.getWidth(), this.getHeight());
        
            g2.setColor(col);
            SNESController test = new SNESController(x,y,280,140);
            g2.draw(test);
        
        }
    }

    class Animation extends Thread {
        public void run(){
            try {
                while (true) {
                    if (x == 340){
                                  dy = 5;
                                  col = Color.RED;
                                 }
                    if (y == 300){
                                  dx = -5;
                                  col = Color.YELLOW;
                                 }
                    if (x == 10){
                                  dy = -5;
                                  col = Color.GREEN;
                                 }
                    if (y == 10){
                                  dx = 5;
                                  col = Color.BLUE;
                                }
                                

                    if (((x == 340) && (y < 300)) || ((x == 10) && (y > 10)))
                        y += dy;
                    else if ((y == 300) || (y == 10))
                        x += dx;
                
                    panel.repaint();
                    Thread.sleep(50);
                }
            } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing
            } else {
              ex.printStackTrace();
              System.exit(1);
              }
            }
        }

    }
}
