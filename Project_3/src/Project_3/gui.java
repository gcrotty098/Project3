package Project_3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.ArrayList;

public class gui extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JLabel hammingDistPrompt;
	private JTextField hammingDistInput;
	private JSlider hammingSlider;
	private JButton showStation;
	private JScrollPane scrollPane;
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
		positionConst.anchor = GridBagConstraints.WEST;		
		
		add(hammingDistPrompt, positionConst);
		
		//Input display
		hammingDistInput = new JTextField(5);
		hammingDistInput.setEditable(false);
		hammingDistInput.setText("1");
		
		positionConst.gridx = 1;
		positionConst.gridy = 0;
		positionConst.anchor = GridBagConstraints.WEST;		
		add(hammingDistInput, positionConst);
		
		//Slider input
		hammingSlider = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
		hammingSlider.setMajorTickSpacing(1);
		hammingSlider.setPaintTicks(true);
		hammingSlider.setPaintLabels(true);
		hammingSlider.setSnapToTicks(true);
		
		positionConst.gridx = 0;
		positionConst.gridy = 1;
		positionConst.gridwidth = 2;
		positionConst.anchor = GridBagConstraints.WEST;	
		add(hammingSlider, positionConst);
		hammingSlider.addChangeListener(null);
		
		//"Show Station" Button
		showStation = new JButton("Show Station");
		
		positionConst.gridx = 0;
		positionConst.gridy = 2;
		positionConst.gridwidth = 1;
		positionConst.anchor = GridBagConstraints.WEST;	
		add(showStation, positionConst);
		
		//Text Area Output
		stationDisplay = new JTextArea(15, 20);
		stationDisplay.setEditable(false);
		scrollPane = new JScrollPane(stationDisplay);
		
		positionConst.gridx = 0;
		positionConst.gridy = 3;
		positionConst.gridwidth = 3;
		positionConst.anchor = GridBagConstraints.WEST;	
		add(scrollPane, positionConst);
		
		//"Compare with:" Label
		compareWith = new JLabel("Compare with:");
		
		positionConst.gridx = 0;
		positionConst.gridy = 4;
		positionConst.gridwidth = 1;
		positionConst.anchor = GridBagConstraints.WEST;	
		add(compareWith, positionConst);
		
		//station drop-down list
		stationList = new JComboBox<String>();
		
		ArrayList<String> stids = HammingDistance.getAllStations();
		for(int i = 0; i < stids.size(); i++) {
			stationList.addItem(stids.get(i));
		}
		
		positionConst.gridx = 1;
		positionConst.gridy = 4;
		positionConst.gridwidth = 1;
		positionConst.anchor = GridBagConstraints.WEST;	
		add(stationList, positionConst);
		
		//Set part 2
		
		//"Calculate HD" button
		calculateHD = new JButton("Calculate HD");
		
		positionConst.gridx = 0;
		positionConst.gridy = 5;
		positionConst.gridwidth = 1;
		positionConst.anchor = GridBagConstraints.WEST;	
		add(calculateHD, positionConst);
		
		//Display distanceX and distanceY
		
		for(int i = 0; i < 5; i++) {
			//Distance x JLabel
			distanceX[i] = new JLabel("Distance " + String.valueOf(i));
			positionConst = new GridBagConstraints();
			positionConst.gridx = 0;
			positionConst.gridy = 6 + i;
			positionConst.insets = new Insets(0, 0, 10, 0);
			add(distanceX[i], positionConst);
			
			//Distance y JTextField
			distanceY[i] = new JTextField(6);
			distanceY[i].setEditable(false);
			positionConst = new GridBagConstraints();
			positionConst.gridx = 1;
			positionConst.gridy = 6 + i;
			positionConst.insets = new Insets(0, 0, 10, 0);
			add(distanceY[i], positionConst);
			
		}
		
		//Set part 3
		
		//Add Station Button
		
		positionConst.insets = new Insets(10, 10, 10, 10);
		
		addStation = new JButton("Add Station");
		
		positionConst.gridx = 0;
		positionConst.gridy = 11;
		positionConst.gridwidth = 1;
		positionConst.anchor = GridBagConstraints.WEST;	
		add(addStation, positionConst);
		
		//Add Station Input
		
		stationInput = new JTextField(6);
		stationInput.setEditable(true);
		
		positionConst.gridx = 1;
		positionConst.gridy = 11;
		positionConst.gridwidth = 1;
		positionConst.anchor = GridBagConstraints.WEST;	
		add(stationInput, positionConst);
		
		
	}
	
	public gui() {
		SetItems();
		
		SliderListener sliderListener = new SliderListener();
		ButtonListener buttonListener = new ButtonListener();
		hammingSlider.addChangeListener(sliderListener);
		showStation.addActionListener(buttonListener);
		calculateHD.addActionListener(buttonListener);
		addStation.addActionListener(buttonListener);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(500, 800);
	    pack();
	    setVisible(true);
	}
	
	class SliderListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			int value = source.getValue();
			
			hammingDistInput.setText(Integer.toString(value));
		}
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object source = e.getSource();
			
			if(source == showStation) {
				int hammingDistNum = Integer.valueOf(hammingDistInput.getText());
				String compareWithValue = stationList.getSelectedItem() == null ? "" : stationList.getSelectedItem().toString();
				
				if(compareWithValue.isBlank()) {
					return;
				}

				String output = HammingDistance.stationsViaHammingDistance(compareWithValue, hammingDistNum);
				
				//Do something with stationDisplay
				stationDisplay.setText(output);
				
				
			}else if(source == calculateHD) {
				
				String compareWithValue = stationList.getSelectedItem() == null ? "" : stationList.getSelectedItem().toString();
				
				if(compareWithValue.isBlank()) {
					return;
				}

				//Get values here
				
				for(int i = 0; i < 5; i++) {
					
					distanceY[i].setText(Integer.toString(HammingDistance.findNumStationsAtDistance(compareWithValue, i)));
				}
				
				
			}else if(source == addStation) {
				String addStationInput = stationInput.getText();
				
				//Do nothing with no text
				if(addStationInput.isBlank()) {
					return;
				}
				
				stationList.addItem(addStationInput);
				stationInput.setText("");
				
			}
				
		}
		
	}
	
	
}




