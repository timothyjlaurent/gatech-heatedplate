package edu.gatech_heatedplate;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;


/**************************************************************************************************************  
 * @author Eric Griffin 
 * @version 1.0 
 * @since 20-Sep-14 
 *  <br>  
 *  <p> 
 *  <p><B>Course      :</B> Software Dev Process 
 *  <p><B>Section     :</B> CS-6310-O01  
 *  <p><B>Term        :</B> Fall 2014 
 *  <p><B>FileName    :</B> GUIRobot.java 
 *  <p><B>Description:</B>  
 *  <p> <center><B> Project1  
 *  <p>  Junit test cases for Gallhp. 
 *  ,p>  This is a Java Robot wrapper class. It automates keyboard presses and mouse clicks of the Demo GUI 
 *  <p>   It is used to provide automated perfomance testing consistent with the other 4 packages. couldn;t decide whetehr to place in  test or  src, but ultimately decided it responsibility wise more test not application. oriented.    
 *  <p>   
 * 
 * @see test/invokerTest 
 * @see src/gallhp/Demo 
 **************************************************************************************************************/ 
public class PlateGUIRobot { 
	private static Robot robot; 
	 
    public PlateGUIRobot() { 
       try 
         {     
    	    robot = new Robot(); 
          } 
      catch (AWTException e) 
          { 
    	    e.printStackTrace();  
    	  } 
    } 
     
    //PRESS KEY Function 
    public void PressKey(int key, int time) 
       { 
    	robot.keyPress(key); 
		robot.delay(time); 
		robot.keyRelease(key); 
    	 
       } 
     
    //wait time Function 
    public void  Pause ( int time) 
       { 
    	 
		robot.delay(time); 
		 
    	 
       } 
     
    public void clickComponement(final Component comp,  int delay) { 
        pointOnComp(comp, robot); 
        robot.delay(delay); 
        robot.mousePress(InputEvent.BUTTON1_MASK); 
        robot.delay(delay); 
        robot.mouseRelease(InputEvent.BUTTON1_MASK); 
    } 
     
    private void pointOnComp(final Component comp, final Robot robot) 
        { 
      
            Rectangle bounds = new Rectangle(comp.getLocationOnScreen(), comp.getSize()); 
    	    robot.mouseMove(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2); 
    	  
         }  






} 
