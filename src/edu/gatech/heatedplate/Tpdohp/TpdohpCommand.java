package edu.gatech.heatedplate.Tpdohp;

import edu.gatech.heatedplate.common.Command;
import edu.gatech.heatedplate.common.Plate;


/**
 * Command 
 * @author tlaurent
 *
 */
public class TpdohpCommand implements Command {
	private int iteration ;
	private double maxDelta ;
	private ObjectPlate newPlate;


	public TpdohpCommand(ObjectPlate op){
		iteration = 0 ;
//		newPlate = new ObjectPlate(op.getWidth(), op.getHeight(), 
//				op.getTop(), op.getRight(), op.getBottom(), op.getLeft());

	}

	@Override
	public Plate execute(Plate op){
//		newPlate = new ObjectPlate(oldPlate.getWidth(), oldPlate.getHeight(), 
//				oldPlate.getTop(), oldPlate.getRight(), oldPlate.getBottom(), oldPlate.getLeft());
		ObjectPlate oldPlate = (ObjectPlate)op;
		newPlate = new ObjectPlate(oldPlate);
		int height = oldPlate.getHeight();
		int width = oldPlate.getWidth();
		this.maxDelta = 0.0;
		for( int row = 0 ; row < height ; row += 1 ){
			for( int col = 0 ; col < width ; col += 1  ){
				newPlate.setGrid(row , col, oldPlate.getNextTemp( row, col) );
				double delta = getDelta(oldPlate, row , col );

				if( Math.abs( delta ) > maxDelta ){
					this.maxDelta = Math.abs(delta);
				}
			}
		}
		newPlate.setMaxDelta(this.maxDelta);
		return newPlate;
	}
	
	private double getDelta(ObjectPlate oldPlate, int row, int col) {
		double oldT = oldPlate.getTemp(row, col);
		double newT = this.newPlate.getTemp(row, col);
		double delta = newT - oldT;
		return delta;
	}

	@Override
	public int getIteration(){
		return iteration ;	
	}
	
	@Override
	public double getMaxDelta(){
		return maxDelta;
	}
	
	


}
