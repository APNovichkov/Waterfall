package com.aprograms.waterfall;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	int frameSizeX;
	int frameSizeY;
	
	int delay;
	
	int cannonCount = 100;
	
	WaterCannon[] waterCannon = new WaterCannon[cannonCount];
	
	public Vector<Boolean> dropletPattern = new Vector<Boolean>(100);
	
	int currentTime;
	
	public MainPanel(int frameSizeX, int frameSizeY, int delay){
		super();
		
		this.delay = delay;
		
		this.frameSizeX = frameSizeX;
		this.frameSizeY = frameSizeY;
		
		createCannons();
	}
	
	
	public void createCannons(){
		for(int i = 0; i < cannonCount; i++){
			fillDropletArray();
			
			waterCannon[i] = new WaterCannon(frameSizeX, frameSizeY, cannonCount, i, dropletPattern);
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
			waterCannon[i].paintDroplet(g);
		}
	}
	
	public void tick(){
		currentTime++;
		for(int i = 0; i < cannonCount; i++){
			waterCannon[i].tick(currentTime);
		}
		
	}
	
	public void fillDropletArray(){
		for(int i = 0; i < 100; i++){
			if(Math.random()*100 <= 50){
				dropletPattern.add(i, true);
			}else{
				dropletPattern.add(i, false);
			}
		}
	}
	
	
	
	
	public void paint(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(0, 0, frameSizeX, frameSizeY);

		paintCannon(g);
		paintDroplet(g);
	}
	
}
