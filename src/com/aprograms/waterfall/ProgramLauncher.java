package com.aprograms.waterfall;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ProgramLauncher {

	public static void main(String[] args) {
		final MainPanel mp;
		
		int frameSizeX = 1000;
		int frameSizeY = 1000;
		
		int delay = 50;
		
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(frameSizeX, frameSizeY);
		
		mp = new MainPanel(frameSizeX, frameSizeY);
		
		application.add(mp);
		application.setVisible(true);
		
		
		ActionListener timerTask = new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			mp.tick();
    			mp.repaint();
    			
       		}
    	};
		
		Timer timer = new Timer(delay, timerTask);
		timer.start();
		
	}
}
