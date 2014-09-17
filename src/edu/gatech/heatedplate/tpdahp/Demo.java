package edu.gatech.heatedplate.tpdahp;

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
 	 *  <p><B>FileName    :</B> Demo.java 
 	 *  <p><B>Description:</B>  
 	 *  <p> <center><B> Project 1: - Heated Plate (TPDAHP)  implementation </B></center>  
 	 *    Demo is the main method for this permutatin of the the 4 algorithms. 
 	 * 
 	 * 
 	 * @see TpdahpCommand 
 	 * @see Plate
     * @see TpdahpPlate 
 	*/ 
public class Demo {

	public Demo() {
		
	}

	public static void main(String[] args)  throws Exception{
		
		try {
		     // if (args.length <5)
		    //	  throw new IllegalArgumentException("The wrong number of arguments have been supplied.");
		      
		      TpdahpPlate heatedPlate = new TpdahpPlate(30, 50.0,30.23,45.12,57.87);
		      TpdahpCommand tpdahp = new TpdahpCommand(heatedPlate);
		      
		 
		      do{
                   
		        heatedPlate = tpdahp.execute(heatedPlate);	  
		      }  while (tpdahp.getPercision() > 0.01);
		      
		     } 	  
		catch(Exception e)
		     {}
		      
		

	}

}
