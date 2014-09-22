package edu.gatech.heatedplate.tpfahp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;

public class TpfahpPlate implements Plate {

	private float      mLeft;        
    private float      mRight;
    private float      mTop;
    private float      mBottom; 
	public  float[][]  mPlateValues;   // stores the temperature for each lattice point of the plate
	public  int  numIterations;  // static counter to keep track of the number of times plate was instantiated (iterations)
	private int         mDim;
 	
	/* concrete plate constructor for Tpdahp plate 
	 * @param <b>d</b> height width dimensions for the plate lattice
	 * @param <b>l</b> Left edge of plate lattice
	 * @param <b>r</b> Right edge of plate lattice
	 * @param <b>t</b> Top edge of plate lattice
	 * @param <b>b</b> Bottom edge of plate lattice
	 */
	public TpfahpPlate(int d , float l, float r, float t, float b) 
	  {
		numIterations = 0;     // static counter for number of instantiated iterations 
        mPlateValues      = new float[d + 2] [d +2] ;  //creates a 2 dimensional array of float in the size of d +2
        mLeft             = l;
        mRight            = r;
        mTop              = t;
        mBottom           = b;
        mDim              = d;
        setEdgeValues(d);
  
	  }

	
	public TpfahpPlate( Plate oldFloatPlate) 
	  {
	  numIterations++;     // static counter for number of instantiated iterations 
	  int d = oldFloatPlate.getDimension();
    float l = (float)oldFloatPlate.getLeft();
    float r = (float)oldFloatPlate.getRight();
    float t = (float)oldFloatPlate.getTop();
    float b = (float)oldFloatPlate.getBottom();
	  
	  mPlateValues      = new float[d + 2] [d +2] ;  //creates a 2 dimensional array of doubles in the size of d +2
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
      		       mPlateValues[row][col] = mTop;
      		
      		     if( (col == 0))                           // left edge   
      		       mPlateValues[row][col] = mLeft;
      		
      		     if( (row == d+1 ) )                       // right edge   
        	       mPlateValues[row][col] = mBottom;
        		
        	     if( (col == d+1))                         // bottom edge    
        	       mPlateValues[row][col] = mRight;
      	    
      	       } // end col-loop
      	
          } // end row-loop
		
	}
	


	public double getLeft() {
		return (double)mLeft;
	}

	public void setLeft(float mLeft) {
		this.mLeft = mLeft;
	}
	public double getRight() {
		return (double)mRight;
	}

	public void setRight(float mRight) {
		this.mRight = mRight;
	}
	public double getTop() {
		return (double)mTop;
	}

	public void setTop(float mTop) {
		this.mTop = mTop;
	}
	
	public double getBottom() {
		return (double)mBottom;
	}

	public void setBottom(float mBottom) {
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
	     		 System.out.print("| "+ Math.round(mPlateValues[row][col] *100.00f)/100.00f +" | " );
	            }
	     	 System.out.print("\n");
	    }
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


	@Override
	public int getIteration() {
		// TODO Auto-generated method stub
		return numIterations;
	}


	public void setTemp(int row, int col, double val) {
		mPlateValues[row][col] = (float) val;
		
	}


	public double getTemp(int row, int col) {
		// TODO Auto-generated method stub
		return mPlateValues[row][col];
		
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
