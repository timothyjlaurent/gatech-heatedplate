package edu.gatech.heatedplate.Tpdohp;

import edu.gatech.heatedplate.PlateCommon.*;
import edu.gatech.heatedplate.common.Plate;

/**
 * 
 * @author tlaurent
 *
 */
public class Demo {

	public static double deltaThreshold = .01;
	
	
	public static void main(String[] args) throws Exception {
		
		try {
		PlateOptionObj oo =  PlateOptionParser.parseOptions(args);
		

		ObjectPlate objP = new ObjectPlate( oo.width, oo.height, oo.top, oo.right, oo.bottom, oo.left);
		// plate has zeros
		objP.print();
		TpdohpCommand tpdohp = new TpdohpCommand((ObjectPlate)objP);
		do {
			objP = (ObjectPlate) tpdohp.execute(objP);
			((ObjectPlate)objP).print();
		} while ( tpdohp.getMaxDelta() > deltaThreshold );
			objP = (ObjectPlate) tpdohp.execute(objP);
			objP.print();
		} 
		
	
		catch ( Exception e)
		{
		e.getMessage();
		}
	
		
	}

	
}
