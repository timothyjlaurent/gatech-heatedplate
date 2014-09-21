package edu.gatech.heatedplate.GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import edu.gatech.heatedplate.Gallhp.HeatedPlateResultPanel;

/************************************************************************************************************** 
 * @author Eric Griffin
 * @version 1.0
 * @since 21-Sep-14
 *  <br> 
 *  <p>
 *  <p><B>Course      :</B> Software Architecture and Design
 *  <p><B>Section     :</B> CS-6300-O01 
 *  <p><B>Term        :</B> Fall 2014
 *  <p><B>FileName    :</B> DemoGUI.java
 *  <p><B>Description:</B> 
 *  <p> <center><B> Project1 Heated Plate 
 *  <p> Graphical USer Interface 
 *  ,p>  This is a wireframe GUI necessary to perform a automated GUI test. There is no Business logic
 *  <p>   Only the skeleton code required to  properly simulate GUI component interaction 
 *  <p>  
 *
 * @see 
 * @see 
 **************************************************************************************************************/
public class DemoGUI extends JFrame {
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoGUI frame = new DemoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DemoGUI() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
	}
	
	/**
     * This method is called from within the constructor of the DemoGUI
     * and builds a simple wire frame User interface. No Business Logic has been implemented.
     */
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {
    		
    	
    	String[] algCmdObjLst = {"Tpdahp - (double array)","Tpfahp - (float array) ","Twfahp - (Float Wrapper Array)","Tpdohp  - (Object reference No Array)"};
    	
    	jComboBox1 = new javax.swing.JComboBox(algCmdObjLst);
    	jComboBox1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			RefreshVisualization();
    		}
    	});
        jScrollPane1 = new javax.swing.JScrollPane();
        
        JTextField textFieldDimension  = new javax.swing.JTextField();
    	
    	JTextField textFieldTop      = new javax.swing.JTextField();
    	JTextField textFieldBottom   = new javax.swing.JTextField();
    	JTextField textFieldLeft     = new javax.swing.JTextField();
    	JTextField textFieldRight    = new javax.swing.JTextField();
        
    	jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		executeAction();
        	}
        });
        this.setTitle("CS6310 - Heated Plate Simulation GUI");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        HeatedPlateResultPanel visualPlate = new  HeatedPlateResultPanel();
        jScrollPane1.setViewportView(visualPlate);

        jButton1.setText("Run Simulation");
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton1)
                        .addGap(0, 224, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }                        
    
    public void RefreshVisualization(){
    	
    	
    	
    		//TODO populate temperature and Iteration 
    		
    	
    }
    
    public void executeAction(){
     try{	
    	   //TODO valudate Inputs
    	   //TODO set invoker command
    	   //TODO run Simulation  
    	
    	 
        
       }
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
     
     
    		
    	
		
    	//TODO: Save jtextarea1 text to file
    }
    
    // hooks into UI for Robot test Automation                     
    public static javax.swing.JButton jButton1;
    public static javax.swing.JComboBox jComboBox1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    // End of Component variables declaration
    
}