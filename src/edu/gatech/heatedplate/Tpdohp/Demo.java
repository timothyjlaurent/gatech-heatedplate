package edu.gatech.heatedplate.Tpdohp;

import edu.gatech.heatedplate.PlateCommon.*;

public class Demo {

	public static double deltaThreshold = .01;
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PlateOptionObj optionObj =  PlateOptionParser.parseOptions(args);
		
		ObjectPlate objP = new ObjectPlate();
		
		diplayPlate( initializePlate(objP, optionObj) );
		
		runSimulation( objP );
	}

	
	
	private static void runSimulation(ObjectPlate objP) {
		IterationMessage itrm;
		do {
			itrm = objP.iterate();
			diplayPlate(itrm);
		}
		while ( itrm.getMaxDelta() > deltaThreshold 
				|| itrm.getIteration() > 1000000 );
	}

	/**
	 * Prints the textual representaion of the plateObject including
	 * iteration #, max delta, and the grid table
	 * 
	 * @param initiatePlate
	 */
	private static void diplayPlate(IterationMessage currentPlate) {
		// TODO Print out the plate values to the correct decimal place
		
	}


	private static IterationMessage initializePlate(ObjectPlate objP, PlateOptionObj optionObj) {
		 return objP.initializePlate(optionObj.getHeight(),
				optionObj.getWidth(),
				optionObj.getTop(), 
				optionObj.getRight(),
				optionObj.getBottom(),
				optionObj.getLeft());
	}

	
	
	
	
	
	
	
}
