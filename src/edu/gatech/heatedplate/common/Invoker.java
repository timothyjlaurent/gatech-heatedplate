package edu.gatech.heatedplate.common;
/**  
 * @author Team#  
	 * @version 1.0 
	 * @throws IllegalArgumentException  
	 * @since 19-Sep-14 
	 *  <br>  
	 *  <p> 
	 *  <p><B>Course      :</B> Software Architecture And Design 
	 *  <p><B>Section     :</B> CS-6310-O01  
	 *  <p><B>Term        :</B> Fall 2014 
	 *  <p><B>FileName    :</B> Invoker.java 
	 *  <p><B>Description:</B>  
	 *  <p> <center><B> Project 1: - Command Object Pattern Invoker class  implementation </B></center>  
	 *    This class works as a Command selector and static factory method for the appropriate Command Object. 
	 * 
	 * 
	 * @see Command 
	 * @see Plate
     * @see tpdahpCommand 
	 */ 
import edu.gatech.heatedplate.Tpdohp.ObjectPlate;
import edu.gatech.heatedplate.Tpdohp.TpdohpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;
import edu.gatech.heatedplate.tpfahp.TpfahpCommand;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;
import edu.gatech.heatedplate.twfahp.TwfahpCommand;
import edu.gatech.heatedplate.twfahp.TwfahpPlate;

public class Invoker {
	
	
	    public static Command setCommand (String algType, Plate invkerPlate) {
	    	try 
	    	   {
	    	
  	             Command CmdObj = null;
	      
	             switch (algType.toUpperCase())
	                {
                     // array of primitive doubles  	        
                     case "TPDAHP":
                     CmdObj = new TpdahpCommand((TpdahpPlate)invkerPlate);
	                 break;
	 
	                 // array of primative float             
                     case "TPFAHP":
	                 CmdObj = new TpfahpCommand((TpfahpPlate)invkerPlate);
	                 break;
	             
	                 // array of Float wrapper class
	                 case "TWFAHP":
		             CmdObj = new TwfahpCommand((TwfahpPlate)invkerPlate);
		             break;
	             
		             // object implentation without array
	                 case "TPDOHP":
			         CmdObj = new TpdohpCommand((ObjectPlate)invkerPlate);
			         break;

	                default:
	                throw new IllegalArgumentException("Can not Invoke the command type requested");
                  
	              } 
	             
	             return CmdObj;
	           }
	    	catch(Exception e) 
	    	 	 { 
	    			throw new IllegalArgumentException(e.getMessage()); 
	    	 		 
	    	 	 }  
     
	             
	       
	    }
	


	public Invoker() {
		// TODO Auto-generated constructor stub
	}

}
