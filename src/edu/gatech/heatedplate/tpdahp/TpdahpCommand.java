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
	private double maxDelta;
	
	

	
	/**
	 * 
	 */
	public TpdahpCommand(TpdahpPlate doublePlate) {
		

		
		newDoublePlate = new TpdahpPlate(doublePlate.getDimension(),
                                         doublePlate.getLeft(),
                                         doublePlate.getRight(),
                                         doublePlate.getTop(),
                                         doublePlate.getBottom()) ;
		maxDelta = 0.0;
	

	}

	
	
	
	
	
	/* (non-Javadoc)
	 * @see edu.gatech.heatedplate.command.Command#execute()
	 */
	@Override
	public Plate execute(Plate oldDoublePlate)
	   {
		 
		 maxDelta = 0.0;
	     int d = oldDoublePlate.getDimension();
	 	 TpdahpPlate odp = (TpdahpPlate)oldDoublePlate;
	     newDoublePlate = new TpdahpPlate(odp); 
	     
	     

	     for (int row = 1; row <= d; row++)
	     {	    	
   	     	 for (int col = 1; col <= d; col++ )
   	            {
     	    	  newDoublePlate.getmPlateValues()[row][col] = ( odp.getmPlateValues()[row + 1] [col]  + 
     		                                                odp.getmPlateValues()[row - 1] [col]  +
     		                                                odp.getmPlateValues()[row] [col +1]   +
     		                                                odp.getmPlateValues()[row] [col - 1]) / 4.0;
     	    	  
     	    	 tempPercisionDelta = newDoublePlate.mPlateValues[row][col] - odp.mPlateValues[row][col];
     	    	  
     	    	 if(Math.abs(tempPercisionDelta) > maxDelta){
     	    		 maxDelta = Math.abs(tempPercisionDelta);
     	    	 }
     	    	//  if( tempPercisionDelta   <= percisionThreshold)
     	    	//	  break;
     	    		  
   	            }
         	
    	    }
               
	    return newDoublePlate;
	  }

	
	
	public double getPercision()
	  {
		return tempPercisionDelta;
		
	  }
	
	@Override
	public double getMaxDelta(){
		return maxDelta;
	}
	
	@Override
	public int getIteration(){
		return newDoublePlate.numIterations ;	
	}


	

}
