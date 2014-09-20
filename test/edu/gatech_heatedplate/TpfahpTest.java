package edu.gatech_heatedplate;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.heatedplate.tpfahp.TpfahpCommand;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;

public class TpfahpTest {

	@Test
	public void testfloat() {
		
		  TpfahpPlate heatedPlate = new TpfahpPlate(1000, 120.0f,300.23f,45.122f,57.87f);
	      TpfahpCommand tpfahp = new TpfahpCommand(heatedPlate);
	      
	 
	      do{
               
	        heatedPlate = tpfahp.execute(heatedPlate);
	      } while (heatedPlate.numIterations < 1000000);
	     // }  while (tpfahp.getPercision() < 0.01f);
	      
	      System.out.println("Number of Iterations=" + heatedPlate.numIterations);
	      heatedPlate.DisplpayPlateTemp();
		assertTrue("1 million Iterations",heatedPlate.numIterations >1000000 );
	}

}
