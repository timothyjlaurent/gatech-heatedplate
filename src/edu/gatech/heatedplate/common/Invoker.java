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
import edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.PlateCommandType;
import edu.gatech.heatedplate.Tpdohp.ObjectPlate;
import edu.gatech.heatedplate.Tpdohp.TpdohpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;
import edu.gatech.heatedplate.tpfahp.TpfahpCommand;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;
import edu.gatech.heatedplate.twfahp.TwfahpCommand;
import edu.gatech.heatedplate.twfahp.TwfahpPlate;

public class Invoker {
	
	public Invoker() {

	}
	
	public static Command createCommand(PlateCommandType plateCommandType, Plate plate) {
		Command command = null;
		try { 
			if (plate == null) {
				throw new IllegalArgumentException("Null Plate Object");
			}
							
			switch (plateCommandType) {
				case PLATE_COMMAND_TYPE_TPDAHP:
					command = new TpdahpCommand((TpdahpPlate)plate);
					break; 
				case PLATE_COMMAND_TYPE_TPFAHP:
					command = new TpfahpCommand((TpfahpPlate)plate);
					break;
				case PLATE_COMMAND_TYPE_TWFAHP:
					command = new TwfahpCommand((TwfahpPlate)plate);
					break;
				case PLATE_COMMAND_TYPE_TPDOHP:
					command = new TpdohpCommand((ObjectPlate)plate);
					break;	 
				default:
					break;
			}
		} catch (Exception exception) {
			
		}
							
		return command;
	}

}
