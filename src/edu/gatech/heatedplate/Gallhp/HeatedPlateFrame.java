package edu.gatech.heatedplate.Gallhp;

import static edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import static edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.*;


public class HeatedPlateFrame extends JFrame  {
	
	/*
	 *  Initialize the frame with necessary size and characteristics
	 *
	*/
	public void initFrame() {
		
		int frameHeight = FRAME_HEIGHT;
		int frameWidth = FRAME_WIDTH;
		
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			if ((screenSize.width > 0) &&
				(screenSize.height > 0)) {
				
				frameWidth = (screenSize.width > FRAME_DESKTOP_BORDER_GAP)?
								(screenSize.width - FRAME_DESKTOP_BORDER_GAP):screenSize.width;
								
				frameHeight = (screenSize.height > FRAME_DESKTOP_BORDER_GAP)?
								(screenSize.height - FRAME_DESKTOP_BORDER_GAP):screenSize.width;
			}
		} catch (Exception exception) {
			// Do Nothing, default frame size is available
		}
		
		setTitle(APPLICATION_NAME);
		setSize(frameWidth, frameHeight);	    
	    setLocationRelativeTo(null);	    
	    setResizable(false);	    
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/** 
     * Height of the rectangle in pixels
     */
	private HeatedPlateControl heatedPlateController;
	
	
	/** 
     * Height of the rectangle in pixels
     */
	private HeatedPlatePanel heatedPlatePanel;
	
	/** 
     * Height of the rectangle in pixels
     */
	
	/** 
     * Height of the rectangle in pixels
     */
	private HeatedPlateManager heatedPlateManager;
}
