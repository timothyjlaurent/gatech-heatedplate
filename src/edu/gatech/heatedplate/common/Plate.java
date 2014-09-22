package edu.gatech.heatedplate.common;

import java.util.ArrayList;
import java.util.HashMap;

public interface Plate {
	
	HashMap<Integer, Plate> getTemp();
	void intializePlate();
	public double[][] toArray();
	
}
