package edu.gatech.heatedplate.common;

import java.util.ArrayList;
import java.util.HashMap;

public interface Plate {
	
	public double[][] toArray();
	int getIteration();
	int getDimension();
	double getTop();
	double getRight();
	double getBottom();
	double getLeft();
}
