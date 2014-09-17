package edu.gatech_heatedplate;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.heatedplate.twfahp.TwfahpCommand;
import edu.gatech.heatedplate.twfahp.TwfahpPlate;

public class TwfahpTest {

	@Test
	public void testFloat() {
		
		  TwfahpPlate heatedPlate = new TwfahpPlate(50, 120.0f,300.23f,45.122f,57.87f);
	      TwfahpCommand twfahp = new TwfahpCommand(heatedPlate);
	      
	 
	      do{
               
	        heatedPlate = twfahp.execute(heatedPlate);
	      } while (heatedPlate.numIterations < 100000);
	     // }  while (tpfahp.getPercision() < 0.01f);
	      
	      System.out.println("Number of Iterations=" + heatedPlate.numIterations);
	      heatedPlate.DisplpayPlateTemp();
		assertTrue("1 million Iterations",heatedPlate.numIterations >100000 );
	}

}