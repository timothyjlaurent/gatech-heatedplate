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
		
		Plate objP = new ObjectPlate( oo.width, oo.height, oo.top, oo.right, oo.bottom, oo.left);
		((ObjectPlate)objP).intializePlate();
		// plate has zeros
		((ObjectPlate)objP).print();
		TpdohpCommand tpdohp = new TpdohpCommand((ObjectPlate)objP);
		do {
			objP = tpdohp.execute(objP);
			((ObjectPlate)objP).print();
		} while ( tpdohp.getMaxDelta() > deltaThreshold || tpdohp.getIteration() < 1000000 );
		}
		catch ( Exception e)
		{
		e.getMessage();
		}
	
		
	}

	
}
