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


	public TpdohpCommand(ObjectPlate heatedPlate){
		iteration = 0 ;
<<<<<<< HEAD
		newPlate = new ObjectPlate(op.getWidth(), op.getHeight(), 
				op.getTop(), op.getRight(), op.getBottom(), op.getLeft());
=======
		newPlate = new ObjectPlate  (heatedPlate.getWidth(), heatedPlate.getHeight(), 
				heatedPlate.getTop().getTemp(), heatedPlate.getRight().getTemp(), heatedPlate.getBottom().getTemp(), heatedPlate.getLeft().getTemp());
>>>>>>> branch 'master' of git@github.com:timothyjlaurent/gatech-heatedplate.git
	}


	public ObjectPlate execute(ObjectPlate oldPlate){
<<<<<<< HEAD
		newPlate = new ObjectPlate(oldPlate.getWidth(), oldPlate.getHeight(), 
				oldPlate.getTop(), oldPlate.getRight(), oldPlate.getBottom(), oldPlate.getLeft());
=======
		newPlate = new ObjectPlate (oldPlate.getWidth(), oldPlate.getHeight(), 
				oldPlate.getTop().getTemp(), oldPlate.getRight().getTemp(), oldPlate.getBottom().getTemp(), oldPlate.getLeft().getTemp());
>>>>>>> branch 'master' of git@github.com:timothyjlaurent/gatech-heatedplate.git
		int height = oldPlate.getHeight();
		int width = oldPlate.getWidth();
		this.iteration += 1 ;
		newPlate.setInteration((int)iteration);
		this.maxDelta = 0.0;
		for( int row = 0 ; row < height ; row += 1 ){
			for( int col = 0 ; col < width ; col += 1  ){
<<<<<<< HEAD
				newPlate.setGrid(row , col, oldPlate.getNextTemp( row, col) );
				double delta = getDelta(oldPlate, row , col );
=======
				newPlate.setGrid(row , col, oldPlate.getNextTemp(row, col));
   				double delta = getDelta(oldPlate, row , col );
>>>>>>> branch 'master' of git@github.com:timothyjlaurent/gatech-heatedplate.git
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


	public int getIteration(){
		return iteration ;	
	}
	
	public double getMaxDelta(){
		return maxDelta;
	}
	
	
	@Override
	public Plate execute(Plate plate) {
		// TODO Auto-generated method stub
		return null;
	}

}
