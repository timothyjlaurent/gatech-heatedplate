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
 	 *  <p><B>FileName    :</B> TwfahpCommand.java 
 	 *  <p><B>Description:</B>  
 	 *  <p> <center><B> Project 1: - Heated Plate (TWFAHP)  implementation </B></center>  
 	 *   a simple command object design pattern implementation of thealgorithm to
         *   compute in float precision, the diffusion of heat on a plate. 
 	 * 
 	 * 
 	 * @see command 
 	 * @see Plate
     * @see TpdahpPlate 
 */ 
package edu.gatech.heatedplate.twfahp;

import edu.gatech.heatedplate.common.Command;
import edu.gatech.heatedplate.common.Plate;



public class TwfahpCommand implements Command {

	private Float tempPercisionDelta = 1.0f ;
	private Float percisionThreshold = 0.01f;
	private TwfahpPlate newFloatPlate ;
	
	
	
	/**
	 * 
	 */
	public TwfahpCommand(TwfahpPlate FloatPlate) {
		

		
		newFloatPlate = new TwfahpPlate(FloatPlate.getDimension(),
                                         FloatPlate.getLeft(),
                                         FloatPlate.getRight(),
                                         FloatPlate.getTop(),
                                         FloatPlate.getBottom()) ;
	
		
	}

	/* (non-Javadoc)
	 * @see edu.gatech.heatedplate.command.Command#execute()
	 */
	public TwfahpPlate execute(TwfahpPlate oldFloatPlate)
	   {
		   
	     int d = oldFloatPlate.getDimension();
	 	
	     for (int row = 1; row <= d; row++)
            {
	    	 newFloatPlate.numIterations++;
   	     	 for (int col = 1; col <= d; col++ )
   	            {
   	     		 
     	    	  newFloatPlate.mPlateValues[row][col]  = ((oldFloatPlate.mPlateValues[row + 1] [col].floatValue()  + 
     		                                                oldFloatPlate.mPlateValues[row - 1] [col].floatValue()  +
     		                                                oldFloatPlate.mPlateValues[row] [col +1].floatValue()   +
     		                                                oldFloatPlate.mPlateValues[row] [col - 1].floatValue()) / 4.0f);
     	      // if ((newFloatPlate.numIterations > d+2) && (newFloatPlate.mPlateValues[row][col] -  oldFloatPlate.mPlateValues[row][col] < tempPercisionDelta))  
     	    ///	 tempPercisionDelta = newFloatPlate.mPlateValues[row][col] -  oldFloatPlate.mPlateValues[row][col];
     	    	  
     	   // 	  if( tempPercisionDelta   <= percisionThreshold)
     	   // 		  continue;
     	    		  
   	            }
         	
    	    }
               
	    return newFloatPlate;
	  }

	@Override
	public Plate execute(Plate plate) {
	 //TODO Auto-generated method stub
		return null;
	}
	
	public double getPercision()
	  {
		return tempPercisionDelta;
		
	  }
	
	

}
