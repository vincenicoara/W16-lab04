package edu.ucsb.cs56.w16.drawings.tnlarson.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.geom.Ellipse2D; //ellipses for eyes
import java.awt.geom.GeneralPath; //general path for body

import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A component that draws a ghost by Troy Larson

   @author Troy Larson
   @version CS56, W16

*/

public class AnimatedPictureComponent extends JComponent
{
    private Shape ghost;
    private double height;
    private double width;
    private double radial_velocity;
    private double angular_velocity;
    private double totalDistance;
    private double init_radius;
    private double init_theta;
    private double center_x;
    private double center_y;

    private double x_pos;
    private double y_pos;
    
    private double radius; 
    private double theta;

    private int radial_velocity_direction = -1;

    public AnimatedPictureComponent(double init_radius, double init_theta, double center_x, double center_y, double radial_velocity, double angular_velocity, double width, double height) {
	this.init_radius = init_radius;
	this.init_theta = init_theta;
	this.radius = init_radius;
	this.theta = init_theta;
	this.center_x = center_x;
	this.center_y = center_y;
	this.x_pos = getXFromPolar(init_radius,init_theta);
	this.y_pos = getYFromPolar(init_radius,init_theta);
	this.radial_velocity = radial_velocity;
	this.angular_velocity = angular_velocity;
	this.width = width;
	this.height = height;

	ghost = new GhostWithEyes(this.x_pos, this.y_pos, this.width, this.height);
    }

    private double getXFromPolar(double radius, double theta) {
	theta = Math.toRadians(theta);
	return center_x + (radius * Math.cos(theta));
    }

    private double getYFromPolar(double radius, double theta) {
	theta = Math.toRadians(theta);
	return center_y + (radius * Math.sin(theta));
    }

    public void paintComponent(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;

	if((-1 * this.radius) >= this.init_radius) {
	    this.radial_velocity_direction = 1;
	} else if(this.radius >= this.init_radius) {
	    this.radial_velocity_direction = -1;
	}

	this.radius += this.radial_velocity_direction * this.radial_velocity;
	this.theta += this.angular_velocity;

	this.x_pos = getXFromPolar(this.radius, this.theta);
	this.y_pos = getYFromPolar(this.radius, this.theta);

	ghost = new GhostWithEyes(this.x_pos, this.y_pos, this.width, this.height);
	
	g2.setColor(Color.BLACK);
	g2.draw(ghost);
    }
}
