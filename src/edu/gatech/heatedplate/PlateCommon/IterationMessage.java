package edu.gatech.heatedplate.PlateCommon;

/**
 * Class to pass the simulation state including
 * top,bottom,left, and right temps and double [][]
 * representation of the current grid temps, the iteraiton count, 
 * and a max delta.
 *  
 * @author tlaurent
 *
 */
public class IterationMessage {

	double[][] plateTemps; // [0] top  [0] left
	int iteration; 		  
	double maxDelta;
	double top;
	double bottom;
	double left;
	double right;
	
	
	
	public double[][] getPlateTemps() {
		return plateTemps;
	}
	public void setPlateTemps(double[][] plateTemps) {
		this.plateTemps = plateTemps;
	}
	public int getIteration() {
		return iteration;
	}
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	public double getMaxDelta() {
		return maxDelta;
	}
	public void setMaxDelta(double maxDelta) {
		this.maxDelta = maxDelta;
	}
	
}
