package edu.gatech_heatedplate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.heatedplate.Tpdohp.ObjectPlate;
import edu.gatech.heatedplate.Tpdohp.TpdohpCommand;
import edu.gatech.heatedplate.common.Invoker;
import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpdahp.TpdahpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;
import edu.gatech.heatedplate.tpfahp.TpfahpCommand;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;
import edu.gatech.heatedplate.twfahp.TwfahpCommand;
import edu.gatech.heatedplate.twfahp.TwfahpPlate;



public class InvokerTest {
	
	  Plate heatedPlate;
	  Invoker invoke	;
	  
	  int latSize ;
	  int itcnt ;

	
	@Before
	public void setUp() throws Exception {
	
	invoke = new Invoker();
	latSize = 100;
	itcnt  = 100000 ;
	}
	
	@Test
	public void testInvokerTpfahp() {
	
		//************************ Second Invocation using tpfahp **********************************/
		  heatedPlate = new TpfahpPlate(latSize, 120.0f,300.23f,45.122f,57.87f);
		  TpfahpCommand tpfahp = (TpfahpCommand) invoke.setCommand("Tpfahp", heatedPlate);
		 
	      do{
           
	        heatedPlate = tpfahp.execute((TpfahpPlate)heatedPlate);
	      } while (((TpfahpPlate)heatedPlate).numIterations < itcnt);
	     // }  while (tpfahp.getPercision() < 0.01f);
	      
	      System.out.println("Number of Iterations=" + ((TpfahpPlate)heatedPlate).numIterations);
	      ((TpfahpPlate)heatedPlate).DisplpayPlateTemp();
		  assertTrue("1 million Iterations",((TpfahpPlate)heatedPlate).numIterations >= itcnt );	
	    /*******************************************************************************************/
		  
		  
	}
	
	@Test
	public void testInvokerTwfahp() {
		
		  //************************ Third Invocation using twfahp **********************************/
		  heatedPlate = new TwfahpPlate(latSize, 120.0f,300.23f,45.122f,57.87f);
		  TwfahpCommand twfahp = (TwfahpCommand) invoke.setCommand("Twfahp", heatedPlate);
		     
	 
	      do{
             
	        heatedPlate = twfahp.execute((TwfahpPlate)heatedPlate);
	      } while (((TwfahpPlate)heatedPlate).numIterations < itcnt);
	     // }  while (tpfahp.getPercision() < 0.01f);
	      
	      System.out.println("Number of Iterations=" + ((TwfahpPlate)heatedPlate).numIterations);
	      ((TwfahpPlate)heatedPlate).DisplpayPlateTemp();
		  assertTrue("1 million Iterations",((TwfahpPlate)heatedPlate).numIterations >= itcnt );  
		 /*****************************************************************************************/ 
		  	
		
	}
	

	@Test
	public void testInvokerTpdahp() {
		

		  
		  //***********************first Invocation using tpdahp ***************************************/
		  heatedPlate = new TpdahpPlate(latSize, 120.0,300.23,45.122,57.87);
		  
		  TpdahpCommand tpdahp = (TpdahpCommand) invoke.setCommand("Tpdahp", heatedPlate);
		     
	 
	      do{
               
	        heatedPlate = tpdahp.execute((TpdahpPlate)heatedPlate);
	      } while (((TpdahpPlate)heatedPlate).numIterations < itcnt);
	     // }  while (tpfahp.getPercision() < 0.01f);
	      
	      System.out.println("Number of Iterations=" + ((TpdahpPlate)heatedPlate).numIterations);
	      ((TpdahpPlate)heatedPlate).DisplpayPlateTemp();
		assertTrue("1 million Iterations",((TpdahpPlate)heatedPlate).numIterations >= itcnt );
		/*********************************************************************************************/
	
		
		  
	    
          
	
		
		
	}
	
	
	@Test
	public void testInvokerTpdohp() {
		

		  
		  //***********************four Invocation using tpdohp ***************************************/
		  heatedPlate = new ObjectPlate(latSize,latSize, 120.0,300.23,45.122,57.87);
		 ((ObjectPlate)heatedPlate).intializePlate();
		  TpdohpCommand tpdohp = (TpdohpCommand) invoke.setCommand("Tpdohp", heatedPlate);
		     
	 
	      do{
               
	        heatedPlate = tpdohp.execute((ObjectPlate)heatedPlate);
	      } while (((ObjectPlate)heatedPlate).getIteration() < itcnt);
	     
	      
	      System.out.println("Number of Iterations=" + ((ObjectPlate)heatedPlate).getIteration());
	      ((ObjectPlate)heatedPlate).print();
		assertTrue("1 million Iterations",((ObjectPlate)heatedPlate).getIteration() >= itcnt );
		/*********************************************************************************************/
	
		
		  
	    
	}        
	
		
		

	
	
	

}
