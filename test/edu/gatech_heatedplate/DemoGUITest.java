package edu.gatech_heatedplate;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.gatech.heatedplate.Gallhp.Demo;

public class DemoGUITest {
	
	Demo                   UI          = new Demo();
	PlateGUIRobot          UITestBot   = new PlateGUIRobot();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDemoGui() {
		fail("Not yet implemented");
		
		   /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo().setVisible(true);
            }
        });
        
        UITestBot.PressKey(KeyEvent.VK_T, 1000);
        UITestBot.Pause(1000);
        UITestBot.PressKey(KeyEvent.VK_T, 1000);
        UITestBot.Pause(1000);
        UITestBot.PressKey(KeyEvent.VK_T, 1000);
        UITestBot.Pause(1000);
        
        UITestBot.clickComponement(Demo. jButton1, 1000);
        UITestBot.clickComponement(Demo.jComboBox1, 1000);
        UITestBot.PressKey(KeyEvent.VK_T, 1000);
        UITestBot.Pause(1000);
        UITestBot.PressKey(KeyEvent.VK_T, 1000);
        UITestBot.Pause(1000);
        UITestBot.clickComponement(Demo.jButton1, 1000);
        UITestBot.clickComponement(Demo.jTextArea1, 1000);
	    
       
        
        UITestBot.clickComponement(Demo.jButton1, 1000);
        UITestBot.Pause(10000);
	}

}
