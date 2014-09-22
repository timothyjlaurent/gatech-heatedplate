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
 	 * @see PlateObj
     * @see TpdahpPlate 
 */ 
package edu.gatech.heatedplate.twfahp;

import edu.gatech.heatedplate.common.Command;
import edu.gatech.heatedplate.common.Plate;



public class TwfahpCommand implements Command {

	private double tempPercisionDelta = 1.0f ;
	private Float percisionThreshold = 0.01f;
	private TwfahpPlate newFloatPlate ;
	private double maxDelta;
	
	
	public TwfahpCommand(TwfahpPlate FloatPlate, boolean initialize) {
		

		
		newFloatPlate = new TwfahpPlate(FloatPlate.getDimension(),
                                         (float)FloatPlate.getLeft(),
                                         (float)FloatPlate.getRight(),
                                         (float)FloatPlate.getTop(),
                                         (float)FloatPlate.getBottom()) ;
		if( initialize ){
			FloatPlate.resetIterations();
		}
		
	}
	
	
	
	
	
	/**
	 * 
	 */
	public TwfahpCommand(TwfahpPlate FloatPlate) {
		

		
		newFloatPlate = new TwfahpPlate(FloatPlate.getDimension(),
                                         (float)FloatPlate.getLeft(),
                                         (float)FloatPlate.getRight(),
                                         (float)FloatPlate.getTop(),
                                         (float)FloatPlate.getBottom()) ;

		newFloatPlate.numIterations = 0;
		
	}

	/* (non-Javadoc)
	 * @see edu.gatech.heatedplate.command.Command#execute()
	 */
	public Plate execute(Plate ofp)
	   {
		 TwfahpPlate oldFloatPlate = (TwfahpPlate) ofp ;  
	     int d = oldFloatPlate.getDimension();
	     maxDelta = 0.0;
    	 newFloatPlate = new TwfahpPlate(oldFloatPlate);
	     
//	     newFloatPlate.numIterations++;
	     for (int row = 1; row <= d; row++)
            {
   	     	 for (int col = 1; col <= d; col++ )
   	            {
   	     		 	
   	     		newFloatPlate.mPlateValues[row][col]  =   new Float((oldFloatPlate.getTemp(row + 1 , col)  + 
     		                                                         oldFloatPlate.getTemp(row - 1 ,col)  +
     		                                                         oldFloatPlate.getTemp(row , col +1)    +
     		                                                         oldFloatPlate.getTemp(row ,col - 1))/4.00f);
   	     		                            
     	     //if ((newFloatPlate.numIterations > (d+2 * d+2) ) && (newFloatPlate.mPlateValues[row][col] -  oldFloatPlate.mPlateValues[row][col] < tempPercisionDelta))  
     	     tempPercisionDelta = (double)(newFloatPlate.getTemp(row , col) -  oldFloatPlate.getTemp(row , col));
     	    if ( tempPercisionDelta > maxDelta){
     	    	maxDelta = tempPercisionDelta;
     	    }
     	    //	  if( tempPercisionDelta   <= percisionThreshold)
     	   // 		  break rowloop ;
     	    		  
   	            }
         	
    	    }
               
	    return newFloatPlate;
	  }

	
	public double getPercision()
	  {
		return tempPercisionDelta;
		
	  }
	
	@Override
	public double getMaxDelta(){
		return (double)maxDelta;
	}	
	
	@Override
	public int getIteration(){
		return newFloatPlate.numIterations ;	
	}

}
