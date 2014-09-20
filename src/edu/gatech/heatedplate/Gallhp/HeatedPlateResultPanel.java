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
		
		return true;
	}
	
	 public Dimension getPreferredSize() {
		 return new Dimension(panelWidth, panelHeight);
	 }
	  
    private void paintSpot(Graphics aGraphics, int row, int col, double t) {
        int rowPos = PANEL_GRID_BORDER_GAP + row * panelHeight/5;
        int colPos = PANEL_GRID_BORDER_GAP + col * panelWidth/5;

        // Overwrite everything that was there previously
        aGraphics.setColor(Color.black);
        aGraphics.fillRect(colPos, rowPos, panelWidth/5, panelHeight/5);
        
        // Color in RGB format with green and blue values = 0.0
        aGraphics.setColor(new Color((float) Math.random(), 0.f, 0.f));    
        aGraphics.fillRect(colPos, rowPos, panelWidth/5, panelHeight/5);
    }
    
	protected void paintComponent(Graphics aGraphics) {
        super.paintComponent(aGraphics);
        
        BufferedImage bi = new BufferedImage(getWidth() - (2 * PANEL_GRID_BORDER_GAP), 
        									 getHeight() - (2 * PANEL_GRID_BORDER_GAP),
        									 BufferedImage.TYPE_INT_ARGB);
        Graphics anotherGraphics = bi.createGraphics();

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
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
}
