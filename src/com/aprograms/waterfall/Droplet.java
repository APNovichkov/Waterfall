package com.aprograms.waterfall;

import java.awt.Color;
import java.awt.Graphics;

public class Droplet {

	int x;
	int y;
	
	int dDiameter = 6;
	
	Color color;
	
	
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, dDiameter, dDiameter);
	}
}
