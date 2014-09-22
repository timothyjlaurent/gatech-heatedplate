package edu.gatech.heatedplate.Gallhp;

import edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.PlateCommandType;
import edu.gatech.heatedplate.common.Command;
import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpdahp.TpdahpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;

public class HeatedPlateController {

	public HeatedPlateController() {
		
	}
	
	public boolean initController(HeatedPlateFrame heatedPlateFrame) {
		
		if (heatedPlateFrame == null) {
			return false;
		}
		
		this.heatedPlateFrame = heatedPlateFrame;
		
		return true;
	}
	
	
	public void initCommand(PlateCommandType plateCommandType,
							Integer dimension,
							Double leftEdgeTemperature,
							Double rightEdgeTemperature,
							Double topEdgeTemperature,
							Double bottomEdgeTemperature) {
		
		try {
		if (heatedPlateFrame != null) {
			HeatedPlateResultPanel heatedPlateResultPanel = heatedPlateFrame.getHeatedPlateResultPanel();
			heatedPlateResultPanel.initDisplay(dimension);
			
			Plate plate = HeatedPlateFactory.createPlate(plateCommandType,
														 dimension,
														 leftEdgeTemperature,
														 rightEdgeTemperature,
														 topEdgeTemperature,
														 bottomEdgeTemperature); 
			
			Command command = HeatedPlateFactory.createCommand(plateCommandType, plate);
			
			  do{
	        	  plate = command.execute(plate);
			 } while ( command.getMaxDelta() > deltaThreshold || command.getIteration() < 1000000 );
			 
			  heatedPlateResultPanel.setDisplay(plate.toArray());
		}
		} catch(Exception exception) {
			
		}
	}
	
	
	
	public static double deltaThreshold = .01;
	private HeatedPlateFrame heatedPlateFrame;
}
