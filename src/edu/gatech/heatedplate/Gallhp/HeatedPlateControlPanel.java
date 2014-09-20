package edu.gatech.heatedplate.Gallhp;

import static edu.gatech.heatedplate.Gallhp.HeatedPlateConstant.*;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HeatedPlateControlPanel extends JPanel implements ActionListener {
	
	public HeatedPlateControlPanel() {		
	}
	
	public boolean initPanel(HeatedPlateFrame heatedPlateFrame) {
		
		if (heatedPlateFrame == null) {
			return false;
		}
		
		this.heatedPlateFrame = heatedPlateFrame;
		
		panelWidth = (heatedPlateFrame.getWidth() > CONTROL_PANEL_WIDTH)?CONTROL_PANEL_WIDTH:(CONTROL_PANEL_WIDTH/2);
		panelHeight = heatedPlateFrame.getHeight();
		
		addComponentToPanel();
		return true;
	}
	
	 public Dimension getPreferredSize() {
		 return new Dimension(panelWidth, 
				 			  panelHeight);
	 }
	  
    private void addComponentToPanel() {
    	
    	this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    	this.setLayout(new GridBagLayout());
		
        GridBagConstraints gBC = new GridBagConstraints();
		gBC.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel jLabel = new JLabel("<html><body style='width: 120 px'>Directions :Select height and " +
								   "width of plate. Then select " +
								   "top, right, bottom, and left " +
								   "temperatures. Then select" +
								   " an algorithm and click " +
								   "\"Go!\"");
		gBC.fill = GridBagConstraints.BOTH;
		gBC.insets = new Insets(10, 0, 0, 10);
		gBC.gridx = 0;
		gBC.gridy = 0;
		
		gBC.gridwidth = GridBagConstraints.REMAINDER;
		gBC.anchor = GridBagConstraints.LINE_START;
		this.add(jLabel, gBC);
				
		textFieldDimension = new JTextField(5);
		gBC.gridx = 0;
	    gBC.gridy = 1;
	    gBC.gridwidth =1;
	    textFieldDimension.setEditable(true);
	    this.add(textFieldDimension, gBC);

	    jLabel = new JLabel("Dimension");
	    gBC.gridx = 1;
	    gBC.gridy = 1;
	    gBC.gridwidth =1;
	    this.add(jLabel, gBC);
	     

		textFieldTop = new JTextField(5);
		gBC.gridx = 0;
		gBC.gridy = 3;
		gBC.gridwidth = 1;
		textFieldTop.setEditable(true);
		this.add(textFieldTop, gBC);
		
		jLabel = new JLabel("Top");
		gBC.gridx = 1;
		gBC.gridy = 3;
		gBC.gridwidth =1;
		this.add(jLabel, gBC);
			     
		textFieldBottom = new JTextField(5);
		gBC.gridx = 0;
		gBC.gridy = 4;
		gBC.gridwidth = 1;
		textFieldBottom.setEditable(true);
		this.add(textFieldBottom, gBC);

		jLabel = new JLabel("Bottom");
		gBC.gridx = 1;
		gBC.gridy = 4;
		gBC.gridwidth =1;
		this.add(jLabel, gBC);
				     
		textFieldLeft = new JTextField(5);
		gBC.gridx = 0;
		gBC.gridy = 5;
		gBC.gridwidth =1;
		textFieldLeft.setEditable(true);
		this.add(textFieldLeft, gBC);

		jLabel = new JLabel("Left");
		gBC.gridx = 1;
		gBC.gridy = 5;
		gBC.gridwidth =1;
		this.add(jLabel, gBC);
			     
		textFieldRight = new JTextField(5);
		gBC.gridx = 0;
		gBC.gridy = 6;
		gBC.gridwidth = 1;
		textFieldRight.setEditable(true);
		this.add(textFieldRight, gBC);

		jLabel = new JLabel("Right");
		gBC.gridx = 1;
		gBC.gridy = 6;
		gBC.gridwidth =1;
		this.add(jLabel, gBC);	     
		
		comboBoxCommandType = new JComboBox(new String[]{"Tpdahp", "Tpfahp", "Twfahp", "Tpdohp"});
		gBC.insets = new Insets(10,0,0,0);
	    gBC.gridx = 0;
	    gBC.gridwidth = 1;
	    gBC.gridy = 7;
	        
		this.add(comboBoxCommandType, gBC);	 
		
		JButton jbnButton = new JButton("Go");
		gBC.gridx = 0;
		gBC.gridy = 8;
		gBC.gridwidth = 1;
		this.add(jbnButton, gBC);	
		jbnButton.addActionListener(this);
	    gBC.gridy = GridBagConstraints.RELATIVE;
    }
    
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Go")) {
        	
        	if (heatedPlateFrame != null) {
        		HeatedPlateController heatedPlateController = heatedPlateFrame.getHeatedPlateController();
        		if (heatedPlateController != null) {
        			heatedPlateController.initCommand(PlateCommandType.values()[comboBoxCommandType.getSelectedIndex()],
        											  Integer.valueOf(textFieldDimension.getText()),
        											  Double.valueOf(textFieldTop.getText()),
        											  Double.valueOf(textFieldBottom.getText()),
        											  Double.valueOf(textFieldLeft.getText()),
        											  Double.valueOf(textFieldRight.getText()));
        		}
        	}
        }
    }

	private JTextField textFieldDimension;
	
	private JTextField textFieldTop;
	private JTextField textFieldBottom;
	private JTextField textFieldLeft;
	private JTextField textFieldRight;
	private JComboBox  comboBoxCommandType;
	
	private HeatedPlateFrame heatedPlateFrame;
	private int panelWidth;
	private int panelHeight;
}
