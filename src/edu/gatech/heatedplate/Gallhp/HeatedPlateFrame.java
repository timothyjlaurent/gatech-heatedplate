package edu.gatech.heatedplate.Gallhp;

import static edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import static edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.*;


public class HeatedPlateFrame extends JFrame  {
	
	/*
	 *  Initialize the frame with necessary size and characteristics
	 *
	*/
	public boolean initFrame() {		
		
		setFrameProperty();		
		
		if (!initializeModule()) {
			return false;
		}
		
		if (!processModule()) {
			return false;
		}
		
		return true;
	}
		
	public int getHeight() {
		return frameHeight;
	}
	
	public int getWidth() {
		return frameWidth;
	}
	
	public HeatedPlateController getHeatedPlateController() {
		return heatedPlateController;
	}
	
	private void setFrameProperty() {
		
		frameHeight = FRAME_HEIGHT;
		frameWidth = FRAME_WIDTH;
		
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

	private boolean initializeModule() {
		
		try {
			heatedPlateResultPanel = new HeatedPlateResultPanel();
			heatedPlateControlPanel = new HeatedPlateControlPanel();
			heatedPlateController = new HeatedPlateController();
			
			if ((heatedPlateResultPanel == null) ||
				(heatedPlateControlPanel == null) ||
				(heatedPlateController == null)) {
				return false;
			}
				
		} catch(Exception exception) {
			return false;
		}
		
		return true;
	}
	
	private boolean processModule() {
		
		try {
			
			
			if (heatedPlateControlPanel != null) {
				heatedPlateControlPanel.initPanel(this);
				this.add(heatedPlateControlPanel, BorderLayout.WEST);
			}
			
			if (heatedPlateResultPanel != null) {
				heatedPlateResultPanel.initPanel(this);
				this.add(heatedPlateResultPanel, BorderLayout.EAST);
			}
			
			
			if (heatedPlateController != null) {
				//heatedPlateManager.initManager(this);
			}
			heatedPlateControlPanel = new HeatedPlateControlPanel();
			heatedPlateController = new HeatedPlateController();
			
		} catch(Exception exception) {
			return false;
		}
		
		return true;
	}
	
	/** 
     * Plate Control Object which manages controls.
     */
	private HeatedPlateControlPanel heatedPlateControlPanel;
		
	/** 
     * Panel Object which displays results
     */
	private HeatedPlateResultPanel heatedPlateResultPanel;
		
	/** 
     * Manages Heated Plate Object and Command
     */
	private HeatedPlateController heatedPlateController;
	
	/** 
     * Height of the frame
     */
	private int frameHeight;
	
	/** 
     * Width of the frame
     */
	private int frameWidth;
}
