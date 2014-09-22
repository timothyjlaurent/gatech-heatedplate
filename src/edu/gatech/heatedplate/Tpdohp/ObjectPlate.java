package edu.gatech.heatedplate.Tpdohp;

import java.text.DecimalFormat;
import java.util.HashMap;


//import edu.gatech.heatedplate.PlateCommon.IterationMessage;
//import edu.gatech.heatedplate.PlateCommon.PlateObj;
import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.Tpdohp.GridObj;


public class ObjectPlate implements Plate {
	
	HashMap<Integer, HashMap<Integer, GridObj>> grid; //
	private int height;  // dimensions
	private int width;   // dimensions
	private GridObj top;      // temperatures
	private GridObj bottom;   // ''
	private GridObj right;    // ''
	private GridObj left;     // ''
//	GridObj upperLeft; // the upper left grid coordinate
	private int iteration; // the iteration #
	private double maxDelta;
	

	/**
	 * 
	 * @param i
	 */
	protected void setInteration(int i ){
		iteration = i ;
	}
	
	/**
	 * 
	 * @param d
	 */
	protected void setMaxDelta(double d){
		this.maxDelta = d;
	}
	
	/**constructor for the Object Plate
	 * 
	 * @param width
	 * @param height
	 * @param top
	 * @param right
	 * @param bottom
	 * @param left
	 */
	public ObjectPlate(int width, int height, double top, double right , double bottom , double left){

		this.width = width;
		this.height = height;
		this.top = new GridObj( top );
		this.right = new GridObj( right );
		this.left = new GridObj( left );
		this.bottom = new GridObj( bottom );
		grid = new HashMap<Integer, HashMap<Integer, GridObj >>( height * 5 );
//		grid = new HashMap<Integer, HashMap<Integer, GridObj >>( );
		
//		for( int row = 0 ; row < height ; row += 1 ){
//			for( int col = 0 ; col < width ; col += 1  ){
//				setGrid(row , col, 0);
//			}
//		}
//		makeGridConnections();	
		this.iteration = 0;
		this.intializePlate();
	}	

	public ObjectPlate(int d, double top, double right , double bottom , double left){
		this(d,d,top,right,bottom,left);
	}

	
	public ObjectPlate(ObjectPlate oldPlate){
		this.width = oldPlate.getWidth();
		this.height = oldPlate.getHeight();
		this.top = new GridObj(oldPlate.getTop());
		this.right = new GridObj(oldPlate.getRight());
		this.bottom = new GridObj(oldPlate.getBottom());
		this.left = new GridObj(oldPlate.getLeft());
		this.iteration = oldPlate.getIteration() + 1;
	}
	
	
	/**
	 * Creates initial grid and populates it with zeros
	 */
	public void intializePlate(){
		for( int row = 0 ; row < height; row += 1){
			for ( int col = 0 ; col < height ; col += 1){
				setGrid(row, col, 0.0);
			}
		}
	}

	// not used
//	private void makeGridConnections() {
//		for( int row = 0 ; row < height ; row += 1 ){
//			for( int col = 0 ; col < width ; col += 1  ){
//				GridObj cur = grid.get(row).get(col);
//				if ( row == 0 ){
//					cur.un = top;
//				} else {
//					cur.un = grid.get( row - 1 ).get( col );
//				}
//				if ( row == height - 1 ){
//					cur.dn = bottom;
//				} else {
//					cur.dn = grid.get(row+1).get( col );
//				}
//				if ( col == 0 ){
//					cur.ln = left;
//				} else{
//					cur.ln = grid.get(row).get( col - 1);
//				}
//				if ( col == width - 1 ){
//					cur.rn = right;
//				}else {
//					cur.rn = grid.get(row).get( col + 1 );
//				}
//			}
//		}
//	}

	/**
	 * This method sets the temp on a grid coordinate that is being grown from 
	 * left to right and top to bottom. After the temp is set calls growGrid to 
	 * make bidirectional gridObj connections.
	 * 
	 * 
	 * @param row grid row
	 * @param col grid column
	 * @param temp temperature to set a grid temp
	 */
	protected void setGrid( int row, int col, double temp){
		if( !grid.containsKey(row) ){
			grid.put(row, new HashMap<Integer, GridObj >(width * 5 ));	
//			grid.put(row, new HashMap<Integer, GridObj >( ));	
		}	
		grid.get(row).put(col, new GridObj(temp));
		growGrid(row, col);
	}
	
