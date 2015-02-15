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
	
	int xDropletCoordinate;
	
	int currentTime;
	int currentDropletIndex = currentTime-1;
	
	int firstDropletIndex = 0;
	
	public Vector<Boolean> dropletPattern;
	public Vector<Droplet> droplets= new Vector<Droplet>(); 
	
	Color cannonColor = Color.BLACK;
	Color dropletColor = Color.BLUE;
	Color backgroundColor;
	
	public WaterCannon(int frameSizeX, int frameSizeY, int cannonCount, int cannonIndex, Vector<Boolean> dropletPattern, Color backgroundColor){
		this.frameSizeX = frameSizeX;
		this.frameSizeY = frameSizeY;
		this.cannonCount = cannonCount;
		this.cannonIndex = cannonIndex;
		this.dropletPattern = dropletPattern;
		this.backgroundColor = backgroundColor;
		xDropletCoordinate = (frameSizeX/cannonCount)*cannonIndex + (frameSizeX/cannonCount/2)-1;
	}
	
	public void tick(int currentTime){
		this.currentTime = currentTime;
		updateDropletArray();
	}
	
	
	public void updateDropletArray(){
		int currentDropletIndex = currentTime-1;
		
		for(int i = 0; i < currentTime; i++){
			if(firstDropletIndex == 0){
				if(dropletPattern.get(i).equals(true)){
					createDroplet(currentDropletIndex);
					droplets.get(i).color = dropletColor;
					droplets.get(i).x = xDropletCoordinate;
					droplets.get(i).y+=7;
					System.out.println("FIRST INDEX IS 0: " + firstDropletIndex);
				}else{
					createDroplet(currentDropletIndex);
					droplets.get(i).color = backgroundColor;
					droplets.get(i).x = xDropletCoordinate;
					droplets.get(i).y+=7;
				}
			}else if(droplets.get(0).y <= frameSizeY){
				System.out.println("DROPLET IS IN BOUNDS");
				if(dropletPattern.get(i).equals(true)){
					createDroplet(currentDropletIndex);
					droplets.get(i).color = dropletColor;
					droplets.get(i).x = xDropletCoordinate;
					droplets.get(i).y+=7;
				}else{
					createDroplet(currentDropletIndex);
					droplets.get(i).color = backgroundColor;
					droplets.get(i).x = xDropletCoordinate;
					droplets.get(i).y+=7;
				}
			}else{
				System.out.println("FIRST DROPLET IS OUT OF BOUNDS");
				if(droplets.get(i).y > frameSizeY && dropletPattern.get(i).equals(true)){
					droplets.get(i).y = 0;
					droplets.get(i).color = dropletColor;
					droplets.get(i).x = xDropletCoordinate;
					droplets.get(i).y+=7;
					
				}else if(droplets.get(i).y <= frameSizeY && dropletPattern.get(i).equals(true)){
					droplets.get(i).color = dropletColor;
					droplets.get(i).x = xDropletCoordinate;
					droplets.get(i).y+=7;
				}else if(droplets.get(i).y > frameSizeY && dropletPattern.get(i).equals(false)){
					droplets.get(i).y = 0;
					droplets.get(i).color = backgroundColor;
					droplets.get(i).x = xDropletCoordinate;
					droplets.get(i).y+=7;
				}else if(droplets.get(i).y <= frameSizeY && dropletPattern.get(i).equals(false)){
					droplets.get(i).color = backgroundColor;
					droplets.get(i).x = xDropletCoordinate;
					droplets.get(i).y+=7;
				}
			}
		}
		firstDropletIndex++;
	}
	
	public void createDroplet(int i){
		droplets.add(i, new Droplet());
	}
	
	
	public void paintDroplet(Graphics g){
		for(int i = 0; i < droplets.size(); i++){
			droplets.get(i).paint(g);
		}
	}
	
	public void paintCannon(Graphics g){
		g.setColor(cannonColor);
		g.fillRect(x, y, recWidth, recHeight);
	}
	
	
}
