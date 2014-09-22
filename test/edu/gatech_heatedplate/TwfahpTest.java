package edu.gatech_heatedplate;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.heatedplate.twfahp.TwfahpCommand;
import edu.gatech.heatedplate.twfahp.TwfahpPlate;

public class TwfahpTest {

	@Test
	public void testFloat() {
		
		  TwfahpPlate heatedPlate = new TwfahpPlate(1000, 1200.7687760f, 300.2787683f, 4566.122f, 58.877876767f);
	      TwfahpCommand twfahp = new TwfahpCommand(heatedPlate);
	      
	 
	      do{
               
	        heatedPlate = (TwfahpPlate) twfahp.execute(heatedPlate);
	      } while (heatedPlate.numIterations < 1000000);
	     // }  while (tpfahp.getPercision() < 0.01f);
	      
	      System.out.println("Number of Iterations=" + heatedPlate.numIterations);
	      heatedPlate.DisplpayPlateTemp();
		assertTrue("1 million Iterations",heatedPlate.numIterations >1000000);
	}

}