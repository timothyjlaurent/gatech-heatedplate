package edu.gatech.heatedplate.Gallhp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import edu.gatech.heatedplate.common.Plate;
import static edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.*;

public class HeatedPlateResultPanel extends JPanel implements Runnable {
	
	public HeatedPlateResultPanel() {		
	}
	
	public boolean initPanel(HeatedPlateFrame heatedPlateFrame) {
		
		if (heatedPlateFrame == null) {
			return false;
		}
		
		this.heatedPlateFrame = heatedPlateFrame;
		
		panelWidth = heatedPlateFrame.getWidth() - (CONTROL_PANEL_WIDTH + (2 * PANEL_FRAME_BORDER_GAP));
		panelHeight = heatedPlateFrame.getHeight();
		simulationProgress = false;
		
		Thread animationThread = new Thread(this);
		animationThread.start();
		return true;
	}
	
	 public void initDisplay(int dimension) {
		 this.dimension = dimension;
		 simulationProgress = true;
		 gridWidth = ((panelWidth%dimension) == 0)?panelWidth:(panelWidth-(panelWidth%dimension));
		 gridHeight = ((panelHeight%dimension) == 0)?panelHeight:(panelHeight-(panelHeight%dimension));
	 }	 
	 
	
	 
	  public void setDisplay(double[][] color) {
		 this.color = color;
		 simulationProgress = true;
	 }	 
	 
	 public void freezeDisplay() {
		 simulationProgress = false;
	 }	 
	 
	 public Dimension getPreferredSize() {
		 return new Dimension(panelWidth, panelHeight);
	 }
	 public void run() {
			while(true) {
				if (simulationProgress) {
					repaint();
				}			 
				
				try {
					Thread.sleep(50);
				} catch(Exception e) {
				
				}
			}
	 }
	 
    private void paintGrid(Graphics aGraphics) {
    	
    	try {
    	
	    	if (aGraphics != null) {
	    	
		    	int rowPos = 0;
		    	int colPos = 0;
		    	 for (int i = 0; i < dimension; i++) {
		    		for (int j = 0; j < dimension; j++) {
		    	
		    			rowPos = PANEL_GRID_BORDER_GAP + i * gridHeight/dimension;
		    			colPos = PANEL_GRID_BORDER_GAP + j * gridWidth/dimension;
		
				        aGraphics.setColor(Color.black);
				        aGraphics.fillRect(colPos, rowPos, gridWidth/dimension, gridHeight/dimension);       
				        
				        if (!simulationProgress) {
				        	aGraphics.setColor(new Color(0.f, 0.f, 0.f));
				        } else {
				        	aGraphics.setColor(new Color((float)color[i][j]/100, 0.0f, 0.f));
				        }
				        aGraphics.fillRect(colPos, rowPos, gridWidth/dimension, gridHeight/dimension);
		    		}
		    	}
		        
	    	}
		 } catch(Exception exception) {
			        	
		}
    }
    
	protected void paintComponent(Graphics aGraphics) {
        super.paintComponent(aGraphics);
        
        BufferedImage bufferedImage = new BufferedImage(getWidth() - (2 * PANEL_GRID_BORDER_GAP), 
        									 getHeight() - (2 * PANEL_GRID_BORDER_GAP),
        									 BufferedImage.TYPE_INT_ARGB);
        Graphics anotherGraphics = bufferedImage.createGraphics();
        paintGrid(anotherGraphics);
        
        aGraphics.drawImage(bufferedImage, 0, 0, this);
   }
	
	private HeatedPlateFrame heatedPlateFrame;
	private int panelWidth;
	private int panelHeight;
	private int gridWidth;
	private int gridHeight;
	private int dimension;
	private double[][] color;
	private boolean simulationProgress;
	
}
