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
	int amountOfDroplets = 200;
	
	int cannonCount = 1;
	int currentTime;
	
	
	
	
	WaterCannon[] waterCannon = new WaterCannon[cannonCount];
	
	Color backgroundColor = Color.yellow;
	
	
	
	public MainPanel(int frameSizeX, int frameSizeY, int delay){
		super();
		
		this.delay = delay;
		this.frameSizeX = frameSizeX;
		this.frameSizeY = frameSizeY;
		
		createCannons();
	}
	
	
	public void createCannons(){
		for(int i = 0; i < cannonCount; i++){
			Vector<Boolean> dropletPattern = new Vector<Boolean>();
			fillDropletArray(dropletPattern);
			waterCannon[i] = new WaterCannon(frameSizeX, frameSizeY, cannonCount, i, dropletPattern, backgroundColor);
			waterCannon[i].dropletPattern = dropletPattern;
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
	
	public void fillDropletArray(Vector<Boolean> dropletPattern){
		for(int i = 0; i < amountOfDroplets; i++){
			if(Math.random()*100 <= 50){
				dropletPattern.add(i, true);
			}else{
				dropletPattern.add(i, false);
			}
		}
	}
	
	
	
	
	public void paint(Graphics g){
		g.setColor(backgroundColor);
		g.fillRect(0, 0, frameSizeX, frameSizeY);

		paintCannon(g);
		paintDroplet(g);
	}
	
}
