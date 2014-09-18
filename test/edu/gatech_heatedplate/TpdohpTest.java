package edu.gatech_heatedplate;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.heatedplate.Tpdohp.TpdohpCommand;
import edu.gatech.heatedplate.Tpdohp.ObjectPlate;

public class TpdohpTest {

		@Test
		public void testobject10() {
			
			  ObjectPlate heatedPlate = new ObjectPlate(10, 10,  50.4, 60.0 , 70.44 , 33.3);
		      TpdohpCommand tpdohp = new TpdohpCommand(heatedPlate);
		      heatedPlate.print();
		 
		      do{
	               
		        heatedPlate = tpdohp.execute(heatedPlate);
//		        if (heatedPlate.getIteration() % 1000 == 0 ){
//		        	heatedPlate.print();
//		        }
		      } while (tpdohp.getIteration() < 1000000 );//&& tpdohp.getMaxDelta() > 0.01);
		     // }  while (tpfahp.getPercision() < 0.01f);
		      
		      System.out.println("Number of Iterations=" + tpdohp.getIteration());
		      heatedPlate.print();
			assertTrue("1 million Iterations",tpdohp.getIteration() >999999 );
		}

		
		@Test
		public void testobject50() {
			
			  ObjectPlate heatedPlate = new ObjectPlate(50, 50,  50.4, 60.0 , 70.44 , 33.3);
		      TpdohpCommand tpdohp = new TpdohpCommand(heatedPlate);
		      heatedPlate.print();
		 
		      do{
	               
		        heatedPlate = tpdohp.execute(heatedPlate);
//		        if (heatedPlate.getIteration() % 1000 == 0 ){
//		        	heatedPlate.print();
//		        }
		      } while (tpdohp.getIteration() < 1000000 );//&& tpdohp.getMaxDelta() > 0.01);
		     // }  while (tpfahp.getPercision() < 0.01f);
		      
		      System.out.println("Number of Iterations=" + tpdohp.getIteration());
		      heatedPlate.print();
			assertTrue("1 million Iterations",tpdohp.getIteration() >999999 );
		}
	
		@Test
		public void testobject100() {
			
			  ObjectPlate heatedPlate = new ObjectPlate(100, 100,  50.4, 60.0 , 70.44 , 33.3);
		      TpdohpCommand tpdohp = new TpdohpCommand(heatedPlate);
		      heatedPlate.print();
		 
		      do{
	               
		        heatedPlate = tpdohp.execute(heatedPlate);
//		        if (heatedPlate.getIteration() % 1000 == 0 ){
//		        	heatedPlate.print();
//		        }
		      } while (tpdohp.getIteration() < 1000000 );//&& tpdohp.getMaxDelta() > 0.01);
		     // }  while (tpfahp.getPercision() < 0.01f);
		      
		      System.out.println("Number of Iterations=" + tpdohp.getIteration());
		      heatedPlate.print();
			assertTrue("1 million Iterations",tpdohp.getIteration() >999999 );
		}

}
