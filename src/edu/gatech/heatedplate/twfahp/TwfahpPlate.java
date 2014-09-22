package edu.gatech.heatedplate.twfahp;

import java.text.DecimalFormat;
import java.util.HashMap;

import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;

public class TwfahpPlate implements Plate {

	private Float      mLeft;        
    private Float      mRight;
    private Float      mTop;
    private Float      mBottom; 
	public  Float[][]  mPlateValues;   // stores the temperature for each lattice point of the plate
	public  int  numIterations;  // static counter to keep track of the number of times plate was instantiated (iterations)
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
		     // static counter for number of instantiated iterations 
        mPlateValues      = new Float[d + 2] [d +2] ;  //creates a 2 dimensional array of float in the size of d +2
        mLeft             = l;
        mRight            = r;
        mTop              = t;
        mBottom           = b;
        mDim              = d;
        setEdgeValues(d);
        numIterations = 0;
  
	  }
	
	
	public TwfahpPlate( Plate oldFloatPlate) 
	  {
	  this.numIterations = oldFloatPlate.getIteration() + 1;    
	  int d = oldFloatPlate.getDimension();
  Float l = (float)oldFloatPlate.getLeft();
  Float r = (float)oldFloatPlate.getRight();
  Float t = (float)oldFloatPlate.getTop();
  Float b = (float)oldFloatPlate.getBottom();
	  
	  mPlateValues      = new Float[d + 2] [d +2] ;  //creates a 2 dimensional array of doubles in the size of d +2
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
        		   mPlateValues[row][col]  = new Float(0);
      		
      		     if( (row == 0 ) )                         // top row
      		       mPlateValues[row][col] = new Float(mTop);
      		
      		     if( (col == 0))                           // left edge   
      		       mPlateValues[row][col] = new Float(mLeft);
      		
      		     if( (row == d+1 ) )                       // right edge   
        	       mPlateValues[row][col] = new Float(mBottom);
        		
        	     if( (col == d+1))                         // bottom edge    
        	       mPlateValues[row][col] = new Float(mRight);
        	     
        	     
      	    
      	       } // end col-loop
      	
          } // end row-loop
		
	}
	



//	public Float getLeft() {
//		return mLeft;
//	}

	public void setLeft(Float mLeft) {
		this.mLeft = mLeft;
	}
//	public Float getRight() {
//		return mRight;
//	}

	public void setRight(Float mRight) {
		this.mRight = mRight;
	}
//	public Float getTop() {
//		return mTop;
//	}

	public void setTop(Float mTop) {
		this.mTop = mTop;
	}
	
//	public float getBottom() {
//		return mBottom;
//	}

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


	@Override
	public double getTop() {
		// TODO Auto-generated method stub
		return (double)mTop;
	}


	@Override
	public double getRight() {
		// TODO Auto-generated method stub
		return (double)mRight;
	}


	@Override
	public double getBottom() {
		// TODO Auto-generated method stub
		return (double)mBottom;
	}


	@Override
	public double getLeft() {
		// TODO Auto-generated method stub
		return (double)mLeft;
	}


	public void setTemp(int row, int col, double val) {
		// TODO Auto-generated method stub
		mPlateValues[row][col] = (float)val;
		
	}


	public double getTemp(int row, int col) {
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
