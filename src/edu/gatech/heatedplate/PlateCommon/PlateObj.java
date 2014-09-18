package edu.gatech.heatedplate.PlateCommon;

public abstract class PlateObj {
	
	
	public abstract IterationMessage initializePlate(int height, 
			int width, 
			double top, 
			double right, 
			double bottom, 
			double left);
	
	public abstract IterationMessage iterate();

	
}
