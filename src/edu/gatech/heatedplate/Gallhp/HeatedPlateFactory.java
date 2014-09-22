package edu.gatech.heatedplate.Gallhp;


import edu.gatech.heatedplate.common.Command;
import edu.gatech.heatedplate.common.Plate;
import edu.gatech.heatedplate.tpdahp.TpdahpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;
import edu.gatech.heatedplate.tpfahp.TpfahpCommand;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;
import edu.gatech.heatedplate.twfahp.TwfahpCommand;
import edu.gatech.heatedplate.twfahp.TwfahpPlate;
import edu.gatech.heatedplate.Tpdohp.ObjectPlate;
import edu.gatech.heatedplate.Tpdohp.TpdohpCommand;
import static edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.*;

public class HeatedPlateFactory {

	public HeatedPlateFactory() {		
	}
	
	public static Plate createPlate(PlateCommandType plateCommandType,
									Integer dimension,
									Double leftEdgeTemperature,
									Double rightEdgeTemperature,
									Double topEdgeTemperature,
									Double bottomEdgeTemperature) throws Exception {
		Plate plate = null;
        try {
			switch (plateCommandType) {
		        case PLATE_COMMAND_TYPE_TPDAHP:
		        	plate = new TpdahpPlate(dimension.intValue(), 
		        							leftEdgeTemperature.doubleValue(), 
		        							rightEdgeTemperature.doubleValue(), 
		        							topEdgeTemperature.doubleValue(), 
		        							bottomEdgeTemperature.doubleValue());
		            break; 
		        case PLATE_COMMAND_TYPE_TPFAHP:
		        	plate = new TpfahpPlate(dimension.intValue(), 
											leftEdgeTemperature.floatValue(), 
											rightEdgeTemperature.floatValue(), 
											topEdgeTemperature.floatValue(), 
											bottomEdgeTemperature.floatValue());
		            break;
		        case PLATE_COMMAND_TYPE_TWFAHP:
		        	plate = new TwfahpPlate(dimension.intValue(), 
											leftEdgeTemperature.floatValue(), 
											rightEdgeTemperature.floatValue(), 
											topEdgeTemperature.floatValue(), 
											bottomEdgeTemperature.floatValue());
		            break;
		        case PLATE_COMMAND_TYPE_TPDOHP:
		        	plate = new ObjectPlate(dimension, 
						        			dimension,
						        			topEdgeTemperature, 
											rightEdgeTemperature,											 
											bottomEdgeTemperature,
											leftEdgeTemperature);
		            break;
		 
		        default:
		        	throw new IllegalArgumentException("Invalid Plate Command Type");
	        }
		} catch (Exception exception) {
			throw exception;
		}
		
        return plate;
	}
}
