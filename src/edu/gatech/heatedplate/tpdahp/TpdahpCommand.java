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
 	 *  <p><B>FileName    :</B> TpdahpCommand.java 
 	 *  <p><B>Description:</B>  
 	 *  <p> <center><B> Project 1: - Heated Plate (TPDAHP)  implementation </B></center>  
 	 *   a simple command object design pattern implementation of thealgorithm to
         *   compute in double precision, the diffusion of heat on a plate. 
 	 * 
 	 * 
 	 * @see command 
 	 * @see PlateObj
     * @see TpdahpPlate 
 */ 
package edu.gatech.heatedplate.tpdahp;

import edu.gatech.heatedplate.common.Command;
import edu.gatech.heatedplate.common.Plate;



public class TpdahpCommand implements Command {

	private double tempPercisionDelta ;
	private double percisionThreshold = .01;
	private TpdahpPlate newDoublePlate ;
	//private TpdahpPlate oldDoublePlate ;
	
	
	/**
	 * 
	 */
	public TpdahpCommand(TpdahpPlate doublePlate) {
		

		
		newDoublePlate = new TpdahpPlate(doublePlate.getDimension(),
                                         doublePlate.getLeft(),
                                         doublePlate.getRight(),
                                         doublePlate.getTop(),
                                         doublePlate.getBottom()) ;
	
		
	}

	/* (non-Javadoc)
	 * @see edu.gatech.heatedplate.command.Command#execute()
	 */
	public TpdahpPlate execute(TpdahpPlate oldDoublePlate)
	   {
		   
	     int d = oldDoublePlate.getDimension();
	 	
	     for (int row = 1; row <= d; row++)
            {
	    	 newDoublePlate.numIterations++;
   	     	 for (int col = 1; col <= d; col++ )
   	            {
     	    	  newDoublePlate.mPlateValues[row][col] = ( oldDoublePlate.mPlateValues[row + 1] [col]  + 
     		                                                oldDoublePlate.mPlateValues[row - 1] [col]  +
     		                                                oldDoublePlate.mPlateValues[row] [col +1]   +
     		                                                oldDoublePlate.mPlateValues[row] [col - 1]) / 4.0;
     	    	  
     	    	 tempPercisionDelta = newDoublePlate.mPlateValues[row][col] -  oldDoublePlate.mPlateValues[row][col];
     	    	  
     	    	//  if( tempPercisionDelta   <= percisionThreshold)
     	    	//	  break;
     	    		  
   	            }
         	
    	    }
               
	    return newDoublePlate;
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
