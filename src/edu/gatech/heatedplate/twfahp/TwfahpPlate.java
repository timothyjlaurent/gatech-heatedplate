package edu.gatech.heatedplate.twfahp;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.heatedplate.common.Plate;

public class TwfahpPlate implements Plate {

	private Float      mLeft;        
    private Float      mRight;
    private Float      mTop;
    private Float      mBottom; 
	public  Float[][]  mPlateValues;   // stores the temperature for each lattice point of the plate
	public static int  numIterations;  // static counter to keep track of the number of times plate was instantiated (iterations)
	private int         mDim;
 	
	/* concrete plate constructor for Tpdahp plate 
	 * @param <b>d</b> height width dimensions for the plate lattice
	 * @param <b>l</b> Left edge of plate lattice
	 * @param <b>r</b> Right edge of plate lattice
	 * @param <b>t</b> Top edge of plate lattice
	 * @param <b>b</b> Bottom edge of plate lattice
	 */
	public TwfahpPlate(int d , Float l, Float r, Float t, Float b) 
	  {
		numIterations++;     // static counter for number of instantiated iterations 
        mPlateValues      = new Float[d + 2] [d +2] ;  //creates a 2 dimensional array of float in the size of d +2
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

	public Float getLeft() {
		return mLeft;
	}

	public void setLeft(Float mLeft) {
		this.mLeft = mLeft;
	}
	public Float getRight() {
		return mRight;
	}

	public void setRight(Float mRight) {
		this.mRight = mRight;
	}
	public Float getTop() {
		return mTop;
	}

	public void setTop(Float mTop) {
		this.mTop = mTop;
	}
	
	public float getBottom() {
		return mBottom;
	}

	public void setBottom(Float mBottom) {
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
	
	
	
}