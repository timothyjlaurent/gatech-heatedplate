package edu.gatech.heatedplate.PlateCommon;

public abstract class Plate {
	
	public abstract IterationMessage InitializePlate(int height, 
			int width, 
			double top, 
			double right, 
			double bottom, 
			double left);
	
	public abstract IterationMessage Iterate();
	
}
