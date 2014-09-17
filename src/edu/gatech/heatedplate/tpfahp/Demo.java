package edu.gatech.heatedplate.tpfahp;

import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpfahp.TpfahpCommand;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;

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
 	 *  <p> <center><B> Project 1: - Heated Plate (TPDAHP)  implementation </B></center>  
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
		      
		      TpfahpPlate heatedPlate = new TpfahpPlate(30, 50.0f,30.23f,45.12f,57.87f);
		      TpfahpCommand tpfahp = new TpfahpCommand(heatedPlate);
		      
		 
		      do{
                   
		        heatedPlate = tpfahp.execute(heatedPlate);	  
		      }  while (tpfahp.getPercision() > 0.01f);
		      
		     } 	  
		catch(Exception e)
		     {
               e.getMessage();			
			
		     }
		      
		

	}

}
