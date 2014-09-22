package edu.gatech.heatedplate.tpfahp;

import edu.gatech.heatedplate.PlateCommon.PlateOptionObj;
import edu.gatech.heatedplate.PlateCommon.PlateOptionParser;
import edu.gatech.heatedplate.Tpdohp.ObjectPlate;
import edu.gatech.heatedplate.Tpdohp.TpdohpCommand;
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

	public static double deltaThreshold = .01;
	
	
	public static void main(String[] args) throws Exception {
		
		try {

		PlateOptionObj oo =  PlateOptionParser.parseOptions(args);
		
		TpfahpPlate objP = new TpfahpPlate( oo.width, (float)oo.top, (float)oo.right, (float)oo.bottom, (float)oo.left);
		// plate has zeros
		objP.print();
		TpfahpCommand tpdohp = new TpfahpCommand(objP);
		do {
			objP = (TpfahpPlate) tpdohp.execute(objP);
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
