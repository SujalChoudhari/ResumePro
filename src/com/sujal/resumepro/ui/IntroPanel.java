package com.sujal.resumepro.ui;


import javax.swing.*;

import com.sujal.resumepro.controller.InputGuide;
import com.sujal.resumepro.converter.CollectedData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroPanel extends JPanel implements DataPanel {
	
	private InputGuide mInputGuide;
	private JTextField mNameTextField;
	
    public IntroPanel(InputGuide inputGuide) {
    	mInputGuide = inputGuide;
        setLayout(new BorderLayout());

        JLabel titleLabel = Factory.createTitleLabel("Resume Pro");
        JLabel taglineLabel = Factory.createSubtitleLabel("Create Your Professional Resume");

        JPanel topPanel = Factory.createPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(taglineLabel, BorderLayout.CENTER);

        JPanel centerPanel = Factory.createPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mNameTextField = Factory.createTextField(18);
        centerPanel.add(new JLabel("What is your name? "));
        centerPanel.add(mNameTextField);
        
        JPanel bottomPanel = Factory.createPanel();
        JButton nextButton = Factory.createButton("Next");
        nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				next();
			}
        	
        });
        bottomPanel.add(nextButton);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);
    }

	@Override
	public void next() {
		mInputGuide.next();
		
	}

	@Override
	public void previous() {
		mInputGuide.previous();
	}
	
	@Override
	public void updateData() {
		CollectedData.name = mNameTextField.getText();
	}
	
	

}
