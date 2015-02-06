package com.aprograms.waterfall;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class WaterCannon {
	int x;
	int y;
	
	int frameSizeX;
	int frameSizeY;
	int cannonCount;
	
	int cannonIndex;
	
	int recWidth = 5;
	int recHeight = 15;
	
	int currentTime;
	
	public Vector<Boolean> dropletPattern;
	
	public Vector<Droplet> droplets= new Vector<Droplet>(50); 
	
	Color color = Color.BLACK;
	
	public WaterCannon(int frameSizeX, int frameSizeY, int cannonCount, int cannonIndex, Vector<Boolean> dropletPattern){
		this.frameSizeX = frameSizeX;
		this.frameSizeY = frameSizeY;
		this.cannonCount = cannonCount;
		this.cannonIndex = cannonIndex;
		
		this.dropletPattern = dropletPattern;
	}
	
	public void tick(int currentTime){
		this.currentTime = currentTime;
		updateDropletArray();
	}
	
	
	public void setDropletParameters(){
		for(int i = 0; i < droplets.size(); i++){
			
		}
	}
	
	
	public void updateDropletArray(){
		for(int i = 0; i < dropletPattern.size(); i++){
			if(dropletPattern.get(i).equals(true)){
				createDroplet(i);
				droplets.get(i).x = (frameSizeX/cannonCount)*cannonIndex + (frameSizeX/cannonCount/2)-1;
				droplets.get(i).y+=5;
			}
		}
	}
	
	public void createDroplet(int i){
		droplets.add(i, new Droplet());
	}
	
	
	public void paintDroplet(Graphics g){
//		setDropletParameters();
		for(int i = 0; i < droplets.size(); i++){
			droplets.get(i).paint(g);
		}
	}
	
	
	
	public void paintCannon(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, recWidth, recHeight);
	}
	
	
}
