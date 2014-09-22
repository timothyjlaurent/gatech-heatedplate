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

	private Float tempPercisionDelta = 1.0f ;
	private Float percisionThreshold = 0.01f;
	private TwfahpPlate newFloatPlate ;
	private double maxDelta;
	
	
	public TwfahpCommand(TwfahpPlate FloatPlate, boolean initialize) {
		

		
		newFloatPlate = new TwfahpPlate(FloatPlate.getDimension(),
                                         FloatPlate.getLeft(),
                                         FloatPlate.getRight(),
                                         FloatPlate.getTop(),
                                         FloatPlate.getBottom()) ;
		if( initialize ){
			FloatPlate.resetIterations();
		}
		
	}
	
	
	
	
	
	/**
	 * 
	 */
	public TwfahpCommand(TwfahpPlate FloatPlate) {
		

		
		newFloatPlate = new TwfahpPlate(FloatPlate.getDimension(),
                                         FloatPlate.getLeft(),
                                         FloatPlate.getRight(),
                                         FloatPlate.getTop(),
                                         FloatPlate.getBottom()) ;
<<<<<<< HEAD
		FloatPlate.resetIterations();
	
=======
		newFloatPlate.numIterations = 0;
>>>>>>> branch 'master' of git@github.com:timothyjlaurent/gatech-heatedplate.git
		
	}

	/* (non-Javadoc)
	 * @see edu.gatech.heatedplate.command.Command#execute()
	 */
	public TwfahpPlate execute(TwfahpPlate oldFloatPlate)
	   {
		   
	     int d = oldFloatPlate.getDimension();
<<<<<<< HEAD
	     maxDelta = 0.0;
    	 newFloatPlate = new TwfahpPlate(oldFloatPlate);
	     
=======
	     newFloatPlate.numIterations++;
>>>>>>> branch 'master' of git@github.com:timothyjlaurent/gatech-heatedplate.git
	     for (int row = 1; row <= d; row++)
            {
<<<<<<< HEAD

=======
	    	 
>>>>>>> branch 'master' of git@github.com:timothyjlaurent/gatech-heatedplate.git
   	     	 for (int col = 1; col <= d; col++ )
   	            {
   	     		 
   	     		 
   	     		
   	     		newFloatPlate.mPlateValues[row][col]  =   new Float((oldFloatPlate.mPlateValues[row + 1] [col]  + 
     		                                                         oldFloatPlate.mPlateValues[row - 1] [col]  +
     		                                                         oldFloatPlate.mPlateValues[row] [col +1]   +
     		                                                         oldFloatPlate.mPlateValues[row] [col - 1])/4.00f);
   	     		                            
   	     		                         
   	    	  
     	     //if ((newFloatPlate.numIterations > (d+2 * d+2) ) && (newFloatPlate.mPlateValues[row][col] -  oldFloatPlate.mPlateValues[row][col] < tempPercisionDelta))  
     	     tempPercisionDelta = newFloatPlate.mPlateValues[row][col] -  oldFloatPlate.mPlateValues[row][col];
     	    if ( tempPercisionDelta > maxDelta){
     	    	maxDelta = tempPercisionDelta;
     	    }
     	    //	  if( tempPercisionDelta   <= percisionThreshold)
     	   // 		  break rowloop ;
     	    		  
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
	
<<<<<<< HEAD
	public double getMaxDelta(){
		return (double)maxDelta;
	}	
	
=======
	public int getIteration(){
		return newFloatPlate.numIterations ;	
	}
>>>>>>> branch 'master' of git@github.com:timothyjlaurent/gatech-heatedplate.git

}
