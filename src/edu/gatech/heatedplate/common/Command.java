/**
 * 
 */
package edu.gatech.heatedplate.common;

/**
 * @author Griff
 *
 */
public interface Command {
	
	public Plate execute(Plate plate) ;
	public int getIteration();
}
