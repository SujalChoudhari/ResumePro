package com.sujal.resumepro.ui;

import javax.swing.JPanel;

import com.sujal.resumepro.controller.InputGuide;
import com.sujal.resumepro.converter.PdfConverter;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class EndDataPanel extends JPanel implements DataPanel {

	private InputGuide mInputGuide;

	public EndDataPanel(InputGuide inputGuide) {
		mInputGuide = inputGuide;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		
		JLabel lblDone = Factory.createTitleLabel("Done!");
		panel.add(lblDone);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		
		JLabel lblNewLabel_1 = Factory.createSubtitleLabel("Now you can print out your resume.");
		panel_1.add(lblNewLabel_1);
		
		JPanel bottomPanel = Factory.createPanel();
		JButton prevButton = Factory.createButton("Previous");
        prevButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				previous();
			}
        	
        });
        bottomPanel.add(prevButton);
        JButton nextButton = Factory.createButton("Print");
        nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				next();
			}
        	
        });
        bottomPanel.add(nextButton);
        
        
        panel_2.add(bottomPanel);

	}

	@Override
	public void next() {
		mInputGuide.updateData();
		PdfConverter.run();
	}

	@Override
	public void previous() {
		mInputGuide.previous();
		
	}

	@Override
	public void updateData() {
		
		
	}

}
