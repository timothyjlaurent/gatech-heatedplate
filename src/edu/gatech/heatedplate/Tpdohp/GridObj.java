package edu.gatech.heatedplate.Tpdohp;

public class GridObj {
	
	GridObj ln; // coordinate neighbors
	GridObj rn;
	GridObj un;
	GridObj dn;
	private double temp;
	
	/**
	 * Constructor
	 * @param temp
	 */
	public GridObj( double temp ) {
		this.temp=temp;
	}
	
	/**
	 * return the average of the neighboring temps
	 * @return
	 */
	public double averageTemp(){
		return (ln.temp + rn.temp + un.temp + dn.temp)/4.0;
	}
	
	/**
	 * returns current temp 
	 * @return
	 */
	public double getTemp(){
		return temp;
	}
	
	/**
	 * sets temp of grid obj
	 * 
	 * @param temp
	 */
	public void setTemp(double temp){
		this.temp = temp;
	}
	
}
