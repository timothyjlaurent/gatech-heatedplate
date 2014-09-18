package edu.gatech.heatedplate.twfahp;

import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.twfahp.TwfahpCommand;
import edu.gatech.heatedplate.twfahp.TwfahpPlate;

/**  
	 * @author Eric H. Griffin 
 	 * @version 1.0 
 	 * @throws Exception  
 	 * @since 17-Sep-14 
 	 *  <br>  
 	 *  <p> 
 	 *  <p><B>Course      :</B> Software Architecture And Design 
 	 *  <p><B>Section     :</B> CS-6310-O01  
 	 *  <p><B>Term        :</B> Fall 2014 
 	 *  <p><B>FileName    :</B> Demo.java 
 	 *  <p><B>Description:</B>  
 	 *  <p> <center><B> Project 1: - Heated Plate (TWFAHP)  implementation </B></center>  
 	 *    Demo is the main method for this permutation of the the 4 algorithms. 
 	 * 
 	 * 
 	 * @see TpdahpCommand 
 	 * @see Plate
     * @see TpdahpPlate 
 	*/ 
public class Demo {

	public Demo() {
		
	}

	public static void main(String[] args)  throws Exception{
		
		try {
		     // if (args.length <5)
		    //	  throw new IllegalArgumentException("The wrong number of arguments have been supplied.");
		      
		      TwfahpPlate heatedPlate = new TwfahpPlate(100, 509.028397862f,3022.23f,4522.1278372f,5732.87657354f);
		      TwfahpCommand twfahp = new TwfahpCommand(heatedPlate);
		      
		 
		      do{
                   
		        heatedPlate = twfahp.execute(heatedPlate);	  
		        } while (heatedPlate.numIterations < 1000000);
		      
		     } 	  
		catch(Exception e)
		     {
               e.getMessage();			
			
		     }
		      
		

	}

}