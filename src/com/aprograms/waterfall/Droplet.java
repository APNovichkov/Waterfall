package com.aprograms.waterfall;

import java.awt.Graphics;

public class Droplet {

	int x;
	int y;
	
	int dDiameter = 10;
	
	
	
	public void paint(Graphics g){
		g.fillOval(x, y, dDiameter, dDiameter);
	}
}
