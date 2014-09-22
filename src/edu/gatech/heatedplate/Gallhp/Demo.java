package edu.gatech.heatedplate.Gallhp;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import edu.gatech.heatedplate.Gallhp.HeatedPlateFrame;

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
public class Demo {

	public Demo() {
	
    }    
	
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    	    @Override
    	    public void run() {
    	    	HeatedPlateFrame heatedPlateFrame = new HeatedPlateFrame();
    	    	heatedPlateFrame.initFrame();
    	    	heatedPlateFrame.setVisible(true);
    	    }
    	});   
    }
}
