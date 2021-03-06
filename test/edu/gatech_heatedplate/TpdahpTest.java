package edu.gatech_heatedplate;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpdahp.TpdahpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;

public class TpdahpTest {

	@Test
	public void testdouble() {
		
		  TpdahpPlate heatedPlate = new TpdahpPlate(10000, 120.0,300.23,45.122,57.87);
	      TpdahpCommand tpdahp = new TpdahpCommand(heatedPlate);
	      
	 
	      do{
               
	        heatedPlate = (TpdahpPlate) tpdahp.execute((Plate)heatedPlate);
	      } while (heatedPlate.numIterations < 1000000);
	     // }  while (tpfahp.getPercision() < 0.01f);
	      
	      System.out.println("Number of Iterations=" + heatedPlate.numIterations);
	      heatedPlate.DisplpayPlateTemp();
		assertTrue("1 million Iterations",heatedPlate.numIterations >1000000 );
	}

}
