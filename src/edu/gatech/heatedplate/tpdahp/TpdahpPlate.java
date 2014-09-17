package edu.gatech.heatedplate.tpdahp;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.heatedplate.common.Plate;

public class TpdahpPlate implements Plate {

	private double      mLeft;        
    private double      mRight;
    private double      mTop;
    private double      mBottom; 
	public  double[][]  mPlateValues;   // stores the temperature for each lattice point of the plate
	private static int  numIterations;  // static counter to keep track of the number of times plate was instantiated (iterations)
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
		numIterations++;     // static counter for number of instantiated iterations 
        mPlateValues      = new double[d + 2] [d +2] ;  //creates a 2 dimensional array of doubles in the size of d +2
        mLeft             = l;
        mRight            = r;
        mTop              = t;
        mBottom           = b;
        mDim              = d;
        setEdgeValues(d);
  
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
	

	@Override
	public HashMap<Integer, Plate> getTemp() {
		
		HashMap<Integer,Plate> map = new HashMap<Integer,Plate>();
		map.put(numIterations, this);
		
	  return map;
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

	
	

}
