package com.aprograms.waterfall;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	int frameSizeX;
	int frameSizeY;
	
	int cannonCount = 10;
	
	WaterCannon[] waterCannon = new WaterCannon[cannonCount];
	
	int currentTime;
	
	public MainPanel(int frameSizeX, int frameSizeY){
		super();
		
		
		
		this.frameSizeX = frameSizeX;
		this.frameSizeY = frameSizeY;
		
		setPermanentCannonParameters();
	}
	
	
	public void setPermanentCannonParameters(){
		for(int i = 0; i < cannonCount; i++){
			waterCannon[i] = new WaterCannon(frameSizeX, frameSizeY, cannonCount, i);
			waterCannon[i].x = (frameSizeX/cannonCount)*i + (frameSizeX/cannonCount/2);
			waterCannon[i].y = 0;
		}
	}
	
	
	public void paintCannon(Graphics g){
		for(int i = 0; i < cannonCount; i++){
			waterCannon[i].paintCannon(g);
		}
	}
	
	public void paintDroplet(Graphics g){
		for(int i = 0; i < cannonCount; i++){
			waterCannon[i].paintDroplets(g);
		}
	}
	
	public void tick(){
		currentTime++;
		for(int i = 0; i < cannonCount; i++){
			waterCannon[i].tick(currentTime);
		}
		
	}
	
	public void paint(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(0, 0, frameSizeX, frameSizeY);

		paintCannon(g);
		paintDroplet(g);
	}
	
}
