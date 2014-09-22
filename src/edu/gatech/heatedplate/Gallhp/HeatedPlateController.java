package edu.gatech.heatedplate.Gallhp;

import edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.PlateCommandType;
import edu.gatech.heatedplate.common.Command;
import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpdahp.TpdahpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;

public class HeatedPlateController implements Runnable {

	public HeatedPlateController() {
		
	}
	
	public boolean initController(HeatedPlateFrame heatedPlateFrame) {
		
		if (heatedPlateFrame == null) {
			return false;
		}
		
		this.heatedPlateFrame = heatedPlateFrame;
		Thread processThread = new Thread(this);
		processThread.start();
		
		return true;
	}
	
	
	public void initCommand(PlateCommandType plateCommandType,
							Integer dimension,
							Double leftEdgeTemperature,
							Double rightEdgeTemperature,
							Double topEdgeTemperature,
							Double bottomEdgeTemperature) {
		
		try {
			if (plate == null) {
				if (heatedPlateFrame != null) {
					HeatedPlateResultPanel heatedPlateResultPanel = heatedPlateFrame.getHeatedPlateResultPanel();
					
					
					this.plate = HeatedPlateFactory.createPlate(plateCommandType,
																 dimension,
																 leftEdgeTemperature,
																 rightEdgeTemperature,
																 topEdgeTemperature,
																 bottomEdgeTemperature); 
					
					this.command = HeatedPlateFactory.createCommand(plateCommandType, plate);
					heatedPlateResultPanel.initDisplay(dimension);
				}
			}
		} catch(Exception exception) {
			
		}
	}
	
	
	public void run() {
		if (heatedPlateFrame != null) {
			HeatedPlateResultPanel heatedPlateResultPanel = heatedPlateFrame.getHeatedPlateResultPanel();
		while(true) {
			if (plate != null) {
				try {
					do{
						plate = command.execute(plate);
						heatedPlateResultPanel.setDisplay(plate.toArray());
					} while ( command.getMaxDelta() > deltaThreshold || command.getIteration() < 1000000 );
				} catch(Exception exception) {					
				}		 
				plate = null;
				command = null;
			}
			 
			try {
				Thread.sleep(50);
			}catch(Exception e){}
		 }
		}
	 }
	
	private Plate plate;
	private Command command;
	public static double deltaThreshold = .01;
	private HeatedPlateFrame heatedPlateFrame;
}
