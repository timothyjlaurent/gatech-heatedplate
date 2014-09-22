package edu.gatech.heatedplate.twfahp;

import edu.gatech.heatedplate.PlateCommon.PlateOptionObj;
import edu.gatech.heatedplate.PlateCommon.PlateOptionParser;
import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpfahp.TpfahpCommand;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;
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


	public static double deltaThreshold = .01;
	
	
	public static void main(String[] args) throws Exception {
		
		try {
		     // if (args.length <5)
		    //	  throw new IllegalArgumentException("The wrong number of arguments have been supplied.");
		      

		      
		PlateOptionObj oo =  PlateOptionParser.parseOptions(args);
		
		TwfahpPlate objP = new TwfahpPlate( oo.width, (float)oo.top, (float)oo.right, (float)oo.bottom, (float)oo.left);
		// plate has zeros
		objP.print();
		TwfahpCommand tpdohp = new TwfahpCommand(objP);
		do {
			objP = (TwfahpPlate) tpdohp.execute(objP);
			objP.print();
		} 
		
		while ( tpdohp.getMaxDelta() > deltaThreshold  );
		}
		catch ( Exception e)
		{
		e.getMessage();
		}
	
		

	}

}