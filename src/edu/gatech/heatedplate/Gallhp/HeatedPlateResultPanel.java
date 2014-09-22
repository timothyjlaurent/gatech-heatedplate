package edu.gatech.heatedplate.Gallhp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import static edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.*;

public class HeatedPlateResultPanel extends JPanel {
	
	public HeatedPlateResultPanel() {		
	}
	
	public boolean initPanel(HeatedPlateFrame heatedPlateFrame) {
		
		if (heatedPlateFrame == null) {
			return false;
		}
		
		this.heatedPlateFrame = heatedPlateFrame;
		
		panelWidth = heatedPlateFrame.getWidth() - (CONTROL_PANEL_WIDTH + (2 * PANEL_FRAME_BORDER_GAP));
		panelHeight = heatedPlateFrame.getHeight();
		initColor = true;
		return true;
	}
	
	 public void initDisplay(int dimension) {
		 this.dimension = dimension;
		 initColor = true;
		 gridWidth = ((panelWidth%dimension) == 0)?panelWidth:(panelWidth-(panelWidth%dimension));
		 gridHeight = ((panelHeight%dimension) == 0)?panelHeight:(panelHeight-(panelHeight%dimension));
		 this.repaint();
	 }	 
	 
	 public void setDisplay(double[][] color) {
		 this.color = color;
		 initColor = false;
		 this.repaint();
	 }	 
	 
	 public Dimension getPreferredSize() {
		 return new Dimension(panelWidth, panelHeight);
	 }
	  
    private void paintSpot(Graphics aGraphics, int row, int col, double t) {
        int rowPos = PANEL_GRID_BORDER_GAP + row * gridHeight/dimension;
        int colPos = PANEL_GRID_BORDER_GAP + col * gridWidth/dimension;

        // Overwrite everything that was there previously
        aGraphics.setColor(Color.black);
        aGraphics.fillRect(colPos, rowPos, gridWidth/dimension, gridHeight/dimension);
        
        // Color in RGB format with green and blue values = 0.0
        if (initColor) {
        	aGraphics.setColor(new Color((float) Math.random(), 0.f, 0.f));
        } else {
        	aGraphics.setColor(new Color((float)color[row][col]/100, 0.f, 0.f));
        }
        
        
        aGraphics.fillRect(colPos, rowPos, gridWidth/dimension, gridHeight/dimension);
    }
    
	protected void paintComponent(Graphics aGraphics) {
        super.paintComponent(aGraphics);
        
        BufferedImage bi = new BufferedImage(getWidth() - (2 * PANEL_GRID_BORDER_GAP), 
        									 getHeight() - (2 * PANEL_GRID_BORDER_GAP),
        									 BufferedImage.TYPE_INT_ARGB);
        Graphics anotherGraphics = bi.createGraphics();

        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                // Instead of calling random, here is where you
                //   would insert the call that would provide
                //   the temperature of the corresponding cell
                //   on the heated plate.
                paintSpot(anotherGraphics, i, j, Math.random());
        
        aGraphics.drawImage(bi, 0, 0, this);
   }
	
	private HeatedPlateFrame heatedPlateFrame;
	private int panelWidth;
	private int panelHeight;
	private int gridWidth;
	private int gridHeight;
	private int dimension;
	private double[][] color;
	boolean initColor;
}
