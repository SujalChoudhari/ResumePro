package com.sujal.resumepro.ui;

import javax.swing.JPanel;

import com.sujal.resumepro.controller.InputGuide;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

public class SkillPanel extends JPanel implements DataPanel {

	
	private InputGuide mInputGuide;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public SkillPanel(InputGuide inputGuide) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JPanel mainPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(mainPanel, gbc_panel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		mainPanel.add(panel_1);
		
		JLabel lblNewLabel = Factory.createTitleLabel("Skills");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		mainPanel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel bestLabel = Factory.createLabel("Best");
		panel_2.add(bestLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel goodLabel = Factory.createLabel("Good");
		panel_2.add(goodLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JLabel goodLabel2 = Factory.createLabel("Good");
		panel_2.add(goodLabel2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel goodLabel3 = Factory.createLabel("Good");
		panel_2.add(goodLabel3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		JLabel extraLabel = Factory.createLabel("Extra");
		panel_2.add(extraLabel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		JLabel extraLabel2 = Factory.createLabel("Extra");
		panel_2.add(extraLabel2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_2.add(textField_5);
		mInputGuide = inputGuide;
		
        JPanel navigationPanel = new JPanel();
        mainPanel.add(navigationPanel, BorderLayout.SOUTH);
        
        JButton prevButton = Factory.createButton("Previous");
        prevButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				previous();
			}
		});
        navigationPanel.add(prevButton);
        
        JButton nextButton = Factory.createButton("Next");
        nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				next();
			}
		});
        navigationPanel.add(nextButton);
	}

	@Override
	public void next() {
		mInputGuide.next();
	}

	@Override
	public void previous() {
		mInputGuide.previous();
	}

}
