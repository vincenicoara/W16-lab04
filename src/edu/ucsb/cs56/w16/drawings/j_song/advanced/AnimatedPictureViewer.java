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

    private int x = 130;
    private int y = 140;
    private int dx = 5;
    private int dy = 5;

    private static void main(String[] args){
        new AnimatedPictureViewer().start();
    }

    public void start(){
        JFrame frame = new JFrame();
        frame.setSize(640,480);
        frame.setTitle("The Clockwise Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

            g2.setColor(Color.white);
            g2.fillRect(0,0,this.getWidth(), this.getHeight());
        
            g2.setColor(Color.GREEN);
            SNESController snes = new SNESController(x,y,400,200);
            g2.draw(snes);
        
        }
    }

    class Animation extends Thread {
        public void run(){
            try {
                while (true) {
                    if (x >= 370){dy = 5;}
                    else if (y >= 250){dx = -5;}
                    else if (x <= 100){dy = -5;}
                    else if (y <= 100){dx = 5;}

                    if ((x>= 370) || (x<= 100))
                        y += dy;
                    else if ((y >= 250) || (y <= 100))
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
