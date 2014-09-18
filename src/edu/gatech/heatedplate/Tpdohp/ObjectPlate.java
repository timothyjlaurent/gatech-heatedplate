package edu.gatech.heatedplate.Tpdohp;

import java.text.DecimalFormat;
import java.util.HashMap;

//import edu.gatech.heatedplate.PlateCommon.IterationMessage;
//import edu.gatech.heatedplate.PlateCommon.PlateObj;
import edu.gatech.heatedplate.common.Plate;

public class ObjectPlate implements Plate {
	
	HashMap<Integer, HashMap<Integer, GridObj>> grid; //
	private Integer height;  // dimensions
	private Integer width;   // dimensions
	private GridObj top;      // temperatures
	private GridObj bottom;   // ''
	private GridObj right;    // ''
	private GridObj left;     // ''
//	GridObj upperLeft; // the upper left grid coordinate
	private Integer iteration; // the iteration #
	private Double maxDelta;
	
	public HashMap<Integer, Plate> getTemp(){
		HashMap<Integer, Plate> map = new HashMap<Integer, Plate>();
		map.put(iteration, this);
		return map;
	}
	
	public void setInteration(int i ){
		iteration = i ;
	}

	public void setMaxDelta(double d ){
		this.maxDelta = d;
	}
	
	
	
	public ObjectPlate(Integer width, Integer height, Double top, Double right , Double bottom , Double left){
		this.width = width;
		this.height = height;
		this.top = new GridObj( top );
		this.right = new GridObj( right );
		this.left = new GridObj( left );
		this.bottom = new GridObj( bottom );
		grid = new HashMap<Integer, HashMap<Integer, GridObj >>();
		
		for( int row = 0 ; row < height ; row += 1 ){
			for( int col = 0 ; col < width ; col += 1  ){
				setGrid(row , col, 0);
			}
		}
		makeGridConnections();	
		this.iteration = 0;
		this.maxDelta = 0.0;
	}	

	private void makeGridConnections() {
		for( int row = 0 ; row < height ; row += 1 ){
			for( int col = 0 ; col < width ; col += 1  ){
				GridObj cur = grid.get(row).get(col);
				if ( row == 0 ){
					cur.un = top;
				} else {
					cur.un = grid.get( row - 1 ).get( col );
				}
				if ( row == height - 1 ){
					cur.dn = bottom;
				} else {
					cur.dn = grid.get(row+1).get( col );
				}
				if ( col == 0 ){
					cur.ln = left;
				} else{
					cur.ln = grid.get(row).get( col - 1);
				}
				if ( col == width - 1 ){
					cur.rn = right;
				}else {
					cur.rn = grid.get(row).get( col + 1 );
				}
			}
		}
	}


	protected void setGrid( int row, int col, double temp){
		if( !grid.containsKey(row) ){
			grid.put(row, new HashMap<Integer, GridObj >());	
		}	
		grid.get(row).put(col, new GridObj(temp));
	}
	
	protected void setTemp( int row, int col, double temp){
		grid.get(row).get(col).setTemp(temp);
	}
	
	
	/**
	 * gets the current temp of the plate coordinate
	 * @return
	 */
	double getTemp(int row, int col){
		return grid.get(row).get(col).temp;
	}
	
	/**
	 * gets the average of the plate coordinate
	 * @return
	 */
	double getNextTemp(int row, int col){
		return grid.get(row).get(col).averageTemp();
	}
	
	public double[][] toArray(){
		double[][] out = new double[height][width];
		for( int row = 0 ; row < height ; row += 1 ){
			for( int col = 0 ; col < width ; col += 1  ){
				out[row][col] = this.getTemp(row , col );
			}
		}
		return out;
	}
	
	public String gridToString(){
		DecimalFormat df = new DecimalFormat("00.00");
		String out = new String();
		for( int row = 0 ; row < height ; row += 1){
			for( int col = 0 ; col < width ; col += 1) {
				out += df.format(grid.get(row).get(col).getTemp() );
				if ( col == width - 1 ){
					out+= "\n";
				} else {
					out += "\t";
				}
			}
		}  
		out += "\n\n\n";
		return out;
	}
	
	
	public String headerString() {
		
		DecimalFormat df = new DecimalFormat("00.00");
		return "Iteration : " + iteration 
				+"\nEdge temps :" 
				+"\nup : " + df.format(top.getTemp()) 
				+"\nright : " + df.format(right.getTemp()) 
				+"\ndown : " + df.format(bottom.getTemp()) 
				+"\nleft : " + df.format(left.getTemp()) 
				+"\n\nMax delta : " + df.format(maxDelta)
				+ "\n\n"; 			
	}
	
	public String toString(){
		return headerString() + gridToString();
	}

	public void print(){
		System.out.println(this.toString());
	}
	
	class GridObj{
		
		GridObj ln; // coordinate neighbors
		GridObj rn;
		GridObj un;
		GridObj dn;
		private double temp;
		
		
		public GridObj( double temp ) {
			this.temp=temp;
		}
		
		public double averageTemp(){
			return (ln.temp + rn.temp + un.temp + dn.temp)/4.0;
		}
		
		public double getTemp(){
			return this.temp;
		}
		
		public void setTemp(double temp){
			this.temp = temp;
		}
		
	}
	
	public GridObj getBottom() {
		return bottom;
	}


	public void setBottom(GridObj bottom) {
		this.bottom = bottom;
	}


	public Integer getHeight() {
		return height;
	}


	public Integer getWidth() {
		return width;
	}


	public GridObj getTop() {
		return top;
	}


	public GridObj getRight() {
		return right;
	}


	public GridObj getLeft() {
		return left;
	}


	public Integer getIteration() {
		return iteration;
	}
	
}
