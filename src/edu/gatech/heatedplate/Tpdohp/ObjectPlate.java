package edu.gatech.heatedplate.Tpdohp;

import edu.gatech.heatedplate.PlateCommon.IterationMessage;
import edu.gatech.heatedplate.PlateCommon.Plate;

public class ObjectPlate extends Plate {
	Integer height;  // dimensions
	Integer width;   // dimensions
	GridObj top;      // temperatures
	GridObj bottom;   // ''
	GridObj right;    // ''
	GridObj left;     // ''
	GridObj upperLeft; // the upper left grid coordinate
	Integer iteration; // the iteration #
	Double maxDelta;
	
	@Override
	public IterationMessage initializePlate(int height, int width, double top,
			double right, double bottom, double left) {
		this.height = height;
		this.width = width;
		this.top = new GridObj(-1,-1, top);
		this.right = new GridObj(-1,-1,right);
		this.left = new GridObj(-1,-1,left);
		this.bottom = new GridObj(-1,-1,bottom); 
		this.iteration = 0 ;
		this.buildGrid();
		return this.makeMessage();
	}

	private IterationMessage makeMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IterationMessage iterate() {
		// TODO Auto-generated method stub
		return new IterationMessage();
	}

	
	
	private void buildGrid(){
		upperLeft = new GridObj(0,0,0);	
		upperLeft.growGrid();
	}
	
	
	
	private class GridObj{
		GridObj ln; // coordinate neighbors
		GridObj rn;
		GridObj un;
		GridObj dn;
		int x;
		int y;
		double temp;
		
		public GridObj(int x, int y, double temp) {
			x=x;
			y=y;
			temp=temp;
		}

		public void growGrid() {
			this.detectEdges();
			if ( un == null ){
				un = ln.un.rn;
				un.dn = this;
			}
			if ( rn == null ){
				rn = new GridObj(x + 1, y , 0 );
				rn.ln = this;
				rn.growGrid();
			}
			if ( x == 0 ){
				dn = new GridObj( x, y+1 , 0 );
				dn.un = this;
				dn.growGrid();
			}
			if ( x == width + 1 && y == height + 1 ){
				return;
			}		
		}

		private void detectEdges() {
			if( x == 0 ){
				ln = left;
			}
			if ( y == 0 ){
				un = top;
			}
			if (y == height - 1 ){
				dn = bottom;
			}
			if ( x == width - 1 ){
				rn = right;
			}
		}
	}
	
}
