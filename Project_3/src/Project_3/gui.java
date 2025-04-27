package Project_3;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

public class gui extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JLabel hammingDistPrompt;
	private JTextField hammingDistInput;
	private JSlider hammingSlider;
	private JButton showStation;
	private JTextArea stationDisplay;
	private JLabel compareWith;
	private JComboBox<String> stationList;
	private JButton calculateHD;
	private JLabel[] distanceX = new JLabel[5];
	private JTextField[] distanceY = new JTextField[5];
	private JButton addStation;
	private JTextField stationInput;
	
	private void SetItems() {
		//Set GUI layout
		GridBagConstraints positionConst = null;
		
		//Window title
		setTitle("Project 3");
		
		setLayout(new GridBagLayout());
		positionConst = new GridBagConstraints();
		
		//Set part 1
		
		//First Prompt
		hammingDistPrompt = new JLabel("Enter Hamming Dist: ");
		
		positionConst.gridx = 0;
		positionConst.gridy = 0;
		positionConst.insets = new Insets(10, 10, 10, 10);
		
		add(hammingDistPrompt, positionConst);
		
		//First input
		hammingDistInput = new JTextField(5);
		
		
		
		//Set part 2
		
		//Set part 3
		
		
	}
	

	public gui() {
		SetItems();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(500, 400);

	    setVisible(true);
	}
}