	/**
	 * Accessory method to the setGrid - makes connectoins to a sentinal GridObj
	 * if is on the plate edges otherwise makes bidirectional connections 
	 * to the left and top neighbor. sets tn, bn, rn, and ln
	 * 
	 * @param row
	 * @param col
	 */
	protected void growGrid( Integer row, Integer col ){
		GridObj cur = grid.get(row).get(col);
		if ( row == 0 ){
			cur.un = top;
		} else {
			cur.un = grid.get( row - 1 ).get( col );
			cur.un.dn = cur;
		}
		if( row == height - 1 ){
			cur.dn = bottom;
		}
		if( col == 0 ){
			cur.ln = left;
		} else{
			cur.ln = grid.get(row).get(col-1);
			cur.ln.rn = cur;
		}
		if( col == width - 1 ){
			cur.rn = right;
		}
	}
	
	
	/**
	 * Set's temp of a grid location
	 * not currently used
	 * 
	 * @param row
	 * @param col
	 * @param temp
	 */
	public void setTemp( int row, int col, double temp){
		grid.get(row).get(col).setTemp(temp);
	}
	
	
	/**
	 * gets the current temp of the plate coordinate
	 * @return
	 */
	@Override
	public
	double getTemp(int row, int col){
		return grid.get(row).get(col).getTemp();
	}
	
	/**
	 * gets the average of the plate coordinate
	 * @return
	 */
	protected double getNextTemp(int row, int col){
		return grid.get(row).get(col).averageTemp();
	}
	
	/**
	 * converts the grid object to an array of doubles 
	 * 
	 * @return double array of the grid's temp
	 */
	public double[][] toArray(){
		double[][] out = new double[height][width];
		for( int row = 0 ; row < height ; row += 1 ){
			for( int col = 0 ; col < width ; col += 1  ){
				out[row][col] = this.getTemp(row , col );
			}
		}
		return out;
	}
	
	/**
	 * Converts the grid to a string
	 * @return grid string
	 */
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
	
	/**
	 * prints a header string
	 * @return header string
	 */
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
	
	/**
	 * converts entire plate , header and grid to string
	 * @return  plate string
	 */
	public String toString(){
		return headerString() + gridToString();
	}

	/**
	 * prints the plate
	 */
	public void print(){
		System.out.println(this.toString());
	}
	
	/**
	 * 
	 * @return
	 */
	public double getBottom() {
		return bottom.getTemp();
	}
        /**
         * 
         * @return
         */
	public int getHeight() {
		return height;
	}
/**
 * 
 * @return
 */
	public int getWidth() {
		return width;
	}
	/**
	 * 
	 * @return
	 */
	public double getTop() {
		return top.getTemp();
	}
	/**
	 * 
	 * @return
	 */
	public double getRight() {
		return right.getTemp();
	}
	/**
	 * 
	 * @return
	 */
	public double getLeft() {
		return left.getTemp();
	}
	/**
	 * 
	 * @return
	 */
	public int getIteration() {
		return iteration;
	}

	@Override
	public int getDimension() {
		// TODO Auto-generated method stub
		return height;
	}

	
	
//	/**
//	 * GridpObject Class
//	 * @author tlaurent
//	 *
//	 */
//	class GridObj{
//		
//		GridObj ln; // coordinate neighbors
//		GridObj rn;
//		GridObj un;
//		GridObj dn;
//		private double temp;
//		
//		/**
//		 * Constructor
//		 * @param temp
//		 */
//		public GridObj( double temp ) {
//			this.temp=temp;
//		}
//		
//		/**
//		 * return the average of the neighboring temps
//		 * @return
//		 */
//		public double averageTemp(){
//			return (ln.temp + rn.temp + un.temp + dn.temp)/4.0;
//		}
//		
//		/**
//		 * rteurns current temp 
//		 * @return
//		 */
//		public double getTemp(){
//			return temp;
//		}
//		
//		/**
//		 * sets temp of grid obj
//		 * 
//		 * @param temp
//		 */
//		public void setTemp(double temp){
//			this.temp = temp;
//		}
//		
//	}
	

}
