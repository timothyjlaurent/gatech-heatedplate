/**  
	 * @author Eric H. Griffin 
 	 * @version 1.0 
 	 * @throws Exception  
 	 * @since 17-Sep-14 
 	 *  <br>  
 	 *  <p> 
 	 *  <p><B>Course      :</B> Software Architecture And Design 
 	 *  <p><B>Section     :</B> CS-6310-O01  
 	 *  <p><B>Term        :</B> Fall 2014 
 	 *  <p><B>FileName    :</B> TpfahpCommand.java 
 	 *  <p><B>Description:</B>  
 	 *  <p> <center><B> Project 1: - Heated Plate (TPFAHP)  implementation </B></center>  
 	 *   a simple command object design pattern implementation of thealgorithm to
         *   compute in float precision, the diffusion of heat on a plate. 
 	 * 
 	 * 
 	 * @see command 
 	 * @see PlateObj
     * @see TpdahpPlate 
 */ 
package edu.gatech.heatedplate.tpfahp;

import edu.gatech.heatedplate.common.Command;
import edu.gatech.heatedplate.common.Plate;



public class TpfahpCommand implements Command {

	private float tempPercisionDelta = 1.0f ;
	private float percisionThreshold = 0.01f;
	private TpfahpPlate newFloatPlate ;
	private float maxDelta ;
	
	
	
	/**
	 * 
	 */
	public TpfahpCommand(TpfahpPlate floatPlate, boolean initialize) {
		
		
		maxDelta = 0;
		newFloatPlate = new TpfahpPlate(floatPlate.getDimension(),
                                         (float)floatPlate.getLeft(),
                                         (float)floatPlate.getRight(),
                                         (float)floatPlate.getTop(),
                                         (float)floatPlate.getBottom()) ;
	
		if(initialize){
			newFloatPlate.resetIterations();
		}
	}
	
	
	
	/**
	 * 
	 */
	public TpfahpCommand(TpfahpPlate floatPlate) {
		

		maxDelta = 0;
		newFloatPlate = new TpfahpPlate(floatPlate.getDimension(),
                                         (float)floatPlate.getLeft(),
                                         (float)floatPlate.getRight(),
                                         (float)floatPlate.getTop(),
                                         (float)floatPlate.getBottom()) ;

		
	}

	/* (non-Javadoc)
	 * @see edu.gatech.heatedplate.command.Command#execute()
	 */
	@Override
	public Plate execute(Plate oldFloatPlate)
	   {
		
		TpfahpPlate ofp = (TpfahpPlate)oldFloatPlate; 
		maxDelta = 0;
		TpfahpPlate newFloatPlate = new TpfahpPlate(oldFloatPlate);
	     int d = oldFloatPlate.getDimension();

	     newFloatPlate.numIterations++;
	 	
	     for (int row = 1; row <= d; row++)
            {

   	     	 for (int col = 1; col <= d; col++ )
   	            {
   	     		 
     	    	  newFloatPlate.mPlateValues[row][col] = ( ofp.mPlateValues[row + 1] [col]  + 
     		                                                ofp.mPlateValues[row - 1] [col]  +
     		                                                ofp.mPlateValues[row] [col +1]   +
     		                                                ofp.mPlateValues[row] [col - 1]) / 4.0f;
     	      // if ((newFloatPlate.numIterations > d+2) && (newFloatPlate.mPlateValues[row][col] -  oldFloatPlate.mPlateValues[row][col] < tempPercisionDelta))  
     	    ///	 tempPercisionDelta = newFloatPlate.mPlateValues[row][col] -  oldFloatPlate.mPlateValues[row][col];
     	    	  
     	   // 	  if( tempPercisionDelta   <= percisionThreshold)
     	   // 		  continue;
     	    		  
     	    	  float delta =  newFloatPlate.mPlateValues[row][col] -  ofp.mPlateValues[row][col];
   	              if( delta > maxDelta ){
   	            	  maxDelta = delta;
   	              }
     	    	  
   	            }
         	
    	    }
               
	    return newFloatPlate;
	  }


	
	public double getPercision()
	  {
		return tempPercisionDelta;
		
	  }
	
	public double getMaxDelta(){
		return (double)maxDelta;
	}
	
	
	public int getIteration(){
		return newFloatPlate.numIterations ;	
	}


}
