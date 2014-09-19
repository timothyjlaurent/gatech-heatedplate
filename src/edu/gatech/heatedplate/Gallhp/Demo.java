package edu.gatech.heatedplate.Gallhp;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.Tpdohp.TpdohpCommand;
import edu.gatech.heatedplate.Tpdohp.ObjectPlate;

import static edu.gatech.heatedplate.Gallhp.ViewConstant.*;


/**  
 * <h1> Project 1: Heated Plate GUI Implementation</h1> 
 * <p> 
 * <p><B>Course      :</B> Software Architecture And Design 
 * <p><B>Section     :</B> CS-6310-O01  
 * <p><B>Term        :</B> Fall 2014 
 * <p><B>Team        :</B> Team 38
 * <p><B>FileName    :</B> Demo.java 
 * <p><B>Description:</B>  
 * <p> <center><B>Class to represent presentation layer of Heated plate application.</B></center>  	
 * Allows a user to select any of the four simulation , set variants and display the results of the execution.
 * 
 * @author Karthik Ramkumar 
 * @version 1.0 
 * @since 2014-09-19
 * @see TpdohpCommand 
 * @see ObjectPlate
 * @see Plate 
*/ 
public class Demo extends JFrame  {

	public Demo() {
	
    }
    
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
			// Do Nothing, We have the Frame default size
		}
		
		setTitle(APPLICATION_NAME);
		setSize(frameWidth, frameHeight);	    
	    setLocationRelativeTo(null);	    
	    setResizable(false);	    
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    	    @Override
    	    public void run() {
    	    	Demo heatedPlateFrame = new Demo();
    	    	heatedPlateFrame.initFrame();
    	    	heatedPlateFrame.setVisible(true);
    	    }
    	});
    	
    	      
    }
    
    
}
