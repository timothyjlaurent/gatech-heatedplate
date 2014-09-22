package edu.gatech.heatedplate.tpdahp;

import java.text.DecimalFormat;
import java.util.HashMap;

import edu.gatech.heatedplate.common.Plate;

public class TpdahpPlate implements Plate {

	private double      mLeft;        
    private double      mRight;
    private double      mTop;
    private double      mBottom; 
	double[][]  mPlateValues  ;   // stores the temperature for each lattice point of the plate
	public int  numIterations;  // static counter to keep track of the number of times plate was instantiated (iterations)
	private int         mDim;
 	
	/* concrete plate constructor for Tpdahp plate 
	 * @param <b>d</b> height width dimensions for the plate lattice
	 * @param <b>l</b> Left edge of plate lattice
	 * @param <b>r</b> Right edge of plate lattice
	 * @param <b>t</b> Top edge of plate lattice
	 * @param <b>b</b> Bottom edge of plate lattice
	 */
	public TpdahpPlate(int d , double l, double r, double t, double b) 
	  {
		numIterations = 0;     // static counter for number of instantiated iterations 
        setmPlateValues(new double[d + 2] [d +2]) ;  //creates a 2 dimensional array of doubles in the size of d +2
        mLeft             = l;
        mRight            = r;
        mTop              = t;
        mBottom           = b;
        mDim              = d;
        setEdgeValues(d);
       
	  }

	public TpdahpPlate( TpdahpPlate doublePlate) 
	  {
	  numIterations = doublePlate.numIterations + 1;     // static counter for number of instantiated iterations 
	  int d = doublePlate.getDimension();
      double l = doublePlate.getLeft();
      double r = doublePlate.getRight();
      double t = doublePlate.getTop();
      double b = doublePlate.getBottom();
	  
	  mPlateValues      = new double[d + 2] [d +2] ;  //creates a 2 dimensional array of doubles in the size of d +2
      mLeft             = l;
      mRight            = r;
      mTop              = t;
      mBottom           = b;
      mDim              = d;
      setEdgeValues(d);

	  }
	
	
	
	
	
	
	public void resetIterations(){
		numIterations = 0 ; 
	}
	
	/* Initializes Plate edge temperatures to values specified 
	 * @param <b>d</b> height width dimensions for the plate lattice
	 * 
	 */
	private void setEdgeValues(int d)
	  {
        for (int row = 0; row < d+2; row++)
           {
      	
        	 for (int col = 0; col < d+2; col++ )
      	        {
      		     //set the edge value when traversal reaches edge
      		
      		     if( (row == 0 ) )                         // top row
      		       getmPlateValues()[row][col] = mTop;
      		
      		     if( (col == 0))                           // left edge   
      		       getmPlateValues()[row][col] = mLeft;
      		
      		     if( (row == d+1 ) )                       // right edge   
        	       getmPlateValues()[row][col] = mBottom;
        		
        	     if( (col == d+1))                         // bottom edge    
        	       getmPlateValues()[row][col] = mRight;
      	    
      	       } // end col-loop
      	
          } // end row-loop
		
	}
	

	public double getLeft() {
		return mLeft;
	}

	public void setLeft(double mLeft) {
		this.mLeft = mLeft;
	}
	public double getRight() {
		return mRight;
	}

	public void setRight(double mRight) {
		this.mRight = mRight;
	}
	public double getTop() {
		return mTop;
	}

	public void setTop(double mTop) {
		this.mTop = mTop;
	}
	
	public double getBottom() {
		return mBottom;
	}

	public void setBottom(double mBottom) {
		this.mBottom = mBottom;
	}
	public int  getDimension() {
		return mDim;
	}
	
	public void DisplpayPlateTemp()
	  {
		for (int row = 1; row <= this.getDimension(); row++)
      {
	     	 for (int col = 1; col <= this.getDimension(); col++ )
	            {
	     		 System.out.print("| "+ Math.round(getmPlateValues()[row][col] *100.00)/100.00 +" | " );
	            }
	     	 System.out.print("\n");
	    }
	  }

	public double[][] getmPlateValues() {
		return mPlateValues;
	}

	public void setmPlateValues(double[][] mPlateValues) {
		this.mPlateValues = mPlateValues;
	}
	
	public void intializePlate() {
		
	}
	
	public double[][] toArray(){
		double[][] ret = new double[mDim][mDim]; 
		for ( int col = 0 ; col < mDim ; col += 1){
			for( int row = 0 ; row < mDim ; row += 1){
				ret[row][col] = (double)mPlateValues[row+1][col + 1];
			}
		}
		return ret ;
	}

	public int getIteration() {
		// TODO Auto-generated method stub
		return numIterations;
	}

	public void setTemp(int row, int col, double val) {
		mPlateValues[row][col] = val;
		
	}

	public double getTemp(int row, int col) {
		// TODO Auto-generated method stub
		return (double)mPlateValues[row][col];
	}

	
	/**
	 * Converts the grid to a string
	 * @return grid string
	 */
	public String gridToString(){
		DecimalFormat df = new DecimalFormat("00.00");
		String out = new String();
		for( int row = 0 ; row < mDim ; row += 1){
			for( int col = 0 ; col < mDim ; col += 1) {
				out += df.format( mPlateValues[row][col] );
				if ( col == mDim - 1 ){
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
		return "Iteration : " + numIterations 
				+"\nEdge temps :" 
				+"\nup : " + df.format(mTop) 
				+"\nright : " + df.format(mRight) 
				+"\ndown : " + df.format(mBottom) 
				+"\nleft : " + df.format(mLeft) 
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
	
	
}
