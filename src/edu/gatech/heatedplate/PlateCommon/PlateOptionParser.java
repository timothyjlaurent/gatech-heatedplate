package edu.gatech.heatedplate.PlateCommon;
/**
 * 
 * 
 * @author tlaurent
 *
 */
public class PlateOptionParser {
	
	public static PlateOptionObj parseOptions(String[] argv) throws Exception{
		int last; 
		PlateOptionObj optionObj = new PlateOptionObj();
		for ( int i = 0 ; i < argv.length ; i += 1 ){
			String cur = argv[i];
			int length;
			double left;
			double right;
			double top;
			double bottom;
			
			if (  cur.equals("-d") ){
				length = checkD( argv[ i + 1 ] );
				optionObj.setHeight(length);
				optionObj.setWidth(length);	
			}		
			if( cur.equals("-l") ){	
				cur = argv[i+1];
				try {
					left = Double.parseDouble(cur);
				} catch ( NumberFormatException e){
					throw new PlateException("-l must be followed by a number!");
				}
				if ( left < 0 || left > 100 ){
					throw new PlateException("-l must be between 0 and 100!");
				}
				optionObj.setLeft(left);		
			}
			if( cur.equals("-r") ){
				cur = argv[i+1];
				try {
					right = Double.parseDouble(cur);
				} catch ( NumberFormatException e){
					throw new PlateException("-r must be followed by a number!");
				}
				if ( right < 0 || right > 100 ){
					throw new PlateException("-r must be between 0 and 100!");
				}
				optionObj.setRight(right);
			}
			if( cur.equals("-t") ){
				cur = argv[i+1];
				try {
					top = Double.parseDouble(cur);
				} catch ( NumberFormatException e){
					throw new PlateException("-t must be followed by a number!");
				}
				if ( top < 0 || top > 100 ){
					throw new PlateException("-t must be between 0 and 100!");
				}
				optionObj.setTop(top);
			}
			if( cur.equals("-b") ){
				cur = argv[i+1];
				try {
					bottom = Double.parseDouble(cur);
				} catch ( NumberFormatException e){
					throw new PlateException("-b must be followed by a number!");
				}
				if ( bottom < 0 || bottom > 100 ){
					throw new PlateException("-b must be between 0 and 100!");
				}
				optionObj.setBottom(bottom);	
			}
		}	
		if( checkOptionObj(optionObj) == false ){
			throw new PlateException("Must include all command parameters: -d -l -r -t -b !");
		} 
		return optionObj;
		
	}

	
	public static int checkD(String l) throws PlateException{
		int length;
		try {
			length = Integer.parseInt( l );		
		} catch ( NumberFormatException e ){
			throw new PlateException("-d must be followed by an integer!");
		}
		if( length < 1 || length > 100 ){
			throw new PlateException("-d parameter must be between 1 and 100!");
		}
		return length;
	}
	
	
	
	
	private static boolean checkOptionObj(PlateOptionObj optionObj) {
		
		if ( new Integer(optionObj.height) == null ||
				new Integer(optionObj.getWidth()) == null ||
				new Double(optionObj.getLeft()) == null ||
				new Double(optionObj.getRight()) == null ||
				new Double(optionObj.getTop()) == null ||
				new Double(optionObj.getBottom()) == null){
			return false;
		}
		return true;
	}
	
}
