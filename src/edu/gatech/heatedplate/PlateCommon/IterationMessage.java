package edu.gatech.heatedplate.PlateCommon;

public class IterationMessage {

	double[][] plateTemps;
	int iteration;
	double maxDelta;
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
